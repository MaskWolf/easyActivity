/**
  * @file
  * @brief 自定义用户小菜单
  * @version 1.0
  * @date 2019年5月16日10:42:20
  * @author zsj
  */
#ifndef USERINFOCHOOSE_H
#define USERINFOCHOOSE_H

#include <QWidget>
#include <QString>
#include <QPixmap>
#include <QGraphicsDropShadowEffect>
#include <QDebug>
#include <QMouseEvent>
#include <QPixmap>

#include "getimage.h"
#include "readqstylesheet.h"

namespace Ui {
class UserInfoChoose;
}

class UserInfoChoose : public QWidget
{
    Q_OBJECT

public:
    explicit UserInfoChoose(QWidget *parent = 0);
    UserInfoChoose(QWidget *parent,QPixmap &  head_pic,QString nickname,QString  join_num,QString created);
    ~UserInfoChoose();

    /// @brief 重写鼠标移动事件  覆盖父窗口的移动事件
    void mousePressEvent(QMouseEvent *);
private slots:
    void on_pushButton_clicked();

private:
    Ui::UserInfoChoose *ui;
    QPixmap pix_;
signals:
    void userSet(int flag);

};

#endif // USERINFOCHOOSE_H
