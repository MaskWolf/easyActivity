/**
  * @file
  * @brief 搜索框
  * @version 1.0
  * @date 2019年6月12日08:45:34
  * @author zsj
  */
#ifndef LINEEDITSEACRH_H
#define LINEEDITSEACRH_H

#include <QWidget>
#include <QLineEdit>
#include <QKeyEvent>
#include <memory>
#include <QString>



#include "readqstylesheet.h"

using namespace std;

class LineEditSeacrh : public QLineEdit
{
    Q_OBJECT
public:
    explicit LineEditSeacrh(QWidget *parent = 0);

signals:
    void searchBegin(const QString & data);
public slots:
protected:

    /// @brief 键盘响应事件
    void keyPressEvent(QKeyEvent *);
private:
    QString data_;
};

#endif // LINEEDITSEACRH_H
