#include "mylistwidget_child.h"

MyListWidget_child::MyListWidget_child(QWidget *parent):
    QListWidget(parent)
{

}

void MyListWidget_child::wheelEvent(QWheelEvent * e)
{
    int num_step = e->delta()/120;
    this->verticalScrollBar()->setValue(this->verticalScrollBar()->value()-num_step);
}
