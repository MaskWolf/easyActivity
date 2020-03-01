#ifndef USERDEFINETYPESHOW_H
#define USERDEFINETYPESHOW_H

#include <QWidget>
#include <QString>

namespace Ui {
class UserDefineTypeShow;
}

class UserDefineTypeShow : public QWidget
{
    Q_OBJECT

public:
    explicit UserDefineTypeShow(QWidget *parent = 0);
    UserDefineTypeShow(QWidget *parent,QString type,QString type_des);

    QString get_type()const;
    QString get_type_description()const;

    ~UserDefineTypeShow();

private:
    Ui::UserDefineTypeShow *ui;
};

#endif // USERDEFINETYPESHOW_H
