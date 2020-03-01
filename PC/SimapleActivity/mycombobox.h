/**
  * @file
  * @brief 自定义组合框  实现其焦点得到和失去后对组合框的渲染
  *
  *     本组合框应用于登录界面
  * @date 2019年5月23日10:34:41
  * @author zsj
  * @version 1.0
  */
#ifndef MYCOMBOBOX_H
#define MYCOMBOBOX_H

#include <QComboBox>
#include <QMouseEvent>

class MyComboBox : public QComboBox
{
    Q_OBJECT
public:
    explicit MyComboBox(QWidget *parent = 0);

signals:
    void changeBkColor(bool is_normal);
public slots:
protected:
//    void mousePressEvent(QMouseEvent *e);

    /// @brief 获得焦点的时候改变现实的样式
    void focusInEvent(QFocusEvent *e);

    void focusOutEvent(QFocusEvent *e);
};

#endif // MYCOMBOBOX_H
