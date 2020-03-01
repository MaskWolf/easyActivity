#include "userdefinetype.h"
#include "ui_userdefinetype.h"

UserDefineType::UserDefineType(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::UserDefineType)
{
    ui->setupUi(this);
    this->setWindowTitle("自定义类型");

    this->setWindowFlags(Qt::FramelessWindowHint|Qt::WindowStaysOnTopHint);   //设置窗口无边框
    this->setAttribute(Qt::WA_TranslucentBackground);  //设置主窗口背景透明

    QGraphicsDropShadowEffect * shadow = new QGraphicsDropShadowEffect(this);
    shadow->setOffset(0,0);   //阴影偏移量
    shadow->setColor(Qt::black);  //阴影颜色
    shadow->setBlurRadius(10);     //阴影的模糊半径
    ui->widgetInner->setGraphicsEffect(shadow);
    z_ = QPoint(0,0);
}

QString UserDefineType::get_type() const
{
    return ui->lineEdit->text();
}

QString UserDefineType::get_type_description() const
{
    return ui->textEdit->toPlainText();
}

UserDefineType::~UserDefineType()
{
    delete ui;
}

void UserDefineType::on_pushButton_sure_clicked()
{
    QString data = ui->lineEdit->text();
    QString data_des = ui->textEdit->toPlainText();
    if(data != ""&&data_des!="")
    {
        emit addFinish(data,data_des);
        ui->lineEdit->clear();
        ui->textEdit->clear();
        this->close();
    }
}

void UserDefineType::mouseMoveEvent(QMouseEvent * e)
{
    QPoint afterMovePos = e->globalPos();
    if(z_.x()!=0&&z_.y()!=0)
    {
        QPoint moveDis = afterMovePos-z_;
        move(moveDis);
    }
}

void UserDefineType::mousePressEvent(QMouseEvent * e)
{
    QPoint currGlobalPos = e->globalPos();              //当前鼠标的全局位置
    QPoint currLocPos = this->geometry().topLeft();    //当前鼠标点击窗口的左上角坐标
    z_ = currGlobalPos-currLocPos;
}

void UserDefineType::mouseReleaseEvent(QMouseEvent *)
{
    z_ = QPoint(0,0);
}

void UserDefineType::on_toolButton_close_clicked()
{
    this->close();
}
