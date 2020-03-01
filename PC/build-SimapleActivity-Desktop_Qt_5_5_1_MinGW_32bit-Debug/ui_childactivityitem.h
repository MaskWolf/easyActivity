/********************************************************************************
** Form generated from reading UI file 'childactivityitem.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_CHILDACTIVITYITEM_H
#define UI_CHILDACTIVITYITEM_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_ChildActivityItem
{
public:
    QGridLayout *gridLayout_2;
    QWidget *widget;
    QGridLayout *gridLayout;
    QLabel *label_activity_name;
    QSpacerItem *horizontalSpacer;
    QPushButton *pushButton_update;
    QSpacerItem *horizontalSpacer_2;
    QLabel *label_activity_abstract;
    QSpacerItem *horizontalSpacer_3;
    QSpacerItem *verticalSpacer;
    QSpacerItem *verticalSpacer_3;
    QSpacerItem *verticalSpacer_2;
    QLabel *label_created_time;
    QSpacerItem *horizontalSpacer_5;

    void setupUi(QWidget *ChildActivityItem)
    {
        if (ChildActivityItem->objectName().isEmpty())
            ChildActivityItem->setObjectName(QStringLiteral("ChildActivityItem"));
        ChildActivityItem->resize(713, 187);
        gridLayout_2 = new QGridLayout(ChildActivityItem);
        gridLayout_2->setSpacing(0);
        gridLayout_2->setObjectName(QStringLiteral("gridLayout_2"));
        gridLayout_2->setContentsMargins(0, 0, 0, 0);
        widget = new QWidget(ChildActivityItem);
        widget->setObjectName(QStringLiteral("widget"));
        gridLayout = new QGridLayout(widget);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        label_activity_name = new QLabel(widget);
        label_activity_name->setObjectName(QStringLiteral("label_activity_name"));
        QSizePolicy sizePolicy(QSizePolicy::Fixed, QSizePolicy::Preferred);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(0);
        sizePolicy.setHeightForWidth(label_activity_name->sizePolicy().hasHeightForWidth());
        label_activity_name->setSizePolicy(sizePolicy);
        label_activity_name->setMinimumSize(QSize(240, 0));
        label_activity_name->setMaximumSize(QSize(240, 16777215));
        QFont font;
        font.setPointSize(16);
        font.setBold(true);
        font.setWeight(75);
        label_activity_name->setFont(font);

        gridLayout->addWidget(label_activity_name, 0, 0, 1, 2);

        horizontalSpacer = new QSpacerItem(200, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        gridLayout->addItem(horizontalSpacer, 0, 2, 1, 1);

        pushButton_update = new QPushButton(widget);
        pushButton_update->setObjectName(QStringLiteral("pushButton_update"));
        pushButton_update->setMinimumSize(QSize(110, 25));
        pushButton_update->setMaximumSize(QSize(110, 25));
        pushButton_update->setCursor(QCursor(Qt::PointingHandCursor));

        gridLayout->addWidget(pushButton_update, 0, 3, 1, 1);

        horizontalSpacer_2 = new QSpacerItem(20, 20, QSizePolicy::Fixed, QSizePolicy::Minimum);

        gridLayout->addItem(horizontalSpacer_2, 0, 4, 1, 1);

        label_activity_abstract = new QLabel(widget);
        label_activity_abstract->setObjectName(QStringLiteral("label_activity_abstract"));

        gridLayout->addWidget(label_activity_abstract, 1, 0, 1, 4);

        horizontalSpacer_3 = new QSpacerItem(20, 20, QSizePolicy::Fixed, QSizePolicy::Minimum);

        gridLayout->addItem(horizontalSpacer_3, 1, 4, 1, 1);

        verticalSpacer = new QSpacerItem(20, 70, QSizePolicy::Minimum, QSizePolicy::Expanding);

        gridLayout->addItem(verticalSpacer, 2, 0, 1, 1);

        verticalSpacer_3 = new QSpacerItem(20, 70, QSizePolicy::Minimum, QSizePolicy::Expanding);

        gridLayout->addItem(verticalSpacer_3, 2, 2, 1, 1);

        verticalSpacer_2 = new QSpacerItem(20, 70, QSizePolicy::Minimum, QSizePolicy::Expanding);

        gridLayout->addItem(verticalSpacer_2, 2, 3, 1, 1);

        label_created_time = new QLabel(widget);
        label_created_time->setObjectName(QStringLiteral("label_created_time"));
        label_created_time->setMinimumSize(QSize(110, 0));
        label_created_time->setMaximumSize(QSize(110, 16777215));
        label_created_time->setAlignment(Qt::AlignCenter);

        gridLayout->addWidget(label_created_time, 3, 3, 1, 2);

        horizontalSpacer_5 = new QSpacerItem(511, 24, QSizePolicy::Expanding, QSizePolicy::Minimum);

        gridLayout->addItem(horizontalSpacer_5, 3, 0, 1, 3);


        gridLayout_2->addWidget(widget, 0, 0, 1, 1);


        retranslateUi(ChildActivityItem);

        QMetaObject::connectSlotsByName(ChildActivityItem);
    } // setupUi

    void retranslateUi(QWidget *ChildActivityItem)
    {
        ChildActivityItem->setWindowTitle(QApplication::translate("ChildActivityItem", "Form", 0));
        label_activity_name->setText(QApplication::translate("ChildActivityItem", "\346\264\273\345\212\250\345\220\215\347\247\260", 0));
        pushButton_update->setText(QApplication::translate("ChildActivityItem", "\344\277\256\346\224\271\346\255\244\346\264\273\345\212\250\344\277\241\346\201\257", 0));
        label_activity_abstract->setText(QApplication::translate("ChildActivityItem", "\346\264\273\345\212\250\346\221\230\350\246\201", 0));
        label_created_time->setText(QApplication::translate("ChildActivityItem", "\346\227\266\351\227\264", 0));
    } // retranslateUi

};

namespace Ui {
    class ChildActivityItem: public Ui_ChildActivityItem {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_CHILDACTIVITYITEM_H
