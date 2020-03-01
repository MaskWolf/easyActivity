#include "userinfochoose.h"
#include "ui_userinfochoose.h"

UserInfoChoose::UserInfoChoose(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::UserInfoChoose)
{
    ui->setupUi(this);
    ui->widget->setStyleSheet("background-color:rgb(250,250,250);");
}

UserInfoChoose::UserInfoChoose(QWidget *parent, QPixmap &  head_pic, QString nickname, QString join_num, QString created):
    QWidget(parent),
    ui(new Ui::UserInfoChoose),pix_(head_pic)
{
    ui->setupUi(this);

    //Cout<<"开始创建UserInfoChoose";

    pix_ = pix_.scaled(51,51);

    ui->labelHead->setPixmap(GetImage::get_round_image(pix_,25));
    ui->labelCreated->setText(created);
    ui->labelJoinNum->setText(join_num);

    ui->labelNickname->setText(nickname);




    // 设置窗口阴影
    //this->setWindowFlags(Qt::FramelessWindowHint);   //设置窗口无边框
    //this->setAttribute(Qt::WA_TranslucentBackground);  //设置主窗口背景透明
    this->setStyleSheet(ReadQStyleSheet::readQss(":/qss/qss_userinfochoose.qss"));
    QGraphicsDropShadowEffect * shadow = new QGraphicsDropShadowEffect();
    shadow->setOffset(0,0);   //阴影偏移量
    shadow->setColor(Qt::black);  //阴影颜色
    shadow->setBlurRadius(5);     //阴影的模糊半径
    ui->widget->setGraphicsEffect(shadow);
}

UserInfoChoose::~UserInfoChoose()
{
    delete ui;
}

void UserInfoChoose::mousePressEvent(QMouseEvent *)
{

}

void UserInfoChoose::on_pushButton_clicked()
{
    emit userSet(1);   // 转到个人设置
}
