#include "signupitem.h"
#include "ui_signupitem.h"

SignUpItem::SignUpItem(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::SignUpItem)
{
    ui->setupUi(this);
}

SignUpItem::SignUpItem(QWidget *parent, QString name,int f_id,QString des):
    QWidget(parent),f_id_(f_id),
    ui(new Ui::SignUpItem)
{
    ui->setupUi(this);
    ui->label->setText(name);
    this->setStyleSheet("#widget{background-color:rgb(248,246,242);"
                        "border-radius:5px;"
                        "}"
                        "#widget:hover{background-color:rgb(228,226,222);}"
                        "#widget:active{background-color:rgb(248,246,242);}"
                        "QLineEdit{padding:5px 5px;"
                        "border:none;"
                        "border-left:1px solid rgb(228,226,222);"
                        "background:transparent;"
                        "}"
                        "QLineEdit:focus{border:1px solid rgb(123,243,183);"
                        "border-radius:5px;}"
                        ""
                        "");
    ui->lineEdit->setPlaceholderText(des);
}

QString SignUpItem::get_label_name()
{
    return ui->label->text();
}

QString SignUpItem::get_content()
{
    return ui->lineEdit->text();
}

SignUpItem::~SignUpItem()
{
    delete ui;
}

int SignUpItem::getF_id() const
{
    return f_id_;
}
