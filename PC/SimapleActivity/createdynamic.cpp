#include "createdynamic.h"
#include "ui_createdynamic.h"

CreateDynamic::CreateDynamic(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::CreateDynamic)
{
    ui->setupUi(this);
    connect(ui->listWidget_show_image,&QListWidget::doubleClicked,this,&CreateDynamic::reduce_item);
    initWinResource();
}

CreateDynamic::~CreateDynamic()
{
    delete ui;
}

void CreateDynamic::on_toolButton_add_image_clicked()
{

    int list_index = list_.size();
//    Cout<<"喀什"<<list_index;
    QStringList ls = QFileDialog::getOpenFileNames(this,QString("选择图片"),tr("./"),tr("图片(*.jpg *.png);;"));
    for(int i = 0;i<ls.size();i++)
    {
        if(list_.size()<9)
        {
            list_.append(ls[i]);
        }
    }

    for(int i = list_index;i<list_.size();i++)
    {

        Cout<<list_[i];
        QListWidgetItem * item = new QListWidgetItem(ui->listWidget_show_image);
        QLabel * l_item = new QLabel(ui->listWidget_show_image);
        l_item->setFixedSize(80,80);
        QPixmap pix(list_[i]);
        QPixmap temp = pix.scaled(80,80);
        l_item->setPixmap(temp);
        ui->listWidget_show_image->addItem(item);
        item->setSizeHint(QSize(80,80));
        ui->listWidget_show_image->setItemWidget(item,l_item);

    }
//    Cout<<"结束";
}

void CreateDynamic::on_pushButton_publish_clicked()
{
    QString content = ui->textEdit_content->toPlainText();
    emit createDynamic(content,list_);
    this->close();
}

void CreateDynamic::reduce_item(const QModelIndex &index)
{
    int pos = index.row();
    list_.removeAt(pos);
    delete ui->listWidget_show_image->takeItem(pos);
    Cout<<"list.size"<<list_.size();
    Cout<<ui->listWidget_show_image->count();
}

void CreateDynamic::initWinResource()
{
    this->setWindowFlags(Qt::FramelessWindowHint);   //设置窗口无边框
    this->setAttribute(Qt::WA_TranslucentBackground);  //设置主窗口背景透明
    this->setStyleSheet(ReadQStyleSheet::readQss(":/qss/qss_createdynamic.qss"));

    QGraphicsDropShadowEffect * shadow = new QGraphicsDropShadowEffect(this);
    shadow->setOffset(0,0);   //阴影偏移量
    shadow->setColor(Qt::black);  //阴影颜色
    shadow->setBlurRadius(10);     //阴影的模糊半径
    ui->widgetInner->setGraphicsEffect(shadow);
    z_ = QPoint(0,0);
}

void CreateDynamic::mouseMoveEvent(QMouseEvent * e)
{
    QPoint afterMovePos = e->globalPos();
    if(z_.x()!=0&&z_.y()!=0)
    {
        QPoint moveDis = afterMovePos-z_;
        move(moveDis);
    }

}

void CreateDynamic::mousePressEvent(QMouseEvent * e)
{
    QPoint currGlobalPos = e->globalPos();              //当前鼠标的全局位置
    QPoint currLocPos = this->geometry().topLeft();    //当前鼠标点击窗口的左上角坐标
    z_ = currGlobalPos-currLocPos;
}

void CreateDynamic::mouseReleaseEvent(QMouseEvent *)
{
    z_ = QPoint(0,0);
}

void CreateDynamic::on_toolButton_close_clicked()
{
    this->close();
}

void CreateDynamic::on_toolButton_min_clicked()
{
    this->showMinimized();
}
