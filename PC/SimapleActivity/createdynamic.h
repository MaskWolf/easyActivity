#ifndef CREATEDYNAMIC_H
#define CREATEDYNAMIC_H

#include <QWidget>
#include <QFileDialog>
#include <QString>
#include <QStringList>
#include <QListWidget>
#include <QListWidgetItem>
#include <QVector>
#include <QSet>
#include <QList>
#include <QPoint>
#include <QMouseEvent>
#include <QGraphicsDropShadowEffect>

#include "readqstylesheet.h"

namespace Ui {
class CreateDynamic;
}

class CreateDynamic : public QWidget
{
    Q_OBJECT

public:
    explicit CreateDynamic(QWidget *parent = 0);
    ~CreateDynamic();

signals:
    void createDynamic(QString content,QStringList & list);
private slots:
    void on_toolButton_add_image_clicked();

    void on_pushButton_publish_clicked();

    /// @brief 减少图片的项
    void reduce_item(const QModelIndex & index);

    void on_toolButton_close_clicked();

    void on_toolButton_min_clicked();

private:
    Ui::CreateDynamic *ui;

    QStringList list_;   ///< 保存用户选择的图片

    QSet<QString> set_images_;

    QList<QString> str_list_;

    QPoint z_;

    /// @brief 初始化窗口资源、设置窗口样式
    void initWinResource();

protected:
    /// @brief 重写mouseMoveEvent函数
    ///
    ///     用户点击有可能点击LoginWidget页面之上的小部件然后拖动
    ///会出现抖动，此函数解决此问题
    void mouseMoveEvent(QMouseEvent *);

    /// @brief 重写mousePressEvent函数
    ///
    ///  鼠标按下事件，按下就获取当前鼠标坐标并计算出当前坐标和窗口左上角的差值
    void mousePressEvent(QMouseEvent *);

    /// @brief 重写mouseReleaseEvent函数
    void mouseReleaseEvent(QMouseEvent *);
};

#endif // CREATEDYNAMIC_H
