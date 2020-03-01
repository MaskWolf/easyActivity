#ifndef WRITECOMMENT_H
#define WRITECOMMENT_H

#include <QWidget>
#include <QListWidget>
#include <QListWidgetItem>
#include <string>
#include <memory>
#include <QPoint>
#include <QMouseEvent>
#include <QGraphicsDropShadowEffect>

#include <QNetworkAccessManager>
#include <QNetworkRequest>
#include <QNetworkReply>
#include <QJsonDocument>
#include <QJsonArray>
#include <QJsonObject>

#include "user.h"
#include "commentitem.h"
#include "readqstylesheet.h"

using std::string;

namespace Ui {
class WriteComment;
}

class WriteComment : public QWidget
{
    Q_OBJECT

public:
    /// @brief 构造函数。构造一个用于显示用户评论和进行评论的界面
    /// @param wc_user 被评论的对象的信息
    /// @param c_user 评论此对象的用户
    /// @param p_id 评论的动态的id
    /// @note 获取用户发布的动态时调用
    WriteComment(const User & wc_user,const User & c_user,int p_id);

    /// @brief 构造函数
    ///
    ///
    /// @note 获取系统发布的动态时调用
    WriteComment(const QString & act_name,const User &c_user, int p_id);


    /// @brief 回复用户的评论的时候触发
    void deal_reply_comment(const QString & user_name,const QString & content,int c_id);

    ~WriteComment();


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
    void on_pushButton_comment_clicked();

    void on_toolButton_close_clicked();

    void on_pushButton_update_clicked();

private:
    Ui::WriteComment *ui;

    User wc_user_;   ///< 发布此动态的用户信息
    User c_user_;    ///< 评论此动态的用户的信息
    QString r_name_;    ///< 用户可以回复其他用户的评论  r_name_保存其他用户的用户名
    QString content_;  ///< 其他用户的评论内容
    int c_id_;         ///< 回复别人的评论的id

    QPoint z_;

    shared_ptr<QNetworkAccessManager>nam_;

    int p_id_;        ///< 评论的动态的id

    int status_ = 0;  ///< 状态   响应哪一个服务器返回消息

    /// @brief 初始化评论，从服务器获取数据
    ///
    void initComment();


    /// @brief 初始化窗口设置
    ///
    /// 窗口qss渲染
    /// 窗口控件设置
    void initWinResource();


    /// @brief 处理服务器返回的信息
    void dealGetHttpData(QNetworkReply * reply);

    /// @brief 处理获取单个动态时服务器的返回信息
    void dealGetCommentReturnInfo(QNetworkReply * reply);
};


#endif // WRITECOMMENT_H
