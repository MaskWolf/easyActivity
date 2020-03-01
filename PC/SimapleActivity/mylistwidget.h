/**
  * @file
  * @brief "我创建的" 界面
  *
  *     重写了QListWidget，重写鼠标滚动事件
  *     作用：防止父窗口的滚动事件对子窗口造成影响
  *
  *
  *
  *     此控件由界面设置，程序自动调用默认构造函数，要获取服务器数据
  *     由void dealGetHttpData(QNetworkReply * reply)获取服务器数据
  *     由void showContent(QString name,int status);选择是否显示数据
  *     主界面可灵活控制是否显示数据
  *     作用：显示用户创建/管理/参加的主活动
  *
  * @version 1.0
  * @author zsj
  * @date 2019年5月20日14:56:06
  */

#ifndef MYLISTWIDGET_H
#define MYLISTWIDGET_H

#include <QListWidget>
#include <QListWidgetItem>
#include <QDebug>
#include <memory>
#include <QWheelEvent>
#include <QScrollBar>
#include <QJsonDocument>
#include <QJsonArray>
#include <QJsonObject>
#include <QNetworkAccessManager>
#include <QNetworkRequest>
#include <QNetworkReply>

#include "readqstylesheet.h"
#include "mycreateactivity.h"

using namespace std;

class MyListWidget:public QListWidget
{
public:
    /// @brief 初始化的时候从服务器拉下我创建的活动的数据
    explicit MyListWidget(QWidget * parent = 0);

    /// @brief 显示"我创建的活动"的内容
    ///
    /// 从服务器获取数据并显示，获取一个用户的内容
    /// @param u_id 用户的id
    /// @param status 状态码
    void showContent(int u_id,int status);


    /// @brief 从服务器获取数据并显示到界面
    void dealGetHttpData(QNetworkReply * reply);
protected:
    /// @brief 重写鼠标滚轮事件
    void wheelEvent(QWheelEvent *);
private:
    shared_ptr<QNetworkAccessManager>nam_;

    int status_ = 0;   ///< 显示状态   0：显示创建的 1：显示管理的 2：显示参加的
};

#endif // MYLISTWIDGET_H
