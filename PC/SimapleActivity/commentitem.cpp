#include "commentitem.h"
#include "ui_commentitem.h"

CommentItem::CommentItem(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::CommentItem)
{
    ui->setupUi(this);
}

CommentItem::CommentItem(QWidget *parent,int c_id, const User &from_user, const QString &content,const QString & publish_time):
    QWidget(parent),from_user_(from_user),current_content_(content),c_id_(c_id),
    ui(new Ui::CommentItem)
{
    ui->setupUi(this);
    ui->widget_last_cpntent->setHidden(true);
    this->setStyleSheet("#widget_curr_content{border:1px solid red;}"
                        "#widget_last_cpntent{border:1px solid blue;}"
                        "#widget_foot_nav{border:1px solid green;}");
    this->setFixedHeight(91);  //124-33
    height_ = 91;
//    QPixmap pix(":/Login/C:/Users/ASUS/Pictures/Login/code.png");
    QPixmap p = from_user_.getHeadPixmap();
    ui->label_head->setPixmap(GetImage::get_round_image(p,20));
    ui->label_curr_content->setText(content);
    ui->label_curr_name->setText(from_user_.get_nickname());
    ui->label_time->setText(publish_time);
//    ui->label_curr_name->adjustSize();
    initWindResource();
}

CommentItem::CommentItem(QWidget *parent,int c_id, const User &from_user, const QString &c_content, const QString &to_name, const QString &l_content,const QString & publish_time):
    QWidget(parent),from_user_(from_user),current_content_(c_content),last_content_(l_content),to_name_(to_name),height_(124),
    ui(new Ui::CommentItem),c_id_(c_id)
{
    ui->setupUi(this);
//    QPixmap pix(":/Login/C:/Users/ASUS/Pictures/Login/code.png");
    QPixmap p = from_user_.getHeadPixmap();
    ui->label_head->setPixmap(GetImage::get_round_image(p,20));
    this->setStyleSheet("#widget_curr_content{border:1px solid red;}"
                        "#widget_last_cpntent{border:1px solid blue;}"
                        "#widget_foot_nav{border:1px solid green;}");
    ui->label_curr_content->setText(c_content);
    ui->label_curr_name->setText(from_user_.get_nickname());
    ui->label_last_content->setText(l_content);
    ui->label_last_name->setText(QString("@")+to_name_);
    ui->label_time->setText(publish_time);
    initWindResource();
}

CommentItem::~CommentItem()
{
    delete ui;
}

int CommentItem::height() const
{
    return height_;
}

void CommentItem::setHeight(int height)
{
    height_ = height;
}

void CommentItem::on_pushButton_reply_clicked()
{
    emit replyComment(from_user_.get_nickname(),current_content_,c_id_);
    Cout<<"发射信号    "<<c_id_;
}

void CommentItem::initWindResource()
{
    this->setStyleSheet(ReadQStyleSheet::readQss(":/qss/qss_commentitem.qss"));
}
