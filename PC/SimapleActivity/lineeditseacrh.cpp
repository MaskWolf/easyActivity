#include "lineeditseacrh.h"

LineEditSeacrh::LineEditSeacrh(QWidget *parent) :
    QLineEdit(parent)
{

}

void LineEditSeacrh::keyPressEvent(QKeyEvent * e)
{
    static int index = 0;
    if(e->key() == Qt::Key_Return)  //回车
    {
        data_ = this->text();
        Cout<<data_<<"  "<<"回车";
        if(data_!="")
        {
            emit searchBegin(data_);
        }
    }
    else if(e->key()==Qt::Key_Enter)
    {
        data_ = this->text();
        Cout<<data_<<"  "<<"Enter";
        if(data_!="")
        {
            emit searchBegin(data_);
        }
    }
    else
    {

    }
    QLineEdit::keyPressEvent(e);
}

