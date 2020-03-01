/**
  * @file
  * @brief 用户信息
 */

#ifndef USER_H
#define USER_H

#include <QString>
#include <QPixmap>
#include <memory>




#include "getimage.h"

using namespace std;

class User
{
public:
    User();
    User(QString user_name,QString head_pic);
    User(int id,QString name,QString pwd,QString signature,bool sex,QString headpath,QString phone,QString email);
    User(const User & obj);
    User & operator =(const User & rhs);
    bool operator ==(const User & rhs);


    /// @brief 将id设置为-1，标志此User不可用
    inline void clear(){id_ = -1;}

    inline int get_id(){return id_;}
    inline QString get_nickname()const{return nickname_;}
    inline QString get_password(){return password_;}
    inline bool get_sex(){return sex_;}
    inline QString get_headpath(){return headpath_;}
    inline QString get_phone(){return phone_;}
    inline QString get_email(){return email_;}
    inline QString get_signature(){return signature_;}
    QPixmap getHeadPixmap() const;

private:
    int  id_ = -1;
    QString nickname_;
    QString password_;
    QString signature_;
    bool sex_ = false;
    QString headpath_;
    QString phone_;
    QString email_;

    QPixmap headPixmap_;

    /// @brief 根据headpath_加载头像
    void loadHeadPic();
};

#endif // USER_H
