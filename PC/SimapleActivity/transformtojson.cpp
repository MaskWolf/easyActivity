#include "transformtojson.h"

TransformToJson::TransformToJson()
{

}

QByteArray TransformToJson::activityToJson(int u_id, const MainActivity *main_activity,const QVector<QPair<QString, QString>> &field_list, const QVector<ChildActivity>& child_data)
{
    QJsonDocument json_doc;
    QJsonObject json_obj;
    //json_obj.insert("uName",uName);

    //主活动信息对象
    QJsonObject json_main_act_obj;
    json_main_act_obj.insert("aName",main_activity->get_name());
    json_main_act_obj.insert("aDeadlineTime",main_activity->get_dead_time());
    json_main_act_obj.insert("uId",u_id);
    json_main_act_obj.insert("aAbstract",main_activity->get_abstract());
    json_main_act_obj.insert("aDescription",main_activity->get_description());
    json_main_act_obj.insert("aAddress",main_activity->get_address());

    //报名表字段数组
    QJsonArray json_field_array;
    for(int i = 0;i<field_list.size();i++)
    {
        QJsonObject json_temp;
        json_temp.insert("fieldName",field_list[i].first);
        json_temp.insert("fieldNotice",field_list[i].second);
        json_field_array.append(QJsonValue(json_temp));
        json_temp.remove("fieldName");
        json_temp.remove("fieldNotice");
    }

    //子活动信息
    QJsonArray json_child_act_array;
    for(int i = 0;i<child_data.size();i++)
    {
        QJsonObject json_temp;
        json_temp.insert("caName",child_data[i].get_name());
        json_temp.insert("caDescription",child_data[i].get_description());
        json_temp.insert("caScore",child_data[i].get_score());
        json_temp.insert("caDayMaxJoin",child_data[i].get_join_max());
        json_child_act_array.append(QJsonValue(json_temp));
        json_temp.remove("caDayMaxJoin");\
        json_temp.remove("caScore");
        json_temp.remove("caName");
        json_temp.remove("caDescription");
    }

    json_obj.insert("activity",QJsonValue(json_main_act_obj));
    json_obj.insert("fieldList",QJsonValue(json_field_array));
    json_obj.insert("childActivityList",QJsonValue(json_child_act_array));

    json_doc.setObject(json_obj);
    QByteArray bytes = json_doc.toJson(QJsonDocument::Compact);


    return bytes;

}

QByteArray TransformToJson::childActivityAndEntryFormToJson(int a_id, int u_id, const QList<QPair<int, QString> > &field_list, const QVector<int> &list_child_activity)
{
    QJsonDocument json_doc;
    QJsonObject json_obj;
    json_obj.insert("aId",a_id);
    json_obj.insert("uId",u_id);


    // 填写的报名信息
    QJsonArray array_sign_up;
    QJsonObject temp;
    for(int i = 0;i<field_list.size();i++)
    {
        temp.insert("fId",field_list[i].first);
        temp.insert("content",field_list[i].second);
        temp.insert("uId",u_id);
        array_sign_up.append(QJsonValue(temp));
        temp.remove("fId");
        temp.remove("uId");
        temp.remove("content");
    }

    // 选择的子活动id
    QJsonArray array_child_act;
    for(int i = 0;i<list_child_activity.size();i++)
    {
        array_child_act.append(QJsonValue(list_child_activity[i]));
    }

    json_obj.insert("signUpMessage",QJsonValue(array_sign_up));
    json_obj.insert("childActivity",QJsonValue(array_child_act));

    json_doc.setObject(json_obj);

    QByteArray bytes = json_doc.toJson(QJsonDocument::Compact);

    return bytes;
}




