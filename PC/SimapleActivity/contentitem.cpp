#include "contentitem.h"
#include "ui_contentitem.h"

ContentItem::ContentItem(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::ContentItem)
{
    ui->setupUi(this);

}


// 和服务器交互主要用这个构造函数
ContentItem::ContentItem(QWidget *parent,const QVector<QString> &urls, QString name, QString time, QString abstract, int join_num,int id,int p_id,const User & user,int praise_num)
    :QWidget(parent),user_(user),
     ui(new Ui::ContentItem),urls_(urls),name_(name),time_(time),abstract_(abstract),join_num_(join_num),id_(id),p_id_(p_id),praise_num_(praise_num)
{
    ui->setupUi(this);
    // 初始化参加活动界面
    this->setStyleSheet(ReadQStyleSheet::readQss(":/qss/qss_contentitem.qss"));
    get_image_.reset(new GetImage());
    image_num_ = urls.size();
//    qDebug()<<urls.size();
    setShowImage();
    QString default_image = ":/Login/C:/Users/ASUS/Pictures/Login/code.png";

    this->setStyleSheet(ReadQStyleSheet::readQss(":/qss/qss_contentitem.qss"));

    ui->label_name->setText(name_);
    ui->label_abstract->setText(abstract_);
    ui->label_create_time->setText(time_);
    ui->label_join_num->setText(QString("已参加%1人").arg(join_num_));
    ui->pushButton_praise->setText(QString("(%1)").arg(praise_num_));



    if(image_num_ == 1)
    {

        QPixmap pixmap = get_image_->get_image(urls[0]);
        QLabel * label = new QLabel(ui->widgetImageContent);
        int max = pixmap.height()>pixmap.width()?pixmap.height():pixmap.width();
        double x = max*1.0/300;
        QSize qsize(pixmap.width()/x,pixmap.height()/x);
//        qDebug()<<qsize.height()<<"-----"<<qsize.width();
        pix = pixmap.scaled(qsize,Qt::KeepAspectRatio);
        label->setPixmap(pix);
    }
    else if(image_num_ == 2)
    {

        QPixmap pixmap = get_image_->get_image(urls[0]);
        QPixmap pixmap2 = get_image_->get_image(urls[1]);
        QLabel * label1 = new QLabel(ui->widgetImageContent);
        QLabel * label2 = new QLabel(ui->widgetImageContent);
        label1->setFixedSize(150,150);

        label2->setFixedSize(150,150);
        label2->move(155,0);

        label1->setPixmap(pixmap.scaled(label1->size()));
        label2->setPixmap(pixmap2.scaled(label2->size()));

    }
    else
    {
        int i = 0;
        int j = 0;
        int n = 0;
        QPixmap pix;
        while(n<image_num_&&n<9)
        {
            // 一次最多显示九张
            pix = get_image_->get_image(urls[i]);
            QLabel * label = new QLabel(ui->widgetImageContent);
            label->setFixedSize(100,100);
            label->setPixmap(pix.scaled(QSize(100,100)));
            label->move(j*105,i*105);
//            qDebug()<<"["<<j<<","<<i<<"]";
            j = (j+1)%3;
            n++;
            if(n%3==0)
            {
                i++;
            }

        }

    }
}


// 测试
ContentItem::ContentItem(QWidget *parent, int num):
    QWidget(parent),praise_num_(10),name_("就是这个名字"),
    ui(new Ui::ContentItem),
    image_num_(num)
{
    ui->setupUi(this);
    setShowImage();

    ui->pushButton_praise->setText(QString("(%1)").arg(praise_num_));
    this->setStyleSheet(ReadQStyleSheet::readQss(":/qss/qss_contentitem.qss"));

    if(image_num_ == 1)
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
        pix = pixmap->scaled(qsize,Qt::KeepAspectRatio);
        label->setPixmap(pix);
    }
    else if(image_num_ == 2)
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
        while(n<image_num_&&n<=9)
        {
            QPixmap * pix = new QPixmap("C:/Users/ASUS/Pictures/Image/xyz.jpg");
            QLabel * label = new QLabel(ui->widgetImageContent);
            label->setFixedSize(100,100);
            label->setPixmap(pix->scaled(QSize(100,100)));
            label->move(j*105,i*105);
//            qDebug()<<"["<<j<<","<<i<<"]";
            j = (j+1)%3;
            n++;
            if(n%3==0)
            {
                i++;
            }
        }

    }
}

ContentItem::ContentItem(QWidget *parent, User user)
{

}



ContentItem::~ContentItem()
{
    delete ui;
}

// 待修改
void ContentItem::setShowImage()
{
    if(image_num_==0)
    {
        ui->widgetImageContent->setFixedHeight(1);
    }
    else if(image_num_==1)
    {
        ui->widgetImageContent->setFixedHeight(315);
    }
    else if(image_num_==2)
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


int ContentItem::get_height()
{
    return ui->widgetHead->height()+ui->widgetImageContent->height()+ui->widgetFoot->height()+40;
}

void ContentItem::on_toolButton_sign_up_clicked()
{
    if(!sign_activity_)    //点击的时候再申请内存
    {
        sign_activity_.reset(new SignUpActivity(0,id_,name_,user_.get_id()));
    }
    sign_activity_->show();
}


void ContentItem::on_pushButton_write_comment_clicked()
{
    if(!write_comment_)
    {
        write_comment_.reset(new WriteComment(name_,user_,p_id_));
    }
    write_comment_->show();
}

void ContentItem::on_pushButton_praise_clicked()
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
