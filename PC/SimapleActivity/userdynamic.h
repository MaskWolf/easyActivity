/**
  * @file
  * @brief 用户发布的动态
  *
  *     显示用户发出的每条动态
  *     用户可以在每条动态中添加文字和图片，图片一次最多显示9张
  * @version 1.0
  * @date 2019年5月28日15:33:07
  * @author zsj
  */

#ifndef USERDYNAMIC_H
#define USERDYNAMIC_H

#include <QWidget>
#include <QVector>
#include <QList>
#include <QString>
#include <QDate>
#include <QFileDialog>
#include <QPixmap>
#include <QDate>
#include <memory>



using std::shared_ptr;


#include "user.h"
#include "readqstylesheet.h"
#include "writecomment.h"
#include "getimage.h"



/*  思路：
 *  用户动态有两种方式创建：
 *      1.用户自己创建
 *          1.1 图片需要上传服务器
 *          1.2 用户评论此动态时也需要显示图片
 *          1.3 用户创建时传递图片路径，然后再加载到图片容器
 *
 *      2.从服务器下载下来显示
 *          1.1 图片从服务器下载
 *          1.2 用户评论时需要显示图片
 *          1.3 服务器下载直接传递图片容器过来，直接加载
 *  总结：每一个动态都保存所有图片（但动态过多会造成内存过大）
 *
 *
 */
namespace Ui {
class UserDynamic;
}

class UserDynamic : public QWidget
{
    Q_OBJECT

public:
    /// @brief 默认构造函数。构造一个“动态”界面
    /// @note 此函数需配合loadImage和setInitData函数才能完成显示内容
    ///     此函数在用户进行评论的时候调用
    explicit UserDynamic(QWidget *parent = 0);

    /// @brief 构造函数。构造一个“动态”，需要发布动态的用户、动态的文字内容、动态含有的图片
    /// @param wc_user 发布动态用户的信息,被评论的用户
    /// @param c_user 评论的用户
    /// @param content 发布的动态的文字内容
    /// @param pics 发布的动态的所有图片的所有的路径
    /// @note 此函数在用户发布动态的时候调用，配合loadImage函数才能完整显示图片
    UserDynamic(QWidget *parent,const User & wc_user,const User & c_user,const QString & content,const QStringList & pics,int p_id,int praise_num);

    //调试函数需要
    UserDynamic(QWidget *parent, const User & wc_user,const User & c_user,const QString & content,int num);


    /// @brief 构造函数。构造一个“动态”。
    /// @param user 发布此“动态”的用户
    /// @param content 此“动态”的文字内容
    /// @param publish_time 此“动态”发布的时间
    /// @param pixmap_list 此“动态”的图片
    /// @note 此函数在从服务器显示数据的时候调用
    UserDynamic(QWidget *parent,const User & wc_user,const User & c_user,const QString & content,const QList<QPixmap>&pixmap_list,int p_id,int praise_num);

    /// @brief 返回当前此模块的高度，该模块会随着图片的多少显示不同的高度
    /// @return int 模块当前高度
    int getHeight();




    /// @brief 加载动态。将所有的动态信息加载出来
    void loadDynamic();




    inline const User & getUser()const{return wc_user_;}
    inline const QString & getContent()const{return content_;}
    inline const QList<QPixmap>& getImages(){return pixmap_list_;}
    inline const QDate & getpublishDate(){return publish_time_;}
    ~UserDynamic();

private slots:
    void on_pushButton_write_comment_clicked();


    /// @brief 点赞
    void on_pushButton_praise_clicked();

private:
    Ui::UserDynamic *ui;

    User wc_user_;               ///< 发布动态的用户的信息
    User c_user_;                  ///< 进行评论的用户信息
    QString content_;         ///< 发布的动态的文字内容

    int image_num_;           ///< 发布动态的图片的数量

    QList<QPixmap> pixmap_list_; ///< 保存此活动下的所有图片

    QDate publish_time_;      ///< “动态”发布的时间

    int p_id_;          ///< 此动态的id

    int praise_num_;   ///< 此动态获赞的多少


    bool flag_ = false;        ///< 点赞按钮是否被按下

    shared_ptr<WriteComment> write_comment_;

    /// @brief 初始化界面资源和配置
    void initWidgetResource();


    /// @brief 根据图片的数量设置显示图片组件的高度
    void setShowImageHeight();


    /// @brief 设置当前应该显示的图片
    void setImage();

    //测试作用
    void setImage(int image_num);

    /// @brief 从图片路径列表中加载图片到图片序列中
    void loadImages(const QStringList & pics);

    /// @brief 设置界面的两个按钮是否隐藏
    void setHiddenButton(bool flag);

};

#endif // USERDYNAMIC_H
