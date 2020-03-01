/********************************************************************************
** Form generated from reading UI file 'createdynamic.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_CREATEDYNAMIC_H
#define UI_CREATEDYNAMIC_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QListWidget>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QTextEdit>
#include <QtWidgets/QToolButton>
#include <QtWidgets/QWidget>
#include <mywidgetregister.h>

QT_BEGIN_NAMESPACE

class Ui_CreateDynamic
{
public:
    QGridLayout *gridLayout;
    MyWidgetRegister *widgetInner;
    QGridLayout *gridLayout_2;
    QWidget *widget_write_dynamic_nav;
    QHBoxLayout *horizontalLayout_3;
    QLabel *label;
    QSpacerItem *horizontalSpacer;
    QToolButton *toolButton_min;
    QToolButton *toolButton_close;
    QTextEdit *textEdit_content;
    QSpacerItem *horizontalSpacer_5;
    QSpacerItem *horizontalSpacer_6;
    QSpacerItem *horizontalSpacer_4;
    QSpacerItem *horizontalSpacer_9;
    QWidget *widget_2;
    QHBoxLayout *horizontalLayout_2;
    QToolButton *toolButton_add_image;
    QSpacerItem *horizontalSpacer_2;
    QSpacerItem *horizontalSpacer_10;
    QWidget *widget_4;
    QGridLayout *gridLayout_3;
    QListWidget *listWidget_show_image;
    QSpacerItem *horizontalSpacer_8;
    QSpacerItem *horizontalSpacer_7;
    QWidget *widget_3;
    QHBoxLayout *horizontalLayout;
    QSpacerItem *horizontalSpacer_3;
    QPushButton *pushButton_publish;

    void setupUi(QWidget *CreateDynamic)
    {
        if (CreateDynamic->objectName().isEmpty())
            CreateDynamic->setObjectName(QStringLiteral("CreateDynamic"));
        CreateDynamic->resize(856, 441);
        gridLayout = new QGridLayout(CreateDynamic);
        gridLayout->setSpacing(0);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        gridLayout->setContentsMargins(5, 5, 5, 5);
        widgetInner = new MyWidgetRegister(CreateDynamic);
        widgetInner->setObjectName(QStringLiteral("widgetInner"));
        gridLayout_2 = new QGridLayout(widgetInner);
        gridLayout_2->setObjectName(QStringLiteral("gridLayout_2"));
        widget_write_dynamic_nav = new QWidget(widgetInner);
        widget_write_dynamic_nav->setObjectName(QStringLiteral("widget_write_dynamic_nav"));
        widget_write_dynamic_nav->setMaximumSize(QSize(16777215, 40));
        horizontalLayout_3 = new QHBoxLayout(widget_write_dynamic_nav);
        horizontalLayout_3->setSpacing(0);
        horizontalLayout_3->setObjectName(QStringLiteral("horizontalLayout_3"));
        horizontalLayout_3->setContentsMargins(0, 0, 0, 0);
        label = new QLabel(widget_write_dynamic_nav);
        label->setObjectName(QStringLiteral("label"));
        label->setMinimumSize(QSize(0, 30));
        label->setMaximumSize(QSize(16777215, 30));
        QFont font;
        font.setFamily(QString::fromUtf8("\346\245\267\344\275\223"));
        font.setPointSize(16);
        label->setFont(font);

        horizontalLayout_3->addWidget(label);

        horizontalSpacer = new QSpacerItem(791, 27, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout_3->addItem(horizontalSpacer);

        toolButton_min = new QToolButton(widget_write_dynamic_nav);
        toolButton_min->setObjectName(QStringLiteral("toolButton_min"));
        toolButton_min->setMinimumSize(QSize(30, 30));
        toolButton_min->setMaximumSize(QSize(30, 30));
        toolButton_min->setAutoRaise(true);

        horizontalLayout_3->addWidget(toolButton_min);

        toolButton_close = new QToolButton(widget_write_dynamic_nav);
        toolButton_close->setObjectName(QStringLiteral("toolButton_close"));
        toolButton_close->setMinimumSize(QSize(30, 30));
        toolButton_close->setMaximumSize(QSize(30, 30));
        toolButton_close->setAutoRaise(true);

        horizontalLayout_3->addWidget(toolButton_close);


        gridLayout_2->addWidget(widget_write_dynamic_nav, 0, 0, 1, 3);

        textEdit_content = new QTextEdit(widgetInner);
        textEdit_content->setObjectName(QStringLiteral("textEdit_content"));
        textEdit_content->setMinimumSize(QSize(0, 200));
        textEdit_content->setMaximumSize(QSize(16777215, 233));

        gridLayout_2->addWidget(textEdit_content, 1, 1, 2, 1);

        horizontalSpacer_5 = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        gridLayout_2->addItem(horizontalSpacer_5, 1, 3, 1, 1);

        horizontalSpacer_6 = new QSpacerItem(10, 20, QSizePolicy::Fixed, QSizePolicy::Minimum);

        gridLayout_2->addItem(horizontalSpacer_6, 2, 0, 1, 1);

        horizontalSpacer_4 = new QSpacerItem(10, 20, QSizePolicy::Fixed, QSizePolicy::Minimum);

        gridLayout_2->addItem(horizontalSpacer_4, 2, 2, 1, 1);

        horizontalSpacer_9 = new QSpacerItem(10, 20, QSizePolicy::Fixed, QSizePolicy::Minimum);

        gridLayout_2->addItem(horizontalSpacer_9, 3, 0, 1, 1);

        widget_2 = new QWidget(widgetInner);
        widget_2->setObjectName(QStringLiteral("widget_2"));
        widget_2->setMinimumSize(QSize(0, 0));
        widget_2->setMaximumSize(QSize(16777215, 40));
        horizontalLayout_2 = new QHBoxLayout(widget_2);
        horizontalLayout_2->setObjectName(QStringLiteral("horizontalLayout_2"));
        toolButton_add_image = new QToolButton(widget_2);
        toolButton_add_image->setObjectName(QStringLiteral("toolButton_add_image"));
        toolButton_add_image->setMinimumSize(QSize(30, 30));
        toolButton_add_image->setMaximumSize(QSize(30, 30));
        toolButton_add_image->setAutoRaise(true);

        horizontalLayout_2->addWidget(toolButton_add_image);

        horizontalSpacer_2 = new QSpacerItem(548, 27, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout_2->addItem(horizontalSpacer_2);


        gridLayout_2->addWidget(widget_2, 3, 1, 1, 1);

        horizontalSpacer_10 = new QSpacerItem(10, 20, QSizePolicy::Fixed, QSizePolicy::Minimum);

        gridLayout_2->addItem(horizontalSpacer_10, 3, 2, 2, 1);

        widget_4 = new QWidget(widgetInner);
        widget_4->setObjectName(QStringLiteral("widget_4"));
        widget_4->setMinimumSize(QSize(0, 90));
        widget_4->setMaximumSize(QSize(16777215, 80));
        gridLayout_3 = new QGridLayout(widget_4);
        gridLayout_3->setSpacing(0);
        gridLayout_3->setObjectName(QStringLiteral("gridLayout_3"));
        gridLayout_3->setContentsMargins(0, 0, 0, 0);
        listWidget_show_image = new QListWidget(widget_4);
        listWidget_show_image->setObjectName(QStringLiteral("listWidget_show_image"));
        listWidget_show_image->setFlow(QListView::LeftToRight);
        listWidget_show_image->setSpacing(2);

        gridLayout_3->addWidget(listWidget_show_image, 0, 0, 1, 1);


        gridLayout_2->addWidget(widget_4, 4, 1, 2, 1);

        horizontalSpacer_8 = new QSpacerItem(10, 20, QSizePolicy::Fixed, QSizePolicy::Minimum);

        gridLayout_2->addItem(horizontalSpacer_8, 5, 0, 1, 1);

        horizontalSpacer_7 = new QSpacerItem(10, 20, QSizePolicy::Fixed, QSizePolicy::Minimum);

        gridLayout_2->addItem(horizontalSpacer_7, 5, 2, 1, 1);

        widget_3 = new QWidget(widgetInner);
        widget_3->setObjectName(QStringLiteral("widget_3"));
        widget_3->setMaximumSize(QSize(16777215, 30));
        horizontalLayout = new QHBoxLayout(widget_3);
        horizontalLayout->setSpacing(0);
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        horizontalLayout->setContentsMargins(0, 0, 0, 0);
        horizontalSpacer_3 = new QSpacerItem(760, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout->addItem(horizontalSpacer_3);

        pushButton_publish = new QPushButton(widget_3);
        pushButton_publish->setObjectName(QStringLiteral("pushButton_publish"));
        pushButton_publish->setMinimumSize(QSize(100, 25));
        pushButton_publish->setMaximumSize(QSize(100, 16777215));
        pushButton_publish->setCursor(QCursor(Qt::PointingHandCursor));

        horizontalLayout->addWidget(pushButton_publish);


        gridLayout_2->addWidget(widget_3, 6, 0, 1, 3);


        gridLayout->addWidget(widgetInner, 0, 0, 1, 1);


        retranslateUi(CreateDynamic);

        QMetaObject::connectSlotsByName(CreateDynamic);
    } // setupUi

    void retranslateUi(QWidget *CreateDynamic)
    {
        CreateDynamic->setWindowTitle(QApplication::translate("CreateDynamic", "Form", 0));
        label->setText(QApplication::translate("CreateDynamic", "\345\206\231\345\212\250\346\200\201", 0));
        toolButton_min->setText(QApplication::translate("CreateDynamic", "--", 0));
        toolButton_close->setText(QApplication::translate("CreateDynamic", "\342\225\263", 0));
        textEdit_content->setPlaceholderText(QApplication::translate("CreateDynamic", "\345\206\231\347\202\271\344\273\200\344\271\210\345\220\247.......", 0));
        toolButton_add_image->setText(QApplication::translate("CreateDynamic", "...", 0));
        pushButton_publish->setText(QApplication::translate("CreateDynamic", "\345\217\221\350\241\250", 0));
    } // retranslateUi

};

namespace Ui {
    class CreateDynamic: public Ui_CreateDynamic {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_CREATEDYNAMIC_H
