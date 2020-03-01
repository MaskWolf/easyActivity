/**
  * @file
  * @brief 子活动所有信息
  * @date 2019年6月4日11:14:40
  * @version 1.0
  * @author zsj
  */
#ifndef CHILDACTIVITY_H
#define CHILDACTIVITY_H


#include <QString>


class ChildActivity
{
public:
    ChildActivity();
    ChildActivity(const ChildActivity & rhs);
    ChildActivity(int ca_id,int a_id,QString ca_name,QString ca_description,double ca_score,int ca_day_max_join);
    bool operator == (const ChildActivity & rhs);
    // 成员变量并未包含指针类型  这里不用重载operator=运算符
    inline int get_ca_id()const{return ca_id_;}
    inline int get_a_id()const{return a_id_;}
    inline const QString & get_name()const{return ca_name_;}
    inline const QString & get_description()const{return ca_description_;}
    inline double get_score()const{return ca_socre_;}
    inline int get_join_max()const{return ca_day_max_join_;}
    inline bool get_is_avaiable()const{return ca_is_avaiable_;}
private:
    int ca_id_;     ///< 该子活动id
    int a_id_;      ///< 属于的主活动的id
    QString ca_name_;  ///< 子活动名称
    QString ca_description_;  ///< 子活动描述
    double ca_socre_;      ///< 单次参加此活动获取的积分
    int ca_day_max_join_;  ///< 单日可参加的次数
    bool ca_is_avaiable_;  ///< 此活动是否可用
};

#endif // CHILDACTIVITY_H
