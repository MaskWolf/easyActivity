#ifndef CREATECHILDACTIVITY_H
#define CREATECHILDACTIVITY_H

#include <QDialog>
#include <QString>
#include <QDebug>
#include <QMessageBox>
#include <QGraphicsDropShadowEffect>

#include <QMouseEvent>
#include <QPoint>

namespace Ui {
class CreateChildActivity;
}

class CreateChildActivity : public QDialog
{
    Q_OBJECT

public:
    explicit CreateChildActivity(QString win_name = "",QWidget *parent = 0);
    ~CreateChildActivity();

    /// @brief 清空两个编辑框的内容
    ///
    void clear();

private slots:
    void on_pushButton_finished_clicked();

    void on_toolButton_clicked();

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
    Ui::CreateChildActivity *ui;

    QPoint z_;
signals:
    void created(QString act_name,QString act_description,int join_time,double score);
};

#endif // CREATECHILDACTIVITY_H
