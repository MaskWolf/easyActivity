#include "getimage.h"

GetImage::GetImage(QWidget *parent) : QWidget(parent)
{
    nam_.reset(new QNetworkAccessManager());
    connect(nam_.get(),&QNetworkAccessManager::finished,this,&GetImage::dealGetHttpData);
    rt_.reset(new ReplyTimeout());     //获取图片5s   未获取到就不获取
    connect(rt_.get(),&ReplyTimeout::timeout,this,[=](){
        error = true;
        emit ok();
    });
}

QPixmap GetImage::get_image(QUrl urls)
{
    QEventLoop e;
    connect(this,&GetImage::ok,&e,&QEventLoop::quit);
    QNetworkReply * reply = nam_->get(QNetworkRequest(urls));
    rt_->checking(reply,1000);
    e.exec();
    QPixmap pix;
    if(!error)
    {
        pix.loadFromData(data_);
    }
    else
    {
        pix.load(":/Main/C:/Users/ASUS/Pictures/Image/123.jpg");
    }

    return pix;
}

bool GetImage::uploadImage(QUrl urls, int id, int flag, QString file_name)
{
    QEventLoop e;
    connect(this,&GetImage::ok,&e,&QEventLoop::quit);

    QHttpMultiPart * multi_part = new QHttpMultiPart(QHttpMultiPart::FormDataType);
    QHttpPart id_part;
    id_part.setHeader(QNetworkRequest::ContentTypeHeader, QVariant("text/plain"));
    id_part.setHeader(QNetworkRequest::ContentDispositionHeader, QVariant("form-data; name=\"id\""));

    id_part.setBody(QString::number(id).toUtf8());

    QHttpPart flag_part;
    flag_part.setHeader(QNetworkRequest::ContentTypeHeader, QVariant("text/plain"));
    flag_part.setHeader(QNetworkRequest::ContentDispositionHeader, QVariant("form-data; name=\"flag\""));
    flag_part.setBody(QString::number(flag).toUtf8());

    QHttpPart image_part;
    image_part.setHeader(QNetworkRequest::ContentTypeHeader, QVariant("image/jpeg"));
    image_part.setHeader(QNetworkRequest::ContentDispositionHeader, QVariant("form-data; name=\"image\""));
    QFile * file = new QFile(file_name);
    if(!file->open(QIODevice::ReadOnly))
    {
        Cout<<"打开文件失败";
        delete file;
        delete multi_part;
        return false;
    }
    image_part.setBodyDevice(file);
    file->setParent(multi_part);


    multi_part->append(id_part);
    multi_part->append(flag_part);
    multi_part->append(image_part);

    QNetworkReply * reply = nam_->post(QNetworkRequest(urls),multi_part);
    multi_part->setParent(reply);   // reply  必须要接受  然后删除
    e.exec();
    Cout<<"发送";
    return !error;
}

QPixmap GetImage::get_round_image(QPixmap & pixmap, int radius)
{
    if(pixmap.isNull())
    {
        return QPixmap();

    }

    QSize size(2*radius,2*radius);
    pixmap = pixmap.scaled(size);
    QBitmap mask(size);
    QPainter painter(&mask);
    painter.setRenderHint(QPainter::Antialiasing);
    painter.setRenderHint(QPainter::SmoothPixmapTransform);
    painter.fillRect(0,0,size.width(),size.height(),Qt::white);
    painter.setBrush(QColor(0,0,0));
    painter.drawRoundedRect(0,0,size.width(),size.height(),99,99);

    QPixmap image = pixmap.scaled(size);
    image.setMask(mask);
    return image;
}

QByteArray GetImage::toUtf8(const QPixmap & pix, const char *format)
{
    QByteArray bytes;
    QBuffer buffer(&bytes);
    buffer.open(QIODevice::WriteOnly);
    pix.save(&buffer, format); // writes pixmap into bytes in PNG format
    return buffer.data();
}

void GetImage::dealGetHttpData(QNetworkReply *reply)
{
    switch(CURRENT_TYPE)
    {
    case GET_IMAGE:
        dealGetImageReturnInfo(reply);
        break;
    case UPLOAD_IMAGE:
        dealUploadImageReturnInfo(reply);
        break;
    default:
        break;
    }
}

void GetImage::dealGetImageReturnInfo(QNetworkReply *reply)
{
    if(reply->error()==QNetworkReply::NoError)
    {
        data_ = reply->readAll();
        error = false;
    }
    else
    {
        data_.clear();
        error = true;
    }
    emit ok();
    reply->deleteLater();
}

void GetImage::dealUploadImageReturnInfo(QNetworkReply *reply)
{
    if(reply->error()==QNetworkReply::NoError)
    {
        QByteArray bytes = reply->readAll();
        QJsonParseError json_error;
        QJsonDocument json_document = QJsonDocument::fromJson(bytes,&json_error);
        if(json_error.error!=QJsonParseError::NoError)
        {
            Cout<<"数据解析错误";
            emit ok();
            return;
        }
        if(json_document.object().value("uploadSuccess").toBool())
        {
            error = false;
        }
        else
        {
            error = true;
        }
    }
    emit ok();
    reply->deleteLater();
}

