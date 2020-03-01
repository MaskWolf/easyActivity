#ifndef SIGNUPITEM_H
#define SIGNUPITEM_H

#include <QWidget>
#include <QString>

namespace Ui {
class SignUpItem;
}

class SignUpItem : public QWidget
{
    Q_OBJECT

public:
    explicit SignUpItem(QWidget *parent = 0);
    SignUpItem(QWidget *parent,QString name,int f_id,QString des = "请输入点东西");


    QString get_label_name();
    QString get_content();
    ~SignUpItem();

    int getF_id() const;

private:
    Ui::SignUpItem *ui;

    int f_id_;          //此报名项的id

};

#endif // SIGNUPITEM_H
