#include "user.h"

User::User():id_(-1)
{

}

User::User(QString user_name, QString head_pic):
    headpath_(head_pic),nickname_(user_name)
{
    loadHeadPic();
}

User::User(int id, QString name, QString pwd, QString signature, bool sex, QString headpath, QString phone, QString email):
    id_(id),password_(pwd),nickname_(name),signature_(signature),sex_(sex),headpath_(headpath),phone_(phone),email_(email)
{
    loadHeadPic();
}

User::User(const User &obj):
    id_(obj.id_),password_(obj.password_),nickname_(obj.nickname_),signature_(obj.signature_),
    sex_(obj.sex_),headpath_(obj.headpath_),phone_(obj.phone_),email_(obj.email_)
{
    loadHeadPic();
}

User &User::operator =(const User & rhs)
{
    if(*this == rhs)
    {
        return *this;
    }
    id_ = rhs.id_;
    password_ = rhs.password_;
    nickname_ = rhs.nickname_;
    signature_ = rhs.nickname_;
    sex_ = rhs.sex_;
    headpath_ = rhs.headpath_;
    phone_ = rhs.phone_;
    email_ = rhs.email_;
    headPixmap_ = rhs.headPixmap_;

    return *this;
}

bool User::operator ==(const User &rhs)  // 以id判断两个人是否相同
{
    return id_==rhs.id_;
}

QPixmap User::getHeadPixmap() const
{
    return headPixmap_;
}

void User::loadHeadPic()
{
    shared_ptr<GetImage>get_img(new GetImage());
    headPixmap_ = get_img->get_image(QUrl(headpath_));
}

