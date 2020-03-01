#include "updateactivity.h"
#include "ui_updateactivity.h"

UpdateActivity::UpdateActivity(QWidget *parent) :
    OuterWidget(parent),
    ui(new Ui::UpdateActivity)
{
    ui->setupUi(this);
}

UpdateActivity::UpdateActivity(QWidget *parent,const MainActivity & main_act):
    OuterWidget(parent),main_act_(main_act),
    ui(new Ui::UpdateActivity)
{
    ui->setupUi(this);
    nam_.reset(new QNetworkAccessManager());
    connect(nam_.get(),&QNetworkAccessManager::finished,this,&UpdateActivity::dealGetHttpData);

    initWinResource();



}

UpdateActivity::~UpdateActivity()
{
    delete ui;
}

void UpdateActivity::initWinResource()
{

    this->setStyleSheet(ReadQStyleSheet::readQss(""));
    this->setWindowFlags(Qt::FramelessWindowHint|Qt::WindowStaysOnTopHint);   //设置窗口无边框
    this->setAttribute(Qt::WA_TranslucentBackground);  //设置主窗口背景透明

    QGraphicsDropShadowEffect * shadow = new QGraphicsDropShadowEffect(this);
    shadow->setOffset(0,0);   //阴影偏移量
    shadow->setColor(Qt::black);  //阴影颜色
    shadow->setBlurRadius(10);     //阴影的模糊半径
    ui->widgetInner->setGraphicsEffect(shadow);

    //  所有基础信息
    QString date = main_act_.get_dead_time();
    ui->label_id->setText(QString::number(main_act_.get_a_id()));
    ui->lineEdit_address->setText(main_act_.get_address());
    ui->lineEdit_name->setText(main_act_.get_name());
    ui->textEdit_abstract->setText(main_act_.get_abstract());
    ui->textEdit_description->setText(main_act_.get_description());
    ui->dateEdit_dead_time->setDate(QDate(date.section("-",0,0).toInt(),
                                          date.section("-",1,1).toInt(),
                                          date.section("-",2,2).toInt()
                                          )
                                    );
    ui->label_create_time->setText(main_act_.get_create_time());
    ui->label_join_num->setText(QString::number(main_act_.get_participation()));
    status_ = 1;
    nam_->get(QNetworkRequest(QUrl(ReadQStyleSheet::g_ip_url+QString("/manager/getAllManager?aId=%1").arg(main_act_.get_a_id()))));
}

void UpdateActivity::dealGetHttpData(QNetworkReply *reply)
{
    switch(status_)
    {
    case 1:
        dealGetAllManagerReturnInfo(reply);
        break;
    case 2:
        break;
    default:
        break;
    }
}

void UpdateActivity::dealGetAllManagerReturnInfo(QNetworkReply *reply)
{
    if(reply->error()==QNetworkReply::NoError)
    {
        QByteArray bytes = reply->readAll();
        QString string = QString::fromUtf8(bytes);
        QJsonParseError json_error;
        QJsonDocument json_document = QJsonDocument::fromJson(bytes,&json_error);
        if(json_error.error!=QJsonParseError::NoError)
        {
            Cout<<"数据解析错误";
            return;
        }

        QJsonArray json_arr;
        if(json_document.object().contains("managerData"))
        {
            json_arr = json_document.object().value("managerData").toArray();
            for(int i = 0;i<json_arr.size();i++)
            {
                QJsonObject obj_user = json_arr[i].toObject().value("user").toObject();
                QListWidgetItem * item = new QListWidgetItem(ui->listWidget_act_manager);
                ManagerItem * m_item = new ManagerItem(ui->listWidget_act_manager,
                                                       obj_user.value("uName").toString(),
                                                       obj_user.value("uId").toString(),
                                                       obj_user.value("uPhone").toString()
                                                       );
                ui->listWidget_act_manager->addItem(item);
                ui->listWidget_act_manager->setItemWidget(item,m_item);
                item->setSizeHint(QSize(0,52));
                Cout<<obj_user.value("uId").toString();
            }
        }

    }
    else
    {
        Cout<<"数据解析错误";
    }
    reply->deleteLater();
}

void UpdateActivity::on_toolButton_close_clicked()
{
    this->close();
}

void UpdateActivity::on_toolButton_min_clicked()
{
    this->showMinimized();
}

void UpdateActivity::on_pushButton_update_image_clicked()
{
    list_ = QFileDialog::getOpenFileNames(this,QString("选择图片"),tr("./"),tr("图片(*.jpg *.png);;"));
    ui->label_show_image_num->setText(QString("已选择%1张图片").arg(list_.size()));
}

void UpdateActivity::on_pushButton_sure_clicked()
{

}

void UpdateActivity::on_pushButton_cancel_clicked()
{
    this->close();
}
