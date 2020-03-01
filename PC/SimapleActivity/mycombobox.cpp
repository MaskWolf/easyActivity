#include "mycombobox.h"

MyComboBox::MyComboBox(QWidget *parent) : QComboBox(parent)
{

}

void MyComboBox::focusInEvent(QFocusEvent *e)
{
    emit changeBkColor(false);
    return QComboBox::focusInEvent(e);
}

void MyComboBox::focusOutEvent(QFocusEvent *e)
{
    emit changeBkColor(true);
    return QComboBox::focusOutEvent(e);
}



