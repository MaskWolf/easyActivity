#include "manageritem.h"
#include "ui_manageritem.h"

ManagerItem::ManagerItem(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::ManagerItem)
{
    ui->setupUi(this);
}

ManagerItem::ManagerItem(QWidget *parent, QString name, QString id, QString phone):
    QWidget(parent),
    ui(new Ui::ManagerItem)
{
    ui->setupUi(this);
    ui->label_name->setText(name);
    ui->label_phone->setText("tel: "+phone);
    ui->label_id->setText("id: "+id);
    Cout<<id;
}

ManagerItem::~ManagerItem()
{
    delete ui;
}

QString ManagerItem::getManagerName() const
{
    return ui->label_name->text();
}

QString ManagerItem::getManagerId() const
{
    return ui->label_phone->text();
}

QString ManagerItem::getManagerPhone() const
{
    return ui->label_phone->text();
}
