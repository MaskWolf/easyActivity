#ifndef TRANSFORMTOJSON_H
#define TRANSFORMTOJSON_H

#include <QByteArray>
#include <QString>
#include <QJsonArray>
#include <QJsonObject>
#include <QJsonDocument>
#include <QDebug>
#include <QList>
#include <QPair>

#include "mainactivity.h"
#include "childactivityitem.h"
#include "childactivity.h"

class TransformToJson
{
public:
    TransformToJson();


    /// @brief 将创建整个活动的信息按照一定格式转化为Json数据
    /// @param uName 创建此活动的用户的用户名
    /// @param main_activity 创建的主活动信息
    /// @param field_list 活动报名表的字段属性
    /// @param child_data 创建的子活动的所有信息
    /// @return QByteArray 返回Json形式的字节数组
    static QByteArray activityToJson(int u_id,const MainActivity * main_activity,const QVector<QPair<QString,QString> >&field_list,const QVector<ChildActivity>&child_data);
    static QByteArray childActivityAndEntryFormToJson(int a_id,int u_id,const QList<QPair<int,QString>> & field_list,const QVector<int>&list_child_activity);
};

#endif // TRANSFORMTOJSON_H
