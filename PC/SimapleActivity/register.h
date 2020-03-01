#ifndef REGISTER_H
#define REGISTER_H

#include <QWidget>
#include <QGraphicsDropShadowEffect>
#include <QMouseEvent>
#include <QPoint>
#include <memory>
#include <QMessageBox>
#include <QNetworkAccessManager>
#include <QNetworkRequest>
#include <QNetworkReply>
#include <QJsonDocument>
#include <QJsonArray>
#include <QJsonObject>
#include <QPainter>
#include <QPaintEvent>

#include "readqstylesheet.h"

using namespace std;

namespace Ui {
class Register;
}

class Register : public QWidget
{
    Q_OBJECT

public:
    explicit Register(QWidget *parent = 0);
    ~Register();

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

private slots:
    void on_toolButtonRegisterClose_clicked();

    void on_pushButtonRegister_clicked();

    void on_pushButton_close_clicked();

private:
    Ui::Register *ui;

    QPoint z_;

    shared_ptr<QNetworkAccessManager>nam_;  ///< 得到注册时返回的信息

    /// @brief 初始化窗口设置
    void initWinRource();
protected:
    void paintEvent(QPaintEvent *);
};

#endif // REGISTER_H
