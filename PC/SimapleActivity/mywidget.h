/**
  * @file
  * @brief 实现用户小菜单的点击事件
  * @version 1.0
  * @date 2019年5月16日12:13:29
  * @author zsj
  */
#ifndef MYWIDGET_H
#define MYWIDGET_H

#include <QWidget>
#include <QMouseEvent>
#include <QDebug>
#include <QEvent>

class MyWidget : public QWidget
{
    Q_OBJECT
public:
    explicit MyWidget(QWidget *parent = 0);



    /// @brief 重写QWidget的鼠标点击事件
    void mousePressEvent(QMouseEvent *);


    /// @brief 模拟qss中的hover渲染,
    ///
    /// 进入就改变背景颜色
    ///
    void enterEvent(QEvent *);

    /// @brief 模拟qss中的hover渲染,
    ///
    /// 离开就改变背景颜色
    ///
    void leaveEvent(QEvent *);

signals:

public slots:
};

#endif // MYWIDGET_H
