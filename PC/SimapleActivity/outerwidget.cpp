#include "outerwidget.h"
#include "ui_outerwidget.h"

OuterWidget::OuterWidget(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::OuterWidget)
{
    ui->setupUi(this);
}

OuterWidget::~OuterWidget()
{
    delete ui;
}

void OuterWidget::mouseMoveEvent(QMouseEvent * e)
{
    QPoint afterMovePos = e->globalPos();
    if(z_.x()!=0&&z_.y()!=0)
    {
        QPoint moveDis = afterMovePos-z_;
        move(moveDis);
    }

}

void OuterWidget::mousePressEvent(QMouseEvent * e)
{
    QPoint currGlobalPos = e->globalPos();              //当前鼠标的全局位置
    QPoint currLocPos = this->geometry().topLeft();    //当前鼠标点击窗口的左上角坐标
    z_ = currGlobalPos-currLocPos;
}

void OuterWidget::mouseReleaseEvent(QMouseEvent *)
{
    z_ = QPoint(0,0);
}
