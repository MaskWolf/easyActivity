#include "comboboxitem.h"
#include "ui_comboboxitem.h"

ComboBoxItem::ComboBoxItem(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::ComboBoxItem)
{
    ui->setupUi(this);
}

ComboBoxItem::~ComboBoxItem()
{
    delete ui;
}

void ComboBoxItem::setComboBoxItemLabelText(QString text)
{
    ui->label->setText(text);
}

QString ComboBoxItem::getComboBoxItemLabelText()
{
    return ui->label->text();
}

void ComboBoxItem::mousePressEvent(QMouseEvent *e)
{
    emit clickItem(ui->label->text());

    return QWidget::mousePressEvent(e);
}

void ComboBoxItem::mouseReleaseEvent(QMouseEvent *e)
{
    emit clickItem(ui->label->text());

    return QWidget::mouseReleaseEvent(e);
}
