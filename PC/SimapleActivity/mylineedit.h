/**
  * @file
  * @brief 自定义编译框，实现得到焦点和失去焦点时对界面的渲染
  *
  *     本编辑框应用于登录界面
  * @date 2019年5月23日10:36:41
  * @author zsj
  * @version 1.0
  */
#ifndef MYLINEEDIT_H
#define MYLINEEDIT_H

#include <QLineEdit>
#include <QMouseEvent>

class MyLineEdit : public QLineEdit
{
    Q_OBJECT
public:
    explicit MyLineEdit(QWidget *parent = 0);

signals:
    void changeBkColor(bool is_normal);
public slots:
protected:
    /// @brief 得到焦点
    void focusInEvent(QFocusEvent *);

    /// @brief 失去焦点
    void focusOutEvent(QFocusEvent *);
};

#endif // MYLINEEDIT_H
