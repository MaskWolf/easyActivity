#include "login.h"
#include "ui_login.h"

Login::Login(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::Login)
{
    ui->setupUi(this);
    nam_.reset(new QNetworkAccessManager());
    connect(nam_.get(),&QNetworkAccessManager::finished,this,&Login::dealGetData);
    initWinRource();
    connect(ui->comboBox_id,&MyComboBox::changeBkColor,this,[=](bool is_normal){
        if(is_normal)
        {
            ui->widgetId->setStyleSheet("border-bottom:1px solid rgb(184,186,188);");
            ui->comboBox_id->setStyleSheet("border:none");
            ui->label_id->setPixmap(QPixmap(":/Login/C:/Users/ASUS/Pictures/Login/human-1-fill-gray.png"));
            //ui->comboBox_id->setEditText(curr_combobox_text_);
        }
        else
        {
            ui->widgetId->setStyleSheet("border-bottom:1px solid rgb(18,183,245)");
            ui->comboBox_id->setStyleSheet("border:none");
            ui->label_id->setPixmap(QPixmap(":/Login/C:/Users/ASUS/Pictures/Login/human-1-fill-blue.png"));
            //ui->comboBox_id->setEditText(curr_combobox_text_);
        }
    });

    connect(ui->lineEdit_password,&MyLineEdit::changeBkColor,this,[=](bool is_normal){
        if(is_normal)
        {
            ui->widgetPwd->setStyleSheet("border-bottom:1px solid rgb(184,186,188);");
            ui->lineEdit_password->setStyleSheet("border:none");
            ui->label_pwd->setPixmap(QPixmap(":/Login/C:/Users/ASUS/Pictures/Login/lock.png"));
        }
        else
        {
            ui->widgetPwd->setStyleSheet("border-bottom:1px solid rgb(18,183,245)");
            ui->lineEdit_password->setStyleSheet("border:none");
            ui->label_pwd->setPixmap(QPixmap(":/Login/C:/Users/ASUS/Pictures/Login/lockfill.png"));
        }
    });

    rt_.reset(new ReplyTimeout());
    connect(rt_.get(),&ReplyTimeout::timeout,this,[=](){
        show_dialog_->showDialog("连接超时");
        ui->pushButton_login_id_and_pwd->setText("登陆");
        ui->pushButton_login_id_and_pwd->setEnabled(true);
    });
    show_dialog_.reset(new ShowMessage(0,""));
}

Login::~Login()
{
    delete ui;
}

void Login::initWinRource()
{
    //Qt::WindowStaysOnTopHint  设置显示在最顶层
    this->setWindowFlags(Qt::FramelessWindowHint|Qt::WindowStaysOnTopHint);   //设置窗口无边框
    this->setAttribute(Qt::WA_TranslucentBackground);  //设置主窗口背景透明
    this->setStyleSheet(ReadQStyleSheet::readQss(":/qss/qss_login.qss"));

    QGraphicsDropShadowEffect * shadow = new QGraphicsDropShadowEffect(this);
    shadow->setOffset(0,0);   //阴影偏移量
    shadow->setColor(Qt::black);  //阴影颜色
    shadow->setBlurRadius(10);     //阴影的模糊半径
    ui->LoginInner->setGraphicsEffect(shadow);
    z_ = QPoint(0,0);


    ui->comboBox_id->addItems(QStringList{"zhangsan","李四","王五"});

}

void Login::mouseMoveEvent(QMouseEvent * e)
{
    QPoint afterMovePos = e->globalPos();
    if(z_.x()!=0&&z_.y()!=0)
    {
        QPoint moveDis = afterMovePos-z_;
        move(moveDis);
    }

}

void Login::mousePressEvent(QMouseEvent * e)
{
    QPoint currGlobalPos = e->globalPos();              //当前鼠标的全局位置
    QPoint currLocPos = this->geometry().topLeft();    //当前鼠标点击窗口的左上角坐标
    z_ = currGlobalPos-currLocPos;
}

void Login::mouseReleaseEvent(QMouseEvent *)
{
    z_ = QPoint(0,0);
}

void Login::on_toolButton_clicked()
{
    this->close();
}

void Login::on_toolButtonTonote_clicked()
{
    ui->stackedWidgetLeft->setCurrentIndex(1);
}

void Login::on_toolButtonToId_clicked()
{
    ui->stackedWidgetLeft->setCurrentIndex(0);
}

void Login::on_toolButtonRegister_clicked()
{
    register_.reset(new Register());
    register_->show();
}

void Login::on_pushButton_login_clicked()
{
    QString id = ui->comboBox_id->currentText();
    QString pwd = ui->lineEdit_password->text();

    // 服务器验证
    //User user(id,"无心",pwd,"相信但不迷失",true,"c:","123644545545","qqdada@qq.com");
    //emit isOk(user);
//    qDebug()<<"发送消息";
//    this->close();
}

void Login::on_pushButton_login_id_and_pwd_clicked()
{
    QString id = ui->comboBox_id->currentText();
    QString pwd = ui->lineEdit_password->text();

    QUrl url(ReadQStyleSheet::g_ip_url+"/user/login");
    QByteArray append = QString("uName=%1&uPassword=%2").arg(id).arg(pwd).toUtf8();
    QNetworkReply * reply = nam_->post(QNetworkRequest(url),append);

    rt_->checking(reply,10000);    // 10s 超时时间

    ui->pushButton_login_id_and_pwd->setText("登陆中.....");
    ui->pushButton_login_id_and_pwd->setEnabled(false);
//    // 服务器验证
//    User user(1,"无心","pwd","相信但不迷失",true,"c:","123644545545","qqdada@qq.com");
//    emit isOk(user);
//    qDebug()<<"发送消息";
//    this->close();
}

void Login::dealGetData(QNetworkReply *reply)
{
    over_timer_ = false;
    // 状态码
    int statusCodeV = reply->attribute(QNetworkRequest::HttpStatusCodeAttribute).toInt();
//    qDebug()<<statusCodeV;
    //QVariant redirectionTargetUrl = reply->attribute(QNetworkRequest::RedirectionTargetAttribute);
    if(reply->error()==QNetworkReply::NoError)
    {
        QByteArray bytes = reply->readAll();
        QString string = QString::fromUtf8(bytes);
//        Cout<<string;

        QJsonParseError json_error;
        QJsonDocument  json_document = QJsonDocument::fromJson(bytes,&json_error);
        if(json_error.error!=QJsonParseError::NoError)
        {
            Cout<<"数据解析错误";
            return;
        }
        bool is_login = json_document.object().value("loginSuccess").toBool();
        //show_dialog_->showDialog("登录成功！！！");
        if(is_login)
        {

            QJsonObject obj = json_document.object().value("userData").toObject();
            QString pic_url = json_document.object().value("userImage").toString();

            // 发送信号到主程序
            emit isOk(User(obj.value("uId").toInt(),
                      obj.value("uName").toString(),
                      obj.value("uPassword").toString(),
                      obj.value("uSignature").toString(),
                      obj.value("uSex").toBool(),
                      pic_url,
                      obj.value("uPhone").toString(),
                      obj.value("uEmail").toString()
                      ));

            this->close();
        }
        else
        {
            show_dialog_->showDialog(json_document.object().value("loginMessage").toString());
            ui->pushButton_login_id_and_pwd->setText("登陆");
            ui->pushButton_login_id_and_pwd->setEnabled(true);
        }

    }
    else
    {

    }
    reply->deleteLater();
}

void Login::on_toolButton_3_clicked()
{
    ui->stackedWidget->setCurrentIndex(1);
}

void Login::on_pushButton_sure_clicked()
{
    QString url = ui->lineEdit_url->text();
    ReadQStyleSheet::setUrl(url);
    ui->stackedWidget->setCurrentIndex(0);
}

void Login::on_pushButton_cancel_clicked()
{
    ui->stackedWidget->setCurrentIndex(0);
}

void Login::on_toolButton_close_clicked()
{
    this->close();
}

void Login::on_toolButton_set_clicked()
{
    ui->stackedWidget->setCurrentIndex(1);
}
