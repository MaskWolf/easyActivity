#ifndef USERDEFINETYPE_H
#define USERDEFINETYPE_H

#include <QDialog>
#include <QString>
#include <QMouseEvent>
#include <QPoint>
#include <QGraphicsDropShadowEffect>

#include "outerwidget.h"

namespace Ui {
class UserDefineType;
}

class UserDefineType : public QDialog
{
    Q_OBJECT

public:
    explicit UserDefineType(QWidget *parent = 0);

    QString get_type()const;
    QString get_type_description()const;
    ~UserDefineType();

private slots:
    void on_pushButton_sure_clicked();

    void on_toolButton_close_clicked();

protected:
    /// @brief 重写mouseMoveEvent函数
    ///
    ///     用户点击有可能点击LoginWidget页面之上的小部件然后拖动
    ///会出现抖动，此函数解决此问题
    void mouseMoveEvent(QMouseEvent *);

    /// @brief 重写mousePressEvent函数
    ///
    ///  鼠标按下事件，按下就获取当前鼠标坐标并计算出当前坐标和窗口左上角的差值
    void mousePressEvent(QMouseEvent *);

    /// @brief 重写mouseReleaseEvent函数
    void mouseReleaseEvent(QMouseEvent *);
private:
    Ui::UserDefineType *ui;

    QPoint z_;
signals:
    void addFinish(QString user_define,QString user_define_description);
};

#endif // USERDEFINETYPE_H
