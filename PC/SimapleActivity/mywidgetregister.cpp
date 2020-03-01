#include "mywidgetregister.h"

MyWidgetRegister::MyWidgetRegister(QWidget *parent) : QWidget(parent)
{

}

void MyWidgetRegister::paintEvent(QPaintEvent * e)
{
    QPainter p(this);
    QPixmap pix(":/Login/C:/Users/ASUS/Pictures/Image/127.jpg");
    p.drawPixmap(0,0,width(),height(),pix);
    QWidget::paintEvent(e);
}

