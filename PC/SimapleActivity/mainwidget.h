#ifndef MAINWIDGET_H
#define MAINWIDGET_H

#include <QWidget>
#include <QGraphicsDropShadowEffect>

#include <QMouseEvent>
#include <QPoint>
#include <memory>
#include <QDebug>
#include <QRect>
#include <QListWidgetItem>
#include <QDebug>
#include <QScrollBar>
#include <QMessageBox>
#include <QStringList>
#include <QVector>
#include <QImage>
#include <QMap>
#include <QVector>
#include <QPair>
#include <QLabel>
#include <QHttpMultiPart>

#include <QNetworkAccessManager>
#include <QNetworkRequest>
#include <QNetworkReply>
#include <QJsonDocument>
#include <QJsonArray>
#include <QHttpMultiPart>
#include <QHttpPart>

#include "readqstylesheet.h"
#include "widgetitem.h"
#include "contentitem.h"
#include "userinfochoose.h"
#include "login.h"
#include "user.h"
#include "childactivityitem.h"
#include "createchildactivity.h"
#include "mainactivity.h"
#include "userdefinetype.h"
#include "getimage.h"
#include "transformtojson.h"
#include "userdefinetypeshow.h"
#include "createdynamic.h"
#include "userdynamic.h"
#include "showmessage.h"
#include "childactivity.h"

using namespace std;

namespace Ui {
class MainWidget;
}

class MainWidget : public QWidget
{
    Q_OBJECT

public:
    explicit MainWidget(QWidget *parent = 0);
    ~MainWidget();





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
    /// @brief 关闭窗口
    void on_toolButtonClose_clicked();

    /// @brief 用户信息  设置
    void on_toolButtonUserSet_clicked();

    /// @brief 最大化窗口
    void on_toolButtonMax_clicked();

    /// @brief 最小化窗口
    void on_toolButtonMin_clicked();

    /// @brief 处理单击选项按钮
    void dealClickChoose(QListWidgetItem * );

    /// @brief 处理添加子活动界面传递的信息
    void dealCreateChildActivity(QString name,QString decription,int join_num,double score);



    /// @brief 创建活动
    void on_toolButton_create_activity_clicked();

    /// @brief 创建活动界面的下一页按钮
    void on_toolButton_next_step_clicked();

    /// @brief 创建活动界面的上一页按钮
    void on_toolButton_last_step_clicked();

    /// @brief 创建活动界面 创建主活动完成按钮
    void on_pushButton_finished_clicked();

    /// @brief 创建活动界面 添加子活动
    void on_pushButton_add_child_activity_clicked();

    /// @brief 创建活动界面 全部创建完成
    void on_pushButton_create_finish_clicked();

    /// @brief 创建活动界面 新建报名表中的添加用户自定义字段
    void on_toolButton_add_user_define_clicked();

    /// @brief 创建活动界面 添加子活动
    void on_pushButton_create_child_act_clicked();

    /// @brief 显示所有活动界面 刷新显示所有活动
    void on_toolButton_update_clicked();

    void on_pushButton_write_dynamic_clicked();


    /// @brief 发布动态，接收动态的信息
    void publsh_dynamic(QString content,QStringList & list);

    void on_pushButton_my_create_update_clicked();

    void on_pushButton_dynamic_update_clicked();

    void on_pushButton_user_set_save_clicked();

private:
    Ui::MainWidget *ui;

    QPoint z_;


    // HTTP_DATA_INGO 从服务器获取的数据类型 处理方式不同
    // 返回的消息每种请求不一样   不一样的消息需要不同的函数操作
    // 前面带AUTO的表示程序打开时就发送请求并接受服务器数据，没带AUTO表示用户点击之后才发送
    enum HTTP_DATA_TYPE{AUTO_MAIN_ACT,    ///< 显示所有活动
                        UPDATE_MAIN_ACT,  ///< 更新所有活动的显示
                        CREATE_ACT,         /// < 创建活动
                        SIGN_UP_ACT,        ///< 报名时
                        USER_CREATED,     ///< 显示用户创建活动
                        CREATED_DYNAMIC,   ///< 新建动态
                        INIT_DYNAMIC,       ///< 初始化动态
                        UPDATE_DYNAMIC,      ///< 刷新动态
                        UPLOAD_IMAGE,         ///< 上传图片
                        SEARCH           ///< 搜索
                       };    ///

    HTTP_DATA_TYPE CURRENT_TYPE = AUTO_MAIN_ACT;   /// 当前的类型


    bool isMax = false;   ///< 窗口是否为最大化
    shared_ptr<Login> login_; ///< 登录界面

    User user_;   ///< 当前的登录用户的信息

    bool is_show_small_menu_ = true;   ///< 用户的小菜单是否显示

    /*
        choose_:用户选择的小菜单
        base_:托举上面小菜单的一个QLabel

            tips:直接实现小菜单可以，但是小菜单没有阴影，不好看，但实现阴影会造成
            小菜单无法显示,找到一个办法，使用QLabel托举。（不清楚为什么设置阴影后无法显示）
    */
    shared_ptr<UserInfoChoose> choose_;  ///< 信息选择设置界面
    shared_ptr<QLabel> base_;  ///< 为了实现用户小菜单的阴影  加一个底层QLabel  托举用户小菜单


    shared_ptr<CreateChildActivity> create_child_activity_; ///< 创建活动时添加子活动的界面


    shared_ptr<MainActivity> main_activity_;

    shared_ptr<UserDefineType> user_define_;   ///< 活动创建时用户自定义属性的界面

    shared_ptr<QNetworkAccessManager> nam_;      ///< 接收来自服务器的http响应

    shared_ptr<GetImage>get_image_;   /// 从网络获取图片


    QPixmap user_head_pic_;     ///< 用户头像  随时都用头像的路径去获取头像比较耗时


    QMap<int,QString> create_activity_info_;      ///< 创建活动界面顶上的提示  显示当前操作页信息
    QMap<QString,QString>base_type_data_;         ///<创建活动 创建报名表的时候选择的基础字段信息

    QVector<ChildActivity> child_activity_vector_;   ///< 保存创建活动时候的子活动的信息

    shared_ptr<CreateDynamic> create_dynamic_;           ///< 新建动态界面

    shared_ptr<ShowMessage> show_dialog_;        ///< 显示消息   以对话框的形式

    QString changed_head_path_;           ///< 更改头像时保存更改的头像的图片的路径

    QStringList dynamic_iamges_;        ///< 创建动态时添加的图片

    /// @brief 初始化窗口设置
    ///
    /// 窗口qss渲染
    /// 窗口控件设置
    void initWinResource();

    /// @brief 初始化菜单栏
    ///
    void initListChoose();


    /// @brief 初始化活动界面的信息
    void initListMainContent();


    /// @brief 初始化“动态”界面
    void initListDynamic();


    /// @brief 设置主界面的所有活动信息
    void setMainContent(QNetworkReply * reply);

    /// @brief 处理从服务器接收到的数据
    void dealGetHttpData(QNetworkReply * reply);

    /// @brief 处理创建活动时服务器返回的数据
    void dealCreateActReturnInfo(QNetworkReply * reply);

    /// @brief 处理报名之后服务器的返回信息
    void dealSignUpActReturnInfo(QNetworkReply * reply);

    /// @brief 处理创建新动态后的返回信息
    void dealCreatedynamicReturnInfo(QNetworkReply * reply);

    /// @brief 处理初始化动态，从服务器拉下动态的时候
    void dealGetDynamic(QNetworkReply * reply);

    /// @brief 处理上传图片后服务器的返回信息
    void dealUploadImage(QNetworkReply * reply);    // 未启用

    /// @brief 处理搜索后的返回信息
    void dealSearchReturnInfo(QNetworkReply * reply);

};

#endif // MAINWIDGET_H
