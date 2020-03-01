#include "writecomment.h"
#include "ui_writecomment.h"



WriteComment::WriteComment(const User &wc_user,const User & c_user,int p_id):
    ui(new Ui::WriteComment),wc_user_(wc_user),c_user_(c_user),p_id_(p_id)
{
    ui->setupUi(this);

    ui->label->setText(QString("评论%1的动态").arg(wc_user_.get_nickname()));

    nam_.reset(new QNetworkAccessManager());
    connect(nam_.get(),&QNetworkAccessManager::finished,this,&WriteComment::dealGetHttpData);
    initComment();
    initWinResource();
}

WriteComment::WriteComment(const QString & act_name,const User &c_user, int p_id):
    ui(new Ui::WriteComment),p_id_(p_id),c_user_(c_user)
{
    ui->setupUi(this);

    ui->label->setText(QString("评论%1").arg(act_name));

    nam_.reset(new QNetworkAccessManager());
    connect(nam_.get(),&QNetworkAccessManager::finished,this,&WriteComment::dealGetHttpData);
    initComment();
    initWinResource();
}

void WriteComment::deal_reply_comment(const QString &user_name, const QString &content,int c_id)
{
    QString str = QString("回复%1:").arg(user_name);
    ui->textEdit->setText(str);
    r_name_ = user_name;
    content_ = content;
    c_id_ = c_id;
}

WriteComment::~WriteComment()
{
    delete ui;
}

void WriteComment::mouseMoveEvent(QMouseEvent * e)
{
    QPoint afterMovePos = e->globalPos();
    if(z_.x()!=0&&z_.y()!=0)
    {
        QPoint moveDis = afterMovePos-z_;
        move(moveDis);
    }
}

void WriteComment::mousePressEvent(QMouseEvent * e)
{
    QPoint currGlobalPos = e->globalPos();              //当前鼠标的全局位置
    QPoint currLocPos = this->geometry().topLeft();    //当前鼠标点击窗口的左上角坐标
    z_ = currGlobalPos-currLocPos;
}

void WriteComment::mouseReleaseEvent(QMouseEvent *)
{
    z_ = QPoint(0,0);
}

void WriteComment::initComment()
{
    // 由动态的id获取动态的所有评论
    QString url = ReadQStyleSheet::g_ip_url+QString("/manager/getComments?pId=%1").arg(p_id_);
    nam_->get(QNetworkRequest(QUrl(url)));
    status_ = 1;


//    QStringList list;
//    list<<"第一个"<<"不知道他是干嘛的"<<"n你tm有毒";
//    for(int i = 0;i<3;i++)
//    {
//        QListWidgetItem * item = new QListWidgetItem(ui->listWidget_show_coment);
//        CommentItem * c_item = new CommentItem(ui->listWidget_show_coment,1,c_user_,list[i]);
//        item->setSizeHint(QSize(0,c_item->height()));
//        ui->listWidget_show_coment->addItem(item);
//        ui->listWidget_show_coment->setItemWidget(item,c_item);
//        connect(c_item,&CommentItem::replyComment,this,&WriteComment::deal_reply_comment);
//    }

}

void WriteComment::initWinResource()
{
    this->setStyleSheet(ReadQStyleSheet::readQss(":/qss/qss_writecomment.qss"));  // 设置qss样式
    this->setWindowFlags(Qt::FramelessWindowHint);   //设置窗口无边框
    this->setAttribute(Qt::WA_TranslucentBackground);  //设置主窗口背景透明
    QGraphicsDropShadowEffect * shadow = new QGraphicsDropShadowEffect(this);
    shadow->setOffset(0,0);   //阴影偏移量
    shadow->setColor(Qt::black);  //阴影颜色
    shadow->setBlurRadius(5);     //阴影的模糊半径
    ui->widgetInner->setGraphicsEffect(shadow);
}

void WriteComment::dealGetHttpData(QNetworkReply *reply)
{
    switch(status_)
    {
    case 1:
        dealGetCommentReturnInfo(reply);
        break;
    case 2:

        break;
    default:
        break;
    }
}

void WriteComment::dealGetCommentReturnInfo(QNetworkReply *reply)
{
    if(reply->error()==QNetworkReply::NoError)
    {
        QByteArray bytes = reply->readAll();
        QString string = QString::fromUtf8(bytes);
//        Cout<<string;


        QJsonParseError json_error;
        QJsonDocument json_document = QJsonDocument::fromJson(bytes,&json_error);
        if(json_error.error!=QJsonParseError::NoError)
        {
            Cout<<"数据解析错误";
            return;
        }

        if(json_document.object().contains("commentData"))
        {
            QJsonArray json_arr = json_document.object().value("commentData").toArray();
            QJsonObject obj;
            QMap<int,QPair<QString,QString>>comment_data;
            for(int i = 0;i<json_arr.size();++i)
            {
                obj = json_arr[i].toObject();
                QJsonObject to_user = obj.value("toUser").toObject();       //被回复的对象
                QJsonObject from_user = obj.value("fromUser").toObject();   //发出评论的对象

                comment_data[obj.value("cId").toInt()] = QPair<QString,QString>(from_user.value("uName").toString(),
                                                                                obj.value("content").toString());

                //User u_temp(userData.value("uName").toString(),obj.value("userImage").toString());

                User u_temp(from_user.value("uName").toString(),obj.value("fromUserImage").toString());//发布此评论的用户

                if(obj.value("toCid").toInt() == 0)    //直接评论动态
                {
//                    Cout<<"直接评论动态"<<u_temp.get_nickname()<<"   "<<u_temp.get_headpath();
                    QListWidgetItem * item3 = new QListWidgetItem(ui->listWidget_show_coment);
                    CommentItem * c_item3 = new CommentItem(ui->listWidget_show_coment,
                                                            obj.value("cId").toInt(),
                                                            u_temp,  //发布此评论的用户
                                                            obj.value("content").toString(),
                                                            obj.value("commentTime").toString()
                                                            );
                    item3->setSizeHint(QSize(0,c_item3->height()));
                    ui->listWidget_show_coment->addItem(item3);
                    ui->listWidget_show_coment->setItemWidget(item3,c_item3);
                    connect(c_item3,&CommentItem::replyComment,this,&WriteComment::deal_reply_comment);
                }
                else    // 在动态中回复他人的评论
                {


//                    Cout<<"回复别人评论"<<u_temp.get_nickname()<<"   "<<u_temp.get_headpath();
                    QListWidgetItem * item3 = new QListWidgetItem(ui->listWidget_show_coment);
                    CommentItem * c_item3 = new CommentItem(ui->listWidget_show_coment,
                                                            obj.value("cId").toInt(),
                                                            u_temp,
                                                            obj.value("content").toString(),
                                                            comment_data.value(obj.value("toCid").toInt()).first,
                                                            comment_data.value(obj.value("toCid").toInt()).second,
                                                            obj.value("commentTime").toString()
                                                            );
//                    Cout<<obj.value("cId").toInt();
                    item3->setSizeHint(QSize(0,c_item3->height()));
                    ui->listWidget_show_coment->addItem(item3);
                    ui->listWidget_show_coment->setItemWidget(item3,c_item3);
                    connect(c_item3,&CommentItem::replyComment,this,&WriteComment::deal_reply_comment);
                }

            }
        }
    }

}

void WriteComment::on_pushButton_comment_clicked()
{
    QString content = ui->textEdit->toPlainText();

    string str = "回复"+r_name_.toStdString()+":";

    QString url = ReadQStyleSheet::g_ip_url+"/manager/comment";

    QNetworkRequest request;
    request.setUrl(url);
    request.setHeader(QNetworkRequest::ContentTypeHeader,"application/x-www-form-urlencoded");
    status_ = 2;  //设置标志位


    if(content.toStdString().find(str)!=string::npos)
    {
        Cout<<"对评论进行评论";
        content.replace(QString(str.data()),""); //将前面的提示去除
        QListWidgetItem * item3 = new QListWidgetItem(ui->listWidget_show_coment);
        CommentItem * c_item3 = new CommentItem(ui->listWidget_show_coment,p_id_,c_user_,content,r_name_,content,QDate::currentDate().toString("yyyy-MM-dd"));
        item3->setSizeHint(QSize(0,c_item3->height()));
        ui->listWidget_show_coment->addItem(item3);
        ui->listWidget_show_coment->setItemWidget(item3,c_item3);

        QString data = QString("pId=%1&fromUid=%2&toCid=%3&content=%4").arg(p_id_).arg(c_user_.get_id()).arg(c_id_).arg(content);
        Cout<<data;
        nam_->post(request,data.toUtf8());
    }
    else
    {
        Cout<<"普通评论";
        QListWidgetItem * item3 = new QListWidgetItem(ui->listWidget_show_coment);
        CommentItem * c_item3 = new CommentItem(ui->listWidget_show_coment,p_id_,c_user_,content,QDate::currentDate().toString("yyyy-MM-dd"));
        item3->setSizeHint(QSize(0,c_item3->height()));
        ui->listWidget_show_coment->addItem(item3);
        ui->listWidget_show_coment->setItemWidget(item3,c_item3);
        QString data = QString("pId=%1&fromUid=%2&toCid=%3&content=%4").arg(p_id_).arg(c_user_.get_id()).arg(0).arg(content);
        Cout<<data;
        nam_->post(request,data.toUtf8());
    }

    ui->textEdit->clear();

}

void WriteComment::on_toolButton_close_clicked()
{
    this->close();
}

void WriteComment::on_pushButton_update_clicked()
{
    ui->listWidget_show_coment->clear();
    initComment();
}
