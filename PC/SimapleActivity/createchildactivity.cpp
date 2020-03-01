#include "createchildactivity.h"
#include "ui_createchildactivity.h"

CreateChildActivity::CreateChildActivity(QString win_name,QWidget *parent) :
    QDialog(parent),
    ui(new Ui::CreateChildActivity)
{
    ui->setupUi(this);
    this->setWindowTitle(win_name);

    this->setWindowFlags(Qt::FramelessWindowHint|Qt::WindowStaysOnTopHint);   //设置窗口无边框
    this->setAttribute(Qt::WA_TranslucentBackground);  //设置主窗口背景透明

    QGraphicsDropShadowEffect * shadow = new QGraphicsDropShadowEffect(this);
    shadow->setOffset(0,0);   //阴影偏移量
    shadow->setColor(Qt::black);  //阴影颜色
    shadow->setBlurRadius(10);     //阴影的模糊半径
    ui->widgetInner->setGraphicsEffect(shadow);
    z_ = QPoint(0,0);
}

CreateChildActivity::~CreateChildActivity()
{
    delete ui;
}

void CreateChildActivity::clear()
{
    ui->lineEdit->setText("");
    ui->textEdit->setText("");
    ui->spinBox->setValue(0);
    ui->doubleSpinBox->setValue(0);
}

void CreateChildActivity::on_pushButton_finished_clicked()
{
    QString name = ui->lineEdit->text();
    QString description = ui->textEdit->toPlainText();
    int join_time = ui->spinBox->value();
    double socre = ui->doubleSpinBox->value();
    if(name!=""&&description!="")
    {
        emit created(name,description,join_time,socre);
        this->close();
    }
    else
    {
        QMessageBox::warning(this,"错误","输入信息不能为空",QMessageBox::Ok);
    }

}

void CreateChildActivity::mouseMoveEvent(QMouseEvent * e)
{
    QPoint afterMovePos = e->globalPos();
    if(z_.x()!=0&&z_.y()!=0)
    {
        QPoint moveDis = afterMovePos-z_;
        move(moveDis);
    }

}

void CreateChildActivity::mousePressEvent(QMouseEvent * e)
{
    QPoint currGlobalPos = e->globalPos();              //当前鼠标的全局位置
    QPoint currLocPos = this->geometry().topLeft();    //当前鼠标点击窗口的左上角坐标
    z_ = currGlobalPos-currLocPos;
}

void CreateChildActivity::mouseReleaseEvent(QMouseEvent *)
{
    z_ = QPoint(0,0);
}

void CreateChildActivity::on_toolButton_clicked()
{
    this->close();
}
