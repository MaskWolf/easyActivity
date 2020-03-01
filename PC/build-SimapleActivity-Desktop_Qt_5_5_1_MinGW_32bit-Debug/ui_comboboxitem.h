/********************************************************************************
** Form generated from reading UI file 'comboboxitem.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_COMBOBOXITEM_H
#define UI_COMBOBOXITEM_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QToolButton>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_ComboBoxItem
{
public:
    QGridLayout *gridLayout;
    QWidget *widgetInner;
    QGridLayout *gridLayout_2;
    QLabel *label;
    QToolButton *toolButton;

    void setupUi(QWidget *ComboBoxItem)
    {
        if (ComboBoxItem->objectName().isEmpty())
            ComboBoxItem->setObjectName(QStringLiteral("ComboBoxItem"));
        ComboBoxItem->resize(304, 53);
        ComboBoxItem->setMinimumSize(QSize(0, 0));
        gridLayout = new QGridLayout(ComboBoxItem);
        gridLayout->setSpacing(0);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        gridLayout->setContentsMargins(0, 0, 0, 0);
        widgetInner = new QWidget(ComboBoxItem);
        widgetInner->setObjectName(QStringLiteral("widgetInner"));
        widgetInner->setStyleSheet(QStringLiteral("background-color:rgba(255,255,255,0.2)"));
        gridLayout_2 = new QGridLayout(widgetInner);
        gridLayout_2->setSpacing(0);
        gridLayout_2->setObjectName(QStringLiteral("gridLayout_2"));
        gridLayout_2->setContentsMargins(10, 0, 5, 0);
        label = new QLabel(widgetInner);
        label->setObjectName(QStringLiteral("label"));

        gridLayout_2->addWidget(label, 0, 0, 1, 1);

        toolButton = new QToolButton(widgetInner);
        toolButton->setObjectName(QStringLiteral("toolButton"));
        toolButton->setMinimumSize(QSize(30, 30));
        toolButton->setMaximumSize(QSize(30, 30));
        toolButton->setCursor(QCursor(Qt::PointingHandCursor));
        toolButton->setAutoRaise(true);

        gridLayout_2->addWidget(toolButton, 0, 1, 1, 1);


        gridLayout->addWidget(widgetInner, 0, 0, 1, 1);


        retranslateUi(ComboBoxItem);

        QMetaObject::connectSlotsByName(ComboBoxItem);
    } // setupUi

    void retranslateUi(QWidget *ComboBoxItem)
    {
        ComboBoxItem->setWindowTitle(QApplication::translate("ComboBoxItem", "Form", 0));
        label->setText(QApplication::translate("ComboBoxItem", "TextLabel", 0));
        toolButton->setText(QApplication::translate("ComboBoxItem", "\342\225\263", 0));
    } // retranslateUi

};

namespace Ui {
    class ComboBoxItem: public Ui_ComboBoxItem {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_COMBOBOXITEM_H
