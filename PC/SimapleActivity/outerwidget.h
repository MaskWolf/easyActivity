/**
  * @file
  * @brief 外层Widget，用于设置窗口透明，窗口移动
  * @version 1.0
  * @date 2019年6月9日11:04:01
  * @author
  */
#ifndef OUTERWIDGET_H
#define OUTERWIDGET_H

#include <QWidget>
#include <QMouseEvent>
#include <QPoint>

namespace Ui {
class OuterWidget;
}

class OuterWidget : public QWidget
{
    Q_OBJECT

public:
    explicit OuterWidget(QWidget *parent = 0);
    ~OuterWidget();


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
    Ui::OuterWidget *ui;

    QPoint z_;
};

#endif // OUTERWIDGET_H
