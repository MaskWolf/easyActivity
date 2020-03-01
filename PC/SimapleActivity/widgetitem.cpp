#include "widgetitem.h"

WidgetItem::WidgetItem(QWidget *parent) : QWidget(parent)
{

}

WidgetItem::WidgetItem(QWidget *parent, QString  image, QString  label)
    :QWidget(parent)
{
    this->setFixedSize(200,30);      // 小控件 大小
    isActivity_.setParent(this);
    //image_.setParent(this);
    label_.setParent(this);

    isActivity_.setFixedSize(5,30);
    isActivity_.move(0,0);

    //isActivity_.setStyleSheet("background-color:rgb(255,0,0);");



    //image_.setFixedSize(30,30);
    //image_.move(18,0);
    //image_.setPixmap(QPixmap(image));
    label_.setFixedHeight(30);
    label_.move(15,0);
    label_.setText(label);
}

void WidgetItem::set_activity(bool flag,QString qss)
{
    if(flag==true)
    {
        QString ss = "background-color:"+qss;
        isActivity_.setStyleSheet(ss);
    }
    else
    {
        isActivity_.setStyleSheet("");
    }
}

bool WidgetItem::operator == (const WidgetItem &obj)
{
    return this->label_.text() == obj.label_.text();
}

QString WidgetItem::get_name()
{
    return label_.text();
}

