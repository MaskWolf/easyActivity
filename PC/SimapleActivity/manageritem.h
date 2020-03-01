/**
  * @file
  * @brief 管理员项，表示一个管理员的基础信息
  *
  *     基础信息包括用户名、id、phone
  * @version 1.0
  * @author zsj
  * @date 2019年6月9日10:41:50
  */
#ifndef MANAGERITEM_H
#define MANAGERITEM_H

#include <QWidget>

#include "readqstylesheet.h"

namespace Ui {
class ManagerItem;
}

class ManagerItem : public QWidget
{
    Q_OBJECT

public:
    explicit ManagerItem(QWidget *parent = 0);
    ManagerItem(QWidget *parent,QString name,QString id,QString phone);
    ~ManagerItem();

    QString getManagerName()const;
    QString getManagerId()const;
    QString getManagerPhone()const;

private:
    Ui::ManagerItem *ui;
};

#endif // MANAGERITEM_H
