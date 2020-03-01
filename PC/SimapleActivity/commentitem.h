/**
  * @file
  * @brief 评论的子项，“一条评论”界面
  *
  *     显示用户评论的内容
  * @version 1.0
  * @author zsj
  * @date 2019年5月30日12:33:51
  */
#ifndef COMMENTITEM_H
#define COMMENTITEM_H

#include <QWidget>
#include <QString>

#include "user.h"
#include "readqstylesheet.h"
#include "getimage.h"

namespace Ui {
class CommentItem;
}

class CommentItem : public QWidget
{
    Q_OBJECT

public:
    explicit CommentItem(QWidget *parent = 0);


    /// @brief 评论用户或者活动
    /// @param from_user 评论者的信息  写这一条评论的人
    /// @param content 评论的内容
    CommentItem(QWidget *parent,int c_id,const User & from_user,const QString & content,const QString & publish_time);

    /// @brief 回复用户的评论
    /// @param from_user 写下此评论的人
    /// @param c_content 当前评论的内容
    /// @param to_name  当前评论回复的用户的用户名
    /// @param l_content 当前评论回复的用户所写的评论
    /// @
    CommentItem(QWidget *parent,int c_id, const User &from_user, const QString &c_content,const QString & to_name_,const QString & l_content,const QString & publish_time);
    ~CommentItem();

    int height() const;
    void setHeight(int height);

    inline int get_id()const{return c_id_;}

private slots:
    void on_pushButton_reply_clicked();

private:
    Ui::CommentItem *ui;

    User from_user_;            ///< 当前评论的用户
    QString to_name_;              ///< 回复的用户
    QString current_content_;   ///< 当前评论内容
    QString last_content_;       ///< 回复用户所写评论

    int c_id_ = -1;        ///< 评论的id

    int height_ = -1;   ///< 当前评论块的高度

    void initWindResource();
signals:
    void replyComment(const QString & user_name,const QString & content,int c_id);


};

#endif // COMMENTITEM_H
