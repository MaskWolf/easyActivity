/**
  * @file
  * @brief 处理网络请求超时的情况
  *
  * @version 1.0
  * @author zsj
  * @date 2019年6月4日20:29:57
  */
#ifndef REPLYTIMEOUT_H
#define REPLYTIMEOUT_H

#include <QObject>
#include <QTimer>
#include <QNetworkReply>

class ReplyTimeout : public QObject
{
    Q_OBJECT
public:
    explicit ReplyTimeout(QObject *parent = 0);
    ReplyTimeout(QNetworkReply * reply,int timeout);

    void checking(QNetworkReply *reply,int timeout);

signals:
    void timeout();
public slots:
    void onTimeout();
};

#endif // REPLYTIMEOUT_H
