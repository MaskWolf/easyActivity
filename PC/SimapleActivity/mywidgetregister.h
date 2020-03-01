/**
  * @file
  * @brief 重写QWidget，画出背景渲染
  * @date 2019年5月24日21:51:10
  * @version 1.0
  * @author zsj
  */
#ifndef MYWIDGETREGISTER_H
#define MYWIDGETREGISTER_H

#include <QWidget>
#include <QPainter>
#include <QPaintEvent>
#include <QPixmap>

class MyWidgetRegister : public QWidget
{
    Q_OBJECT
public:
    explicit MyWidgetRegister(QWidget *parent = 0);

signals:

public slots:
protected:
    void paintEvent(QPaintEvent *);
};

#endif // MYWIDGETREGISTER_H
