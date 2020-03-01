/**
  * @file
  * @brief 从文件读出Qss渲染样式
  * @version 1.0
  * @date 2019年5月9日22:00:18
  * @author zsj
*/

#ifndef READQSTYLESHEET_H
#define READQSTYLESHEET_H

#include <QString>
#include <QFile>
#include <QDebug>
#include <QString>

#define  Cout qDebug()<<"[ "<<__FILE__<<":"<<__LINE__<<" ]"


class ReadQStyleSheet
{
public:
    ReadQStyleSheet();

    /// @brief 从文件中读出渲染样式
    /// @param filePath 文件路径
    /// @return QString Qss样式
    static QString readQss(QString filePath);


    static void setUrl(const QString & url);

    static QString g_ip_url;
};

#endif // READQSTYLESHEET_H
