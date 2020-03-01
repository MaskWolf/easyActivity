/********************************************************************************
** Form generated from reading UI file 'manageritem.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_MANAGERITEM_H
#define UI_MANAGERITEM_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_ManagerItem
{
public:
    QGridLayout *gridLayout_2;
    QWidget *widgetInner;
    QGridLayout *gridLayout;
    QLabel *label_id;
    QLabel *label_phone;
    QLabel *label_name;

    void setupUi(QWidget *ManagerItem)
    {
        if (ManagerItem->objectName().isEmpty())
            ManagerItem->setObjectName(QStringLiteral("ManagerItem"));
        ManagerItem->resize(461, 75);
        gridLayout_2 = new QGridLayout(ManagerItem);
        gridLayout_2->setObjectName(QStringLiteral("gridLayout_2"));
        widgetInner = new QWidget(ManagerItem);
        widgetInner->setObjectName(QStringLiteral("widgetInner"));
        gridLayout = new QGridLayout(widgetInner);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        gridLayout->setHorizontalSpacing(16);
        gridLayout->setContentsMargins(0, 0, 0, 0);
        label_id = new QLabel(widgetInner);
        label_id->setObjectName(QStringLiteral("label_id"));

        gridLayout->addWidget(label_id, 0, 1, 1, 1);

        label_phone = new QLabel(widgetInner);
        label_phone->setObjectName(QStringLiteral("label_phone"));

        gridLayout->addWidget(label_phone, 1, 1, 1, 1);

        label_name = new QLabel(widgetInner);
        label_name->setObjectName(QStringLiteral("label_name"));
        QSizePolicy sizePolicy(QSizePolicy::Fixed, QSizePolicy::Preferred);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(0);
        sizePolicy.setHeightForWidth(label_name->sizePolicy().hasHeightForWidth());
        label_name->setSizePolicy(sizePolicy);
        QFont font;
        font.setFamily(QString::fromUtf8("\346\245\267\344\275\223"));
        font.setPointSize(16);
        label_name->setFont(font);

        gridLayout->addWidget(label_name, 0, 0, 2, 1);


        gridLayout_2->addWidget(widgetInner, 0, 0, 1, 1);


        retranslateUi(ManagerItem);

        QMetaObject::connectSlotsByName(ManagerItem);
    } // setupUi

    void retranslateUi(QWidget *ManagerItem)
    {
        ManagerItem->setWindowTitle(QApplication::translate("ManagerItem", "Form", 0));
        label_id->setText(QApplication::translate("ManagerItem", "id", 0));
        label_phone->setText(QApplication::translate("ManagerItem", "tel", 0));
        label_name->setText(QApplication::translate("ManagerItem", "\347\224\250\346\210\267\345\220\215", 0));
    } // retranslateUi

};

namespace Ui {
    class ManagerItem: public Ui_ManagerItem {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_MANAGERITEM_H
