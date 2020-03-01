#include "mywidget.h"

MyWidget::MyWidget(QWidget *parent) : QWidget(parent)
{

}

void MyWidget::mousePressEvent(QMouseEvent *)
{

}

void MyWidget::enterEvent(QEvent *)
{
    this->setStyleSheet("background-color:rgb(235,236,237);");
}

void MyWidget::leaveEvent(QEvent *)
{
    this->setStyleSheet("background-color:rgb(250,250,250);");
}

