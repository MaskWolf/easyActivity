#include "replytimeout.h"

ReplyTimeout::ReplyTimeout(QObject *parent) : QObject(parent)
{

}

ReplyTimeout::ReplyTimeout(QNetworkReply *reply, int timeout):
    QObject(reply)
{
    Q_ASSERT(reply);
    //Q_ASSERT(false);
    if(reply&&reply->isRunning())
    {
        QTimer::singleShot(timeout,this,&ReplyTimeout::onTimeout);
    }
}

void ReplyTimeout::checking(QNetworkReply *reply, int timeout)
{
    Q_ASSERT(reply);
    if(reply&&reply->isRunning())
    {
        QTimer::singleShot(timeout,this,&ReplyTimeout::onTimeout);
    }
}

void ReplyTimeout::onTimeout()
{
    QNetworkReply * reply = dynamic_cast<QNetworkReply*>(parent());
    if(reply&&reply->isRunning())
    {
        reply->abort();
        reply->deleteLater();
        emit timeout();
    }
}

