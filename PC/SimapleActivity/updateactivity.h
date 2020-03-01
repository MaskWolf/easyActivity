#ifndef UPDATEACTIVITY_H
#define UPDATEACTIVITY_H

#include <QWidget>
#include <QJsonDocument>
#include <QJsonArray>
#include <QJsonObject>
#include <QNetworkAccessManager>
#include <QNetworkRequest>
#include <QNetworkReply>
#include <memory>
#include <QListWidget>
#include <QListWidgetItem>
#include <QGraphicsDropShadowEffect>
#include <QStringList>
#include <QFileDialog>

#include "mainactivity.h"
#include "readqstylesheet.h"
#include "manageritem.h"
#include "outerwidget.h"

using namespace std;

namespace Ui {
class UpdateActivity;
}

class UpdateActivity : public OuterWidget
{
    Q_OBJECT

public:
    explicit UpdateActivity(QWidget *parent = 0);
    UpdateActivity(QWidget *parent,const MainActivity & main_act);
    ~UpdateActivity();

private slots:
    void on_toolButton_close_clicked();

    void on_toolButton_min_clicked();

    void on_pushButton_update_image_clicked();

    void on_pushButton_sure_clicked();

    void on_pushButton_cancel_clicked();

private:
    Ui::UpdateActivity *ui;

    MainActivity main_act_;

    shared_ptr<QNetworkAccessManager>nam_;

    int status_;           ///< 状态   接收的数据不相同

    QStringList list_;     ///上传的图片

    void initWinResource();

    void dealGetHttpData(QNetworkReply * reply);


    /// @brief 处理获取所有管理员信息
    void dealGetAllManagerReturnInfo(QNetworkReply * reply);
};

#endif // UPDATEACTIVITY_H
