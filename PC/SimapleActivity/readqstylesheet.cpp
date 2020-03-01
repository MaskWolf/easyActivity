#include "readqstylesheet.h"

QString ReadQStyleSheet::g_ip_url = "http://192.168.1.237:8080/test";

ReadQStyleSheet::ReadQStyleSheet()
{

}

QString ReadQStyleSheet::readQss(QString filePath)
{
    QFile file(filePath);
    if(file.open(QIODevice::ReadOnly))
    {
        QString StyleSheet(file.readAll());
        file.close();
        return StyleSheet;
    }
    return QString("");
}

void ReadQStyleSheet::setUrl(const QString &url)
{
    g_ip_url = url+":8080/test";
}

