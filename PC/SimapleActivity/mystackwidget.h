/**
  * @file
  * @brief 自定义QStackWidget，移除继承自父窗口的鼠标事件
  * @version 1.0
  * @author zsj
  * @date 2019年5月16日10:47:42
  */
#ifndef MYSTACKWIDGET_H
#define MYSTACKWIDGET_H

#include <QWidget>
#include <QStackedWidget>
#include <QPainter>
#include <QPaintEvent>
#include <QPixmap>

class MyStackWidget : public QStackedWidget
{
    Q_OBJECT
public:
    explicit MyStackWidget(QWidget *parent = 0);

    /// @breif 重写移动事件
    void mousePressEvent(QMouseEvent *);

    void paintEvent(QPaintEvent *);
signals:

public slots:
};

#endif // MYSTACKWIDGET_H
