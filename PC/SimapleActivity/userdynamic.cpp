#include "userdynamic.h"
#include "ui_userdynamic.h"

UserDynamic::UserDynamic(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::UserDynamic)
{
    ui->setupUi(this);
}

UserDynamic::UserDynamic(QWidget *parent, const User  &wc_user,const User & c_user,const QString & content,const QStringList & pics,int p_id,int praise_num):
    QWidget(parent),image_num_(pics.size()),publish_time_(QDate::currentDate()),wc_user_(wc_user),c_user_(c_user),content_(content),p_id_(p_id),praise_num_(praise_num),
    ui(new Ui::UserDynamic)
{
    ui->setupUi(this);
    setShowImageHeight();
    loadImages(pics);
    setImage();
    ui->widgetImageContent->setStyleSheet("border:1px solid red;");
    ui->widget_text->setStyleSheet("border:1px solid blue;");
    QPixmap pix(":/Login/C:/Users/ASUS/Pictures/Image/123.jpg");
    QPixmap p = pix.scaled(40,40);
    ui->label_head->setPixmap(GetImage::get_round_image(p,20));
    ui->label_content->setText(content);
    ui->label_user_name->setText(wc_user.get_nickname());
    ui->label_write_time->setText(publish_time_.toString("yyyy-MM-dd"));

    ui->pushButton_praise->setText(QString("(%1)").arg(praise_num_));


    initWidgetResource();
}

UserDynamic::UserDynamic(QWidget *parent, const User & wc_user,const User & c_user,const QString & content, int num):
    QWidget(parent),image_num_(num),publish_time_(QDate::currentDate()),wc_user_(wc_user),c_user_(c_user),content_(content),
    ui(new Ui::UserDynamic),praise_num_(10)
{
    ui->setupUi(this);
    setShowImageHeight();
    setImage(num);
    ui->widgetImageContent->setStyleSheet("border:1px solid red;");
    ui->widget_text->setStyleSheet("border:1px solid blue;");
    QPixmap pix(":/Login/C:/Users/ASUS/Pictures/Image/123.jpg");
    QPixmap p = pix.scaled(40,40);
    ui->label_head->setPixmap(GetImage::get_round_image(p,20));
    ui->label_content->setText(content);
    ui->label_user_name->setText(wc_user_.get_nickname());
    ui->label_write_time->setText(QDate::currentDate().toString("yyyy-MM-dd"));
    ui->pushButton_praise->setText(QString("(%1)").arg(praise_num_));

    initWidgetResource();
}

UserDynamic::UserDynamic(QWidget *parent, const User &wc_user,const User & c_user, const QString &content, const QList<QPixmap> &pixmap_list,int p_id,int praise_num):
    QWidget(parent),image_num_(pixmap_list.size()),wc_user_(wc_user),c_user_(c_user),p_id_(p_id),praise_num_(praise_num),
    ui(new Ui::UserDynamic),pixmap_list_(pixmap_list)
{
    ui->setupUi(this);
    setShowImageHeight();
    setImage();
    QPixmap head_image = wc_user_.getHeadPixmap();
    ui->label_head->setPixmap(GetImage::get_round_image(head_image,20));
    ui->label_content->setText(content);
    ui->label_user_name->setText(wc_user.get_nickname());
    ui->label_write_time->setText(QDate::currentDate().toString("yyyy-MM-dd"));
    ui->pushButton_praise->setText(QString("(%1)").arg(praise_num_));

    initWidgetResource();
}


UserDynamic::~UserDynamic()
{
    delete ui;
}

void UserDynamic::setShowImageHeight()
{
    if(image_num_==0)
    {
        ui->widgetImageContent->setFixedHeight(1);
    }
    else if(image_num_ ==1)
    {
        ui->widgetImageContent->setFixedHeight(315);

    }
    else if(image_num_ ==2)
    {
        ui->widgetImageContent->setFixedHeight(155);

    }
    else if(image_num_>=3&&image_num_<=6)
    {
        ui->widgetImageContent->setFixedHeight(210);

    }
    else
    {
        ui->widgetImageContent->setFixedHeight(315);
    }
}

void UserDynamic::initWidgetResource()
{
    this->setStyleSheet(ReadQStyleSheet::readQss(":/qss/qss_userdynamic.qss"));
}

void UserDynamic::setImage(int image_num)
{
    if(image_num == 1)
    {
        QPixmap * pixmap = new QPixmap("C:/Users/ASUS/Pictures/Image/xyz.jpg");
        if(pixmap->isNull())
        {
            Cout<<"NULL";
            return;
        }
        QLabel * label = new QLabel(ui->widgetImageContent);
        int max = pixmap->height()>pixmap->width()?pixmap->height():pixmap->width();
        int x = max/300;
        QSize qsize(pixmap->width()/x,pixmap->height()/x);
        QPixmap pix = pixmap->scaled(qsize,Qt::KeepAspectRatio);
        label->setPixmap(pix);
    }
    else if(image_num == 2)
    {
        QPixmap * pixmap = new QPixmap("C:/Users/ASUS/Pictures/Image/xyz.jpg");
        if(pixmap->isNull())
        {
            Cout<<"NULL";
            return;
        }
        QLabel * label1 = new QLabel(ui->widgetImageContent);
        QLabel * label2 = new QLabel(ui->widgetImageContent);
        label1->setFixedSize(150,150);

        label2->setFixedSize(150,150);
        label2->move(155,0);

        label1->setPixmap(pixmap->scaled(label1->size()));
        label2->setPixmap(pixmap->scaled(label2->size()));
    }
    else
    {
        int i = 0;
        int j = 0;
        int n = 0;
        while(n<image_num&&n<=9)
        {
            QPixmap * pix = new QPixmap("C:/Users/ASUS/Pictures/Image/xyz.jpg");
            QLabel * label = new QLabel(ui->widgetImageContent);
            label->setFixedSize(100,100);
            label->setPixmap(pix->scaled(QSize(100,100)));
            label->move(j*105,i*105);
            Cout<<"["<<j<<","<<i<<"]";
            j = (j+1)%3;
            n++;
            if(n%3==0)
            {
                i++;
            }
        }

    }
}


void UserDynamic::loadDynamic()
{
    // 设置显示图片的高度
    setShowImageHeight();
    // 显示已经加载好的图片
    setImage();
    //隐藏掉两个按钮
    setHiddenButton(true);
}

void UserDynamic::setImage()
{
    if(image_num_<1)
    {
        return;
    }
//    Cout<<"UserDynamic::setImage";
    if(image_num_ == 1)
    {
        QPixmap pixmap =pixmap_list_[0];
        QLabel * label = new QLabel(ui->widgetImageContent);
        int max = pixmap.height()>pixmap.width()?pixmap.height():pixmap.width();
        int x = max/300;
        QSize qsize(pixmap.width()/x,pixmap.height()/x);
        QPixmap pix = pixmap.scaled(qsize,Qt::KeepAspectRatio);
        label->setPixmap(pix);
    }
    else if(image_num_ == 2)
    {

        QLabel * label1 = new QLabel(ui->widgetImageContent);
        QLabel * label2 = new QLabel(ui->widgetImageContent);
        label1->setFixedSize(150,150);

        label2->setFixedSize(150,150);
        label2->move(155,0);

        label1->setPixmap(pixmap_list_[0].scaled(label1->size()));
        label2->setPixmap(pixmap_list_[1].scaled(label2->size()));
    }
    else
    {
        int i = 0;
        int j = 0;
        int n = 0;
        while(n<image_num_&&n<=9)
        {
            QLabel * label = new QLabel(ui->widgetImageContent);
            label->setFixedSize(100,100);
            label->setPixmap(pixmap_list_[n].scaled(QSize(100,100)));
            label->move(j*105,i*105);
//            Cout<<"["<<j<<","<<i<<"]";
            j = (j+1)%3;
            n++;
            if(n%3==0)
            {
                i++;
            }
        }

    }
}

int UserDynamic::getHeight()
{
    if(image_num_ == 1)
    {
        return 475;
    }
    return ui->widget_head->height()+ui->widget_text->height()+ui->widgetImageContent->height()+ui->widget_foot->height()+120;
}

void UserDynamic::setHiddenButton(bool flag)
{
//    ui->label_praise_num->setHidden(flag);
//    ui->label_praise->setHidden(flag);
    ui->pushButton_write_comment->setHidden(flag);
}

void UserDynamic::loadImages(const QStringList &pics)
{
    for(auto str:pics)
    {
        QPixmap pix(str);
        if(pix.isNull())
        {
            pix.load(":/Login/C:/Users/ASUS/Pictures/Login/code.png");
        }
        pixmap_list_.push_back(pix);
    }
}

void UserDynamic::on_pushButton_write_comment_clicked()
{
    if(!write_comment_)
    {
        write_comment_.reset(new WriteComment(wc_user_,c_user_,p_id_));
        // 接收可能发出的评论并和服务器交互
    }
    write_comment_->show();
}

void UserDynamic::on_pushButton_praise_clicked()
{
    flag_ = !flag_;
    if(flag_)
    {
        ui->pushButton_praise->setText(QString("(%1)").arg(++praise_num_));
        ui->pushButton_praise->setIcon(QPixmap(":/Main/C:/Users/ASUS/Pictures/Camera Roll/wgw.png"));
    }
    else
    {
        ui->pushButton_praise->setText(QString("(%1)").arg(--praise_num_));
        ui->pushButton_praise->setIcon(QPixmap(":/Main/C:/Users/ASUS/Pictures/Camera Roll/wgz.png"));
    }
}
