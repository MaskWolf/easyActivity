/**
  * @file
  * @brief 报名界面
  * @version 1.0
  * @author zsj
  * @date 2019年5月17日08:56:06
  */
#ifndef SIGNUPACTIVITY_H
#define SIGNUPACTIVITY_H

#include <QWidget>
#include <QListWidgetItem>
#include <QPoint>
#include <QMouseEvent>
#include <QGraphicsDropShadowEffect>
#include <QStringList>
#include <QDebug>
#include <QJsonArray>
#include <QJsonDocument>
#include <QJsonObject>
#include <QNetworkAccessManager>
#include <QNetworkReply>
#include <QNetworkRequest>
#include <memory>
#include <QList>
#include <QEventLoop>

#include "readqstylesheet.h"
#include "signupitem.h"
#include "childactivityitem.h"
#include "transformtojson.h"
#include "showmessage.h"

using namespace std;

namespace Ui {
class SignUpActivity;
}

class SignUpActivity : public QWidget
{
    Q_OBJECT

public:
    explicit SignUpActivity(QWidget *parent = 0);
    SignUpActivity(QWidget *parent,int activity_id);
    SignUpActivity(QWidget *parent, int activity_id,QString name,int u_id);


    /// @brief 显示出报名项
    void set_sign_up_item();

    /// @brief 显示出报名的子项目
    void set_child_activity_item();

    /// @brief 初始化窗口设置/资源
    void initWindowResource();
    ~SignUpActivity();


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



private slots:
    void on_toolButton_close_clicked();

    void on_pushButton_post_clicked();

signals:

    //由于显示信息是单线程异步，设置两个信号和利用事件循环同步数据
    void sign_up_item();
    void child_activity_item();

private:
    Ui::SignUpActivity *ui;

    QPoint z_;

    shared_ptr<QNetworkAccessManager>nam_;

    int activity_id_;  ///< 正在报名的活动的id
    int u_id_;         ///< 报名子活动的用户的id
    QString activity_name_;  ///< 正在报名的活动的名字

    int status_ = 0;     ///< 状态   当前应该接受的数据内容

    shared_ptr<ShowMessage>show_dialog_;


    /// @brief 处理从服务器上拉下来的数据
    void dealGetHttpData(QNetworkReply * reply);

    /// @brief 处理获取活动报名表信息
    void dealActivityEntryForm(QNetworkReply * reply);

    /// @brief 处理一个活动的子活动显示
    void dealChooseChildActivity(QNetworkReply * reply);

    /// @brief 处理报名请求后的返回信息
    void dealSignUpReturnInfo(QNetworkReply * reply);
};

#endif // SIGNUPACTIVITY_H
