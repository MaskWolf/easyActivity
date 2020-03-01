#include "showmessage.h"
#include "ui_showmessage.h"

ShowMessage::ShowMessage(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::ShowMessage)
{
    ui->setupUi(this);
}

ShowMessage::ShowMessage(QWidget *parent, QString show_message):
    QDialog(parent),message_(show_message),time_(0),
    ui(new Ui::ShowMessage)
{
    ui->setupUi(this);
    ui->label->setText(show_message);

    this->setWindowFlags(Qt::FramelessWindowHint|Qt::WindowStaysOnTopHint);   //设置窗口无边框
    this->setAttribute(Qt::WA_TranslucentBackground);  //设置主窗口背景透明

    ui->widget->setStyleSheet("background-color:rgba(0,0,0,0.5);"
                              "color:white;");
    timer_ = new QTimer();
    connect(timer_,&QTimer::timeout,this,[=](){
        time_ += 30;
        auto rate = (3000-time_*1.0)/6000;
        ui->widget->setStyleSheet(QString("background-color:rgba(0,0,0,%1);"
                                          "color:white;"
                                          "border-radius:5px;").arg(rate));
        if(time_ == 3000)
        {
            time_ = 0;
            this->close();
            timer_->stop();
        }
    });

}

ShowMessage::~ShowMessage()
{
    delete ui;
    delete timer_;
}

QString ShowMessage::message() const
{
    return message_;
}

void ShowMessage::setMessage(const QString &message)
{
    message_ = message;
}

void ShowMessage::showDialog(QString message)
{
    this->show();
    timer_->start(30);
    ui->label->setText(message);
}


