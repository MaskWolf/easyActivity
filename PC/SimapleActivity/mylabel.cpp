#include "mylabel.h"

MyLabel::MyLabel(QWidget *parent) : QLabel(parent),sm(new ShowMessage(0,""))
{

}

MyLabel::~MyLabel()
{
    delete sm;
}

void MyLabel::mousePressEvent(QMouseEvent * e)
{
    if(e->button()==Qt::RightButton)
    {
        QString pic_name = QFileDialog::getOpenFileName(this,QString("选择图片"),tr("./"),tr("图片(*.jpg *.png);;"));
        pix_.load(pic_name);
        if(pix_.isNull())
        {
            sm->showDialog("设置头像失败，请重试");
        }
        else
        {
            emit choosedPixmap(pic_name);
        }
    }
}

