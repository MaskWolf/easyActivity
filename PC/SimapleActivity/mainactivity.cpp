#include "mainactivity.h"

MainActivity::MainActivity()
{

    a_id_ = 0;
    u_id_ = 0;
    name_ = "默认活动";
    create_time_ = QDate::currentDate().toString("yyyy-MM-dd");
    dead_time_ = create_time_;
    participation_ = 0;
    abstract_ = "就是一个默认活动";
    description_ = "我也不清楚到底是什么活动";
    status_ = 0;
    notice_ = "今天谁也不知道";
    have_child_ = false;
    address_ = "重庆不知道大学";
    total_score_ = 0;

}

MainActivity::MainActivity(int a_id,QString name, QString dead_time, QString abstract, QString description, QString address):
    name_(name),dead_time_(dead_time),abstract_(abstract),description_(description),address_(address),a_id_(a_id)
{

}

MainActivity::MainActivity(int a_id, int u_id, QString name, QString create_time, QString dead_time, int participation, QString abstract,QString address, QString description, const QStringList & pic_path, int status, QString notice, bool have_child, int total_score):
    a_id_(a_id),u_id_(u_id),name_(name),create_time_(create_time),dead_time_(dead_time),participation_(participation),address_(address),
    abstract_(abstract),description_(description),pic_path_(pic_path),status_(status),notice_(notice),
    have_child_(have_child),total_score_(total_score)
{

}

MainActivity::MainActivity(const MainActivity &rhs)
{
    name_ = rhs.name_;
    dead_time_ = rhs.dead_time_;
    abstract_ = rhs.abstract_;
    description_ = rhs.description_;
    address_ = rhs.address_;
    u_id_ = rhs.u_id_;
    notice_ = rhs.notice_;
    a_id_ = rhs.a_id_;
    create_time_ = rhs.create_time_;
    participation_ = rhs.participation_;
    status_ = rhs.status_;
    have_child_ = rhs.have_child_;
    total_score_ = rhs.total_score_;
    pic_path_ = rhs.pic_path_;

    //    int a_id_;      ///< 活动id
    //    int u_id_;      ///< 创建此活动用户的id
    //    QString name_;  ///< 活动名字
    //    QString create_time_;     ///< 创建时间
    //    QString dead_time_;       ///< 结束时间
    //    int participation_;      ///< 参加此活动的人数
    //    QString abstract_;      ///< 摘要
    //    QString description_;   ///< 描述
    //    int status_;            ///< 活动状态
    //    QString notice_;        ///< 活动公告
    //    bool have_child_;       ///< 此活动有无子活动
    //    QString address_;       ///< 活动地点
    //    int total_score_;       ///< 活动总分
    //    QStringList pic_path_;      ///< 活动图片

}

void MainActivity::reset(int u_id,QString name, QString dead_time, QString abstract, QString description, QString address,QString notice)
{
    name_ = name;
    dead_time_ = dead_time;
    abstract_ = abstract;
    description_ =description;
    address_ = address;
    u_id_ = u_id;
    notice_ = notice;



}

