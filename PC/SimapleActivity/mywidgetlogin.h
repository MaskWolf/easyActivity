#ifndef MYWIDGETLOGIN_H
#define MYWIDGETLOGIN_H

#include <QWidget>

class MyWidgetLogin : public QWidget
{
    Q_OBJECT
public:
    explicit MyWidgetLogin(QWidget *parent = 0);

signals:
    void changeBackgroundColor();
public slots:
protected:
    void mousePressEvent(QMouseEvent *);
};

#endif // MYWIDGETLOGIN_H
