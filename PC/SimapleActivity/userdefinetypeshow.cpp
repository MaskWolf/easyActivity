#include "userdefinetypeshow.h"
#include "ui_userdefinetypeshow.h"

UserDefineTypeShow::UserDefineTypeShow(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::UserDefineTypeShow)
{
    ui->setupUi(this);
}

UserDefineTypeShow::UserDefineTypeShow(QWidget *parent, QString type, QString type_des):
    QWidget(parent),
    ui(new Ui::UserDefineTypeShow)
{
    ui->setupUi(this);
    ui->label->setText(type);
    ui->label_2->setText(type_des);
}

QString UserDefineTypeShow::get_type() const
{
    return ui->label->text();
}

QString UserDefineTypeShow::get_type_description() const
{
    return ui->label->text();
}

UserDefineTypeShow::~UserDefineTypeShow()
{
    delete ui;
}
