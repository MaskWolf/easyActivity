/**
  * @file
  * @brief 消息提示框，对话框形式弹出，3秒后给主窗口发送消息，请求关闭
  * @date 2019年6月3日21:01:37
  * @version 1.0
  * @author zsj
  */
#ifndef SHOWMESSAGE_H
#define SHOWMESSAGE_H

#include <QDialog>
#include <QString>
#include <QTimer>
#include <QThread>

#include "readqstylesheet.h"

namespace Ui {
class ShowMessage;
}

class ShowMessage : public QDialog
{
    Q_OBJECT

public:
    explicit ShowMessage(QWidget *parent = 0);
    ShowMessage(QWidget *parent,QString show_message);
    ~ShowMessage();

    QString message() const;
    void setMessage(const QString &message);

    void showDialog(QString message);

private:
    Ui::ShowMessage *ui;

    QString message_;
    QTimer * timer_;  ///< 定时器
    int time_;         ///< 等于3000毫秒时关闭窗口
signals:
    void closeDialog();
};

#endif // SHOWMESSAGE_H
