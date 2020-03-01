/**
  * @file
  * @brief 自定义左侧选项按钮
  *
  * @date 2019年5月10日11:10:00
  * @version 1.0
  * @author zsj
*/

#ifndef WIDGETITEM_H
#define WIDGETITEM_H

#include <QWidget>
#include <QIcon>
#include <QLabel>
#include <QString>
#include <QPixmap>
#include <QColor>

class WidgetItem : public QWidget
{
    Q_OBJECT
public:
    explicit WidgetItem(QWidget *parent = 0);
    WidgetItem(QWidget *parent,QString  image,QString  label);

    /// @brief 设置选项是否为选中时不同的表现  主要表现为该选项前面的标识
    void set_activity(bool flag,QString qss = "rgb(255,0,0);");

    bool operator == (const WidgetItem & obj);

    QString get_name();

private:
    QLabel isActivity_;  ///< 选中标识
    QLabel image_;        ///< 图标
    QLabel label_;       ///< 文字

signals:

public slots:
};

#endif // WIDGETITEM_H
