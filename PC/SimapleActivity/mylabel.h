/**
  * @file
  * @brief 实现点击一下label触发一个事件
  *
  *     用于用户设置头像时的添加头像图片
  *
  * @date 2019年6月5日21:14:01
  * @version 1.0
  * @author zsj
  */
#ifndef MYLABEL_H
#define MYLABEL_H

#include <QLabel>
#include <QMouseEvent>
#include <QPixmap>
#include <QFileDialog>

#include "showmessage.h"

class MyLabel : public QLabel
{
    Q_OBJECT
public:
    explicit MyLabel(QWidget *parent = 0);
    ~MyLabel();
signals:
    void choosedPixmap(const QString & pixmap);
public slots:

protected:
    /// @brief 点击的时候打开一个图片选择框，选择头像
    void mousePressEvent(QMouseEvent *)override;

private:
    QPixmap pix_;        ///< 选择的图片
    ShowMessage * sm;
};

#endif // MYLABEL_H
