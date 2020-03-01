/********************************************************************************
** Form generated from reading UI file 'mycreateactivity.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_MYCREATEACTIVITY_H
#define UI_MYCREATEACTIVITY_H

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
#include <mylistwidget_child.h>

QT_BEGIN_NAMESPACE

class Ui_MyCreateActivity
{
public:
    QGridLayout *gridLayout;
    QWidget *widget;
    QGridLayout *gridLayout_2;
    QLabel *label_name;
    QSpacerItem *horizontalSpacer;
    QPushButton *pushButton_update;
    QLabel *label_abstract;
    QLabel *label_4;
    MyListWidget_child *listWidget_child;
    QLabel *label_3;

    void setupUi(QWidget *MyCreateActivity)
    {
        if (MyCreateActivity->objectName().isEmpty())
            MyCreateActivity->setObjectName(QStringLiteral("MyCreateActivity"));
        MyCreateActivity->resize(1218, 333);
        gridLayout = new QGridLayout(MyCreateActivity);
        gridLayout->setSpacing(0);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        gridLayout->setContentsMargins(0, 0, 0, 0);
        widget = new QWidget(MyCreateActivity);
        widget->setObjectName(QStringLiteral("widget"));
        gridLayout_2 = new QGridLayout(widget);
        gridLayout_2->setObjectName(QStringLiteral("gridLayout_2"));
        label_name = new QLabel(widget);
        label_name->setObjectName(QStringLiteral("label_name"));
        QFont font;
        font.setFamily(QStringLiteral("Agency FB"));
        font.setPointSize(16);
        font.setBold(true);
        font.setWeight(75);
        label_name->setFont(font);

        gridLayout_2->addWidget(label_name, 0, 0, 1, 1);

        horizontalSpacer = new QSpacerItem(282, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        gridLayout_2->addItem(horizontalSpacer, 0, 1, 1, 1);

        pushButton_update = new QPushButton(widget);
        pushButton_update->setObjectName(QStringLiteral("pushButton_update"));
        pushButton_update->setCursor(QCursor(Qt::PointingHandCursor));
        pushButton_update->setStyleSheet(QStringLiteral(""));

        gridLayout_2->addWidget(pushButton_update, 0, 2, 1, 1);

        label_abstract = new QLabel(widget);
        label_abstract->setObjectName(QStringLiteral("label_abstract"));

        gridLayout_2->addWidget(label_abstract, 1, 0, 1, 3);

        label_4 = new QLabel(widget);
        label_4->setObjectName(QStringLiteral("label_4"));

        gridLayout_2->addWidget(label_4, 3, 0, 1, 3);

        listWidget_child = new MyListWidget_child(widget);
        listWidget_child->setObjectName(QStringLiteral("listWidget_child"));
        listWidget_child->setSpacing(10);

        gridLayout_2->addWidget(listWidget_child, 4, 0, 1, 3);

        label_3 = new QLabel(widget);
        label_3->setObjectName(QStringLiteral("label_3"));

        gridLayout_2->addWidget(label_3, 2, 0, 1, 3);


        gridLayout->addWidget(widget, 0, 0, 1, 1);


        retranslateUi(MyCreateActivity);

        QMetaObject::connectSlotsByName(MyCreateActivity);
    } // setupUi

    void retranslateUi(QWidget *MyCreateActivity)
    {
        MyCreateActivity->setWindowTitle(QApplication::translate("MyCreateActivity", "Form", 0));
        label_name->setText(QApplication::translate("MyCreateActivity", "\346\264\273\345\212\250\345\220\215\347\247\260", 0));
        pushButton_update->setText(QApplication::translate("MyCreateActivity", "\344\277\256\346\224\271\346\264\273\345\212\250", 0));
        label_abstract->setText(QApplication::translate("MyCreateActivity", "\346\264\273\345\212\250\346\221\230\350\246\201", 0));
        label_4->setText(QApplication::translate("MyCreateActivity", "\345\214\205\345\220\253\345\255\220\346\264\273\345\212\250", 0));
        label_3->setText(QApplication::translate("MyCreateActivity", "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------", 0));
    } // retranslateUi

};

namespace Ui {
    class MyCreateActivity: public Ui_MyCreateActivity {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_MYCREATEACTIVITY_H
