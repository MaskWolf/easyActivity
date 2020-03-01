/**
  * @file
  * @brief 组合框的下拉列表项的自定义
  *
  *     应用于登录界面的选择账号组合框和选择与用户相关的活动的组合框
  * @date 2019年6月6日19:33:28
  * @version 1.0
  * @author zsj
  */
#ifndef COMBOBOXITEM_H
#define COMBOBOXITEM_H

#include <QWidget>
#include <QMouseEvent>

namespace Ui {
class ComboBoxItem;
}

class ComboBoxItem : public QWidget
{
    Q_OBJECT

public:
    explicit ComboBoxItem(QWidget *parent = 0);
    ~ComboBoxItem();

    /// @brief 设置下拉框的文字
    void setComboBoxItemLabelText(QString text);

    QString getComboBoxItemLabelText();
protected:
    void mousePressEvent(QMouseEvent *);
    void mouseReleaseEvent(QMouseEvent *);

private:
    Ui::ComboBoxItem *ui;

signals:
    void clickItem(QString id);
};

#endif // COMBOBOXITEM_H
