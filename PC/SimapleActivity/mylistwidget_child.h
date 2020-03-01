#ifndef MYLISTWIDGET_CHILD_H
#define MYLISTWIDGET_CHILD_H

#include <QListWidget>
#include <QWheelEvent>
#include <QScrollBar>

class MyListWidget_child:public QListWidget
{
public:
    MyListWidget_child(QWidget * parent = 0);
protected:
    void wheelEvent(QWheelEvent *);
};

#endif // MYLISTWIDGET_CHILD_H
