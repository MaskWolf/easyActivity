#ifndef GETIMAGE_H
#define GETIMAGE_H

#include <QWidget>
#include <QByteArray>
#include <QString>

#include <QNetworkAccessManager>
#include <QNetworkRequest>
#include <QNetworkReply>
#include <QJsonDocument>
#include <QJsonArray>
#include <QJsonObject>
#include <QHttpMultiPart>
#include <QHttpPart>

#include <memory>
#include <QEventLoop>
#include <QUrl>
#include <QPainter>
#include <QSize>
#include <QBitmap>
#include <QPainterPath>
#include <QPixmap>
#include <QBuffer>
#include <QFile>

#include "readqstylesheet.h"
#include "replytimeout.h"

using namespace std;

class GetImage : public QWidget
{
    Q_OBJECT
public:
    explicit GetImage(QWidget *parent = 0);

    /// @brief 由url获取一张图片
    /// @param urls 图片资源的地址
    /// @return QPixmap 获取的图片
    QPixmap get_image(QUrl urls);


    /// @brief 上传一张图片
    /// @param urls 图片上传的地址
    /// @param id 上传的具体位置
    /// @param flag 标志着什么类型
    /// @param file_name 图片的路径名字
    bool uploadImage(QUrl urls,int id,int flag,QString file_name);

    /// @brief 将图片缩放为圆形
    /// @param pixmap 缩放的图片
    /// @param radius 缩放的尺寸,缩放后圆形的半径
    /// @return QPixmap 一张新的图片
    static QPixmap get_round_image(QPixmap & pixmap,int radius);

    /// @brief 将QPixmap转化为二进制
    /// @param pix  图片
    /// @param format  格式
    static QByteArray toUtf8(const QPixmap & pix,const char * format = 0);

signals:
    void ok();
    void not_ok();
public slots:

private:
    shared_ptr<QNetworkAccessManager>nam_;
    QByteArray data_;

    bool error = true;     ///< 获取图片是否正确

    enum HTTP_DATA_TYPE{GET_IMAGE,       //下载图片，获取图片
                        UPLOAD_IMAGE     //上传图片
                        };
    HTTP_DATA_TYPE CURRENT_TYPE = GET_IMAGE;


    /// @brief 获取服务器资源数据
    void dealGetHttpData(QNetworkReply * reply);

    /// @brief 处理获取图片后的返回信息
    void dealGetImageReturnInfo(QNetworkReply * reply);

    /// @brief 处理上传图片后的返回信息
    void dealUploadImageReturnInfo(QNetworkReply * reply);

    shared_ptr<ReplyTimeout> rt_;         ///< 获取图片的超时设置
};

#endif // GETIMAGE_H
