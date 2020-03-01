#include "childactivityitem.h"
#include "ui_childactivityitem.h"

ChildActivityItem::ChildActivityItem(QWidget *parent) :
    QWidget(parent),is_active_(false),
    ui(new Ui::ChildActivityItem)
{
    ui->setupUi(this);
}

ChildActivityItem::ChildActivityItem(QWidget *parent, QString child_activity_name, QString child_activit_abstract) :
    QWidget(parent),is_active_(false),child_activity_name_(child_activity_name),
    child_activit_abstract_(child_activit_abstract),
    ui(new Ui::ChildActivityItem)
{
    ui->setupUi(this);
    ui->label_activity_name->setText(child_activity_name);
    ui->label_activity_abstract->setText(child_activit_abstract);
    initWidgetResource();


    update_.reset(new CreateChildActivity("修改子活动信息"));
    // 接收修改活动信息界面发送的提交消息
    connect(update_.get(),&CreateChildActivity::created,this,[=](QString name,QString abstract,int max_join,double score){
        ui->label_activity_name->setText(name);
        ui->label_activity_abstract->setText(abstract);
    });


}

ChildActivityItem::ChildActivityItem(QWidget *parent, QString child_activity_name, QString child_activit_abstract, int id):
    QWidget(parent),is_active_(false),child_activity_name_(child_activity_name),
    child_activit_abstract_(child_activit_abstract),ca_id_(id),
    ui(new Ui::ChildActivityItem)
{
    ui->setupUi(this);

    ui->label_activity_name->setText(child_activity_name);
    ui->label_activity_abstract->setText(child_activit_abstract);
    initWidgetResource();




}

ChildActivityItem::ChildActivityItem(QWidget *parent, QString child_activity_name, QString child_activit_abstract, int max_join, double score):
    QWidget(parent),child_activity_name_(child_activity_name),child_activit_abstract_(child_activit_abstract ),
    max_join_(max_join),score_(score),
    ui(new Ui::ChildActivityItem)
{
    ui->setupUi(this);

    Cout<<"构造";
    ui->label_activity_name->setText(child_activity_name);
    ui->label_activity_abstract->setText(child_activit_abstract);
    initWidgetResource();
}

ChildActivityItem::ChildActivityItem(QWidget *parent, const ChildActivity &ca):
    QWidget(parent),ca_(ca),
    ui(new Ui::ChildActivityItem)
{
    ui->setupUi(this);
}

void ChildActivityItem::reset(QString name, QString abstract)
{
    ui->label_activity_name->setText(name);
    ui->label_activity_abstract->setText(abstract);
}

ChildActivityItem::~ChildActivityItem()
{
    delete ui;
}

void ChildActivityItem::initWidgetResource()
{
    ui->label_created_time->setText(QDate::currentDate().toString("yyyy-MM-dd"));
}

void ChildActivityItem::mousePressEvent(QMouseEvent * e)
{
    if(is_active_)
    {
        if(!changed_)
        {
            this->setStyleSheet("#widget{background-color:rgb(123,243,183);}");
            changed_ = !changed_;
        }
        else
        {
            this->setStyleSheet("#widget{background-color:rgb(248,246,242);}");
            changed_ = !changed_;
        }
    }
    QWidget::mousePressEvent(e);
}

void ChildActivityItem::set_hidden_button(bool flag)
{
    ui->pushButton_update->setHidden(flag);
}

void ChildActivityItem::set_hidden_label(bool flag)
{
    ui->label_created_time->setHidden(flag);
}

void ChildActivityItem::set_hidden_no_use(bool flag)
{
    ui->pushButton_update->setHidden(flag);
    ui->label_created_time->setHidden(flag);
    ui->horizontalSpacer_5->changeSize(1,1);
}

void ChildActivityItem::setButtonHidden(bool flag)
{
    ui->pushButton_update->setHidden(flag);
}



void ChildActivityItem::on_pushButton_update_clicked()
{
    if(!update_)
    {
        update_.reset(new CreateChildActivity("修改子活动信息"));
        // 接收修改活动信息界面发送的提交消息
        connect(update_.get(),&CreateChildActivity::created,this,[=](QString name,QString abstract,int max_join,double score){
            ui->label_activity_name->setText(name);
            ui->label_activity_abstract->setText(abstract);
        });
    }
    update_->clear();
    update_->show();
}
