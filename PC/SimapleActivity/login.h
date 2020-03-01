#ifndef LOGIN_H
#define LOGIN_H

#include <QWidget>
#include <QGraphicsDropShadowEffect>

#include <QMouseEvent>
#include <QPoint>
#include <memory>
#include <QDebug>
#include <QJsonDocument>
#include <QJsonArray>
#include <QJsonObject>
#include <QNetworkAccessManager>
#include <QNetworkRequest>
#include <QNetworkReply>
#include <QMessageBox>
#include <QTimer>
#include <QListWidget>
#include <QListWidgetItem>


#include "register.h"
#include "readqstylesheet.h"
#include "user.h"
#include "showmessage.h"
#include "replytimeout.h"
#include "comboboxitem.h"
#include "nofocusframedelegate.h"


using namespace std;
namespace Ui {
class Login;
}

class Login : public QWidget
{
    Q_OBJECT

public:
    explicit Login(QWidget *parent = 0);
    ~Login();

private:
    Ui::Login *ui;
    QPoint z_;
    shared_ptr<Register> register_;

    shared_ptr<QNetworkAccessManager> nam_;
    shared_ptr<ShowMessage>show_dialog_;        ///< 显示提示信息


    /// @brief 初始化窗口设置
    void initWinRource();

    bool over_timer_ = false;         ///< 判断登录请求是否超时

    QTimer timer_;       ///< 用于检查请求是否超时

    QString curr_combobox_text_;

    shared_ptr<ReplyTimeout>rt_;      ///< 检验请求超时



public:
    //无边框窗口需要重写鼠标点击和移动时间
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


signals:
   /// @brief 登录成功后会发送此信号给主界面
   ///
   /// @param user 用户的所有信息
   void isOk(User user);
private slots:

   /// @brief 关闭窗口
   void on_toolButton_clicked();

   /// @brief 切换到短信登录
   void on_toolButtonTonote_clicked();

   /// @brief 切换到账号密码登录
   void on_toolButtonToId_clicked();

   /// @brief 切换到注册界面
   void on_toolButtonRegister_clicked();
   void on_pushButton_login_clicked();
   void on_pushButton_login_id_and_pwd_clicked();

   /// @brief 当从服务器获取信息后进行处理此消息
   void dealGetData(QNetworkReply * reply);
   void on_toolButton_3_clicked();
   void on_pushButton_sure_clicked();
   void on_pushButton_cancel_clicked();
   void on_toolButton_close_clicked();
   void on_toolButton_set_clicked();
};

#endif // LOGIN_H
