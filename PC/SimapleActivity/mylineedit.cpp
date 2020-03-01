#include "mylineedit.h"

MyLineEdit::MyLineEdit(QWidget *parent) : QLineEdit(parent)
{

}

void MyLineEdit::focusInEvent(QFocusEvent * e)
{
    emit changeBkColor(false);
    QLineEdit::focusInEvent(e);
}

void MyLineEdit::focusOutEvent(QFocusEvent * e)
{
    emit changeBkColor(true);
    this->clearFocus();
    QLineEdit::focusOutEvent(e);
}

