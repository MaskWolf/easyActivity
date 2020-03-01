/**
  * @file
  * @brief 主活动类
  *
  *
  * @version 1.0
  * @date 2019年5月14日17:21:57
  * @author zsj
  */
#ifndef MAINACTIVITY_H
#define MAINACTIVITY_H

#include <QString>
#include <QDate>
#include <QStringList>

class MainActivity
{
public:
    MainActivity();
    MainActivity(int a_id,QString name,QString dead_time,QString abstract,QString description,QString address);
    MainActivity(int a_id,int u_id,QString name,QString create_time_,QString dead_time,int participation,
                 QString abstract,QString description,QString address,const QStringList & pic_path,int status,QString notice,
                 bool have_child,int total_score);
    MainActivity(const MainActivity & rhs);
    /// @brief 重新设置所有值
    void reset(int u_id,QString name,QString dead_time,QString abstract,QString description,QString address,QString notice);

    inline const QString get_name()const{return name_;}
    inline const QString get_dead_time()const{return dead_time_;}
    inline const QString get_abstract()const{return abstract_;}
    inline const QString get_description()const{return description_;}
    inline const QString get_address()const{return address_;}
    //inline int get_id(){return id_;}
    inline  int get_a_id()const{return a_id_;}
    inline  int get_u_id()const {return u_id_;}
    inline const QString get_create_time()const{return create_time_;}
    inline  int get_participation()const{return participation_;}
    inline  int get_status()const{return status_;}
    inline const QString get_notice()const {return notice_;}
    inline  bool get_have_child()const {return have_child_;}
    inline  int get_total_score()const{return total_score_;}

private:
    int a_id_;      ///< 活动id
    int u_id_;      ///< 创建此活动用户的id
    QString name_;  ///< 活动名字
    QString create_time_;     ///< 创建时间
    QString dead_time_;       ///< 结束时间
    int participation_;      ///< 参加此活动的人数
    QString abstract_;      ///< 摘要
    QString description_;   ///< 描述
    int status_;            ///< 活动状态
    QString notice_;        ///< 活动公告
    bool have_child_;       ///< 此活动有无子活动
    QString address_;       ///< 活动地点
    int total_score_;       ///< 活动总分
    QStringList pic_path_;      ///< 活动图片

};

#endif // MAINACTIVITY_H
