#include "register.h"
#include "ui_register.h"

Register::Register(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::Register)
{
    ui->setupUi(this);
    initWinRource();
    nam_.reset(new QNetworkAccessManager());
    connect(nam_.get(),&QNetworkAccessManager::finished,this,[=](QNetworkReply * reply){
        if(reply->error()==QNetworkReply::NoError)
        {
            QByteArray bytes = reply->readAll();
            QJsonParseError json_error;
            QJsonDocument json_document = QJsonDocument::fromJson(bytes,&json_error);
            if(json_error.error!=QJsonParseError::NoError)
            {
                Cout<<"数据解析错误";
                return;
            }
            QJsonObject obj = json_document.object();
            bool is_ok = obj.value("registerSuccess").toBool();
            QString message = obj.value("registerMessage").toString();
            if(is_ok)
            {
                ui->stackedWidget->setCurrentIndex(1);
                ui->label_user_name->setText(ui->lineEdit_user_name->text());
                ui->label_pwd->setText(ui->lineEdit_pwd->text());
            }
            else
            {
                QMessageBox::warning(this,"错误",message,QMessageBox::Ok);
            }
        }
        else
        {
            QMessageBox::warning(this,"错误","出现未知错误，请重试",QMessageBox::Ok);
        }
        reply->deleteLater();
    });
}

Register::~Register()
{
    delete ui;
}

void Register::mouseMoveEvent(QMouseEvent * e)
{
    QPoint afterMovePos = e->globalPos();
    if(z_.x()!=0&&z_.y()!=0)
    {
        QPoint moveDis = afterMovePos-z_;
        move(moveDis);
    }
}

void Register::mousePressEvent(QMouseEvent * e)
{
    QPoint currGlobalPos = e->globalPos();              //当前鼠标的全局位置
    QPoint currLocPos = this->geometry().topLeft();    //当前鼠标点击窗口的左上角坐标
    z_ = currGlobalPos-currLocPos;
}

void Register::mouseReleaseEvent(QMouseEvent *)
{
    z_ = QPoint(0,0);
}

void Register::initWinRource()
{
    this->setWindowFlags(Qt::FramelessWindowHint);   //设置窗口无边框
    this->setAttribute(Qt::WA_TranslucentBackground);  //设置主窗口背景透明
    this->setStyleSheet(ReadQStyleSheet::readQss(":/qss/qss_register.qss"));

    QGraphicsDropShadowEffect * shadow = new QGraphicsDropShadowEffect(this);
    shadow->setOffset(0,0);   //阴影偏移量
    shadow->setColor(Qt::black);  //阴影颜色
    shadow->setBlurRadius(5);     //阴影的模糊半径
    ui->widgetInner->setGraphicsEffect(shadow);
    z_ = QPoint(0,0);

    QPainter painter(ui->stackedWidget);
    QPixmap pix(":/Login/C:/Users/ASUS/Pictures/Image/123.jpg");
    painter.drawPixmap(0,0,467,558,pix);
}

void Register::paintEvent(QPaintEvent * e)
{


    QWidget::paintEvent(e);
}

void Register::on_toolButtonRegisterClose_clicked()
{
    // 发送一个信号


    this->close();
}

void Register::on_pushButtonRegister_clicked()
{
    QString name = ui->lineEdit_user_name->text();
    if(name=="")
    {
        QMessageBox::warning(this,"错误","用户名不能为空",QMessageBox::Ok);
        return;
    }
    QString pwd = ui->lineEdit_pwd->text();
    if(pwd=="")
    {
        QMessageBox::warning(this,"错误","密码不能为空",QMessageBox::Ok);
        return;
    }
    QString sure_pwd = ui->lineEdit_sure_pwd->text();
    if(sure_pwd=="")
    {
        QMessageBox::warning(this,"错误","请确认密码",QMessageBox::Ok);
        return;
    }
    else if(sure_pwd != pwd)
    {
        Cout<<pwd<<"---"<<sure_pwd;
        QMessageBox::warning(this,"错误","两次密码不匹配",QMessageBox::Ok);
        return;
    }

    QString phone = ui->lineEdit_phone->text();
    if(phone=="")
    {
        QMessageBox::warning(this,"错误","电话不能为空",QMessageBox::Ok);
        return;
    }
    bool man = ui->radioButton_man->isChecked();
    bool woman = ui->radioButton_woman->isChecked();
    if(!man&&!woman)
    {
        QMessageBox::warning(this,"错误","请选择性别",QMessageBox::Ok);
        return;
    }
    bool who = man?man:woman;

    QString email = ui->lineEdit_email->text();
    if(email=="")
    {
        QMessageBox::warning(this,"错误","邮箱不能为空",QMessageBox::Ok);
        return;
    }

    QString url = ReadQStyleSheet::g_ip_url+"/user/register";
    QString append = QString("uName=%1&uPassword=%2&confirmPassword=%3&uPhone=%4&uSex=%5&uEmail=%6&checkCode=1")
            .arg(name)
            .arg(pwd)
            .arg(sure_pwd)
            .arg(phone)
            .arg(who)
            .arg(email);
    QNetworkRequest request;
    request.setUrl(url);
    request.setHeader(QNetworkRequest::ContentTypeHeader,"application/x-www-form-urlencoded");
    QNetworkReply * reply = nam_->post(request,append.toUtf8());

}

void Register::on_pushButton_close_clicked()
{
    this->close();
}
