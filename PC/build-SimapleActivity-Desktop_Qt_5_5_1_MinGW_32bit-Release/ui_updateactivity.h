/********************************************************************************
** Form generated from reading UI file 'updateactivity.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_UPDATEACTIVITY_H
#define UI_UPDATEACTIVITY_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QDateEdit>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QListWidget>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QTextEdit>
#include <QtWidgets/QToolButton>
#include <QtWidgets/QWidget>
#include <mywidgetregister.h>

QT_BEGIN_NAMESPACE

class Ui_UpdateActivity
{
public:
    QGridLayout *gridLayout;
    MyWidgetRegister *widgetInner;
    QGridLayout *gridLayout_2;
    QLabel *label_10;
    QLabel *label_7;
    QLineEdit *lineEdit_address;
    QLabel *label_12;
    QLabel *label_9;
    QDateEdit *dateEdit_dead_time;
    QLabel *label_join_num;
    QLineEdit *lineEdit_name;
    QLabel *label_id;
    QLabel *label;
    QLabel *label_create_time;
    QLabel *label_3;
    QTextEdit *textEdit_abstract;
    QLabel *label_6;
    QLabel *label_8;
    QTextEdit *textEdit_description;
    QLabel *label_4;
    QWidget *widget_2;
    QHBoxLayout *horizontalLayout;
    QLabel *label_13;
    QSpacerItem *horizontalSpacer_2;
    QToolButton *toolButton_min;
    QToolButton *toolButton_close;
    QWidget *widget_3;
    QPushButton *pushButton_sure;
    QPushButton *pushButton_cancel;
    QPushButton *pushButton_update_image;
    QLabel *label_show_image_num;
    QPushButton *pushButton;
    QListWidget *listWidget_act_manager;

    void setupUi(QWidget *UpdateActivity)
    {
        if (UpdateActivity->objectName().isEmpty())
            UpdateActivity->setObjectName(QStringLiteral("UpdateActivity"));
        UpdateActivity->resize(556, 708);
        gridLayout = new QGridLayout(UpdateActivity);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        widgetInner = new MyWidgetRegister(UpdateActivity);
        widgetInner->setObjectName(QStringLiteral("widgetInner"));
        gridLayout_2 = new QGridLayout(widgetInner);
        gridLayout_2->setObjectName(QStringLiteral("gridLayout_2"));
        gridLayout_2->setVerticalSpacing(15);
        gridLayout_2->setContentsMargins(-1, 0, -1, -1);
        label_10 = new QLabel(widgetInner);
        label_10->setObjectName(QStringLiteral("label_10"));
        label_10->setMinimumSize(QSize(100, 20));
        label_10->setMaximumSize(QSize(100, 20));
        label_10->setAlignment(Qt::AlignCenter);

        gridLayout_2->addWidget(label_10, 8, 0, 1, 1);

        label_7 = new QLabel(widgetInner);
        label_7->setObjectName(QStringLiteral("label_7"));
        label_7->setMinimumSize(QSize(100, 20));
        label_7->setMaximumSize(QSize(100, 20));
        label_7->setAlignment(Qt::AlignCenter);

        gridLayout_2->addWidget(label_7, 5, 0, 1, 1);

        lineEdit_address = new QLineEdit(widgetInner);
        lineEdit_address->setObjectName(QStringLiteral("lineEdit_address"));

        gridLayout_2->addWidget(lineEdit_address, 7, 1, 1, 1);

        label_12 = new QLabel(widgetInner);
        label_12->setObjectName(QStringLiteral("label_12"));
        label_12->setMinimumSize(QSize(100, 20));
        label_12->setMaximumSize(QSize(100, 20));
        label_12->setAlignment(Qt::AlignCenter);

        gridLayout_2->addWidget(label_12, 9, 0, 1, 1);

        label_9 = new QLabel(widgetInner);
        label_9->setObjectName(QStringLiteral("label_9"));
        label_9->setMinimumSize(QSize(100, 20));
        label_9->setMaximumSize(QSize(100, 20));
        label_9->setAlignment(Qt::AlignCenter);

        gridLayout_2->addWidget(label_9, 7, 0, 1, 1);

        dateEdit_dead_time = new QDateEdit(widgetInner);
        dateEdit_dead_time->setObjectName(QStringLiteral("dateEdit_dead_time"));

        gridLayout_2->addWidget(dateEdit_dead_time, 4, 1, 1, 1);

        label_join_num = new QLabel(widgetInner);
        label_join_num->setObjectName(QStringLiteral("label_join_num"));

        gridLayout_2->addWidget(label_join_num, 8, 1, 1, 1);

        lineEdit_name = new QLineEdit(widgetInner);
        lineEdit_name->setObjectName(QStringLiteral("lineEdit_name"));

        gridLayout_2->addWidget(lineEdit_name, 2, 1, 1, 1);

        label_id = new QLabel(widgetInner);
        label_id->setObjectName(QStringLiteral("label_id"));

        gridLayout_2->addWidget(label_id, 1, 1, 1, 1);

        label = new QLabel(widgetInner);
        label->setObjectName(QStringLiteral("label"));
        label->setMinimumSize(QSize(100, 20));
        label->setMaximumSize(QSize(100, 20));
        label->setAlignment(Qt::AlignCenter);

        gridLayout_2->addWidget(label, 1, 0, 1, 1);

        label_create_time = new QLabel(widgetInner);
        label_create_time->setObjectName(QStringLiteral("label_create_time"));

        gridLayout_2->addWidget(label_create_time, 3, 1, 1, 1);

        label_3 = new QLabel(widgetInner);
        label_3->setObjectName(QStringLiteral("label_3"));
        label_3->setMinimumSize(QSize(100, 20));
        label_3->setMaximumSize(QSize(100, 20));
        label_3->setAlignment(Qt::AlignCenter);

        gridLayout_2->addWidget(label_3, 2, 0, 1, 1);

        textEdit_abstract = new QTextEdit(widgetInner);
        textEdit_abstract->setObjectName(QStringLiteral("textEdit_abstract"));
        textEdit_abstract->setMaximumSize(QSize(16777215, 50));

        gridLayout_2->addWidget(textEdit_abstract, 5, 1, 1, 1);

        label_6 = new QLabel(widgetInner);
        label_6->setObjectName(QStringLiteral("label_6"));
        label_6->setMinimumSize(QSize(100, 20));
        label_6->setMaximumSize(QSize(100, 20));
        label_6->setAlignment(Qt::AlignCenter);

        gridLayout_2->addWidget(label_6, 4, 0, 1, 1);

        label_8 = new QLabel(widgetInner);
        label_8->setObjectName(QStringLiteral("label_8"));
        label_8->setMinimumSize(QSize(100, 20));
        label_8->setMaximumSize(QSize(100, 20));
        label_8->setAlignment(Qt::AlignCenter);

        gridLayout_2->addWidget(label_8, 6, 0, 1, 1);

        textEdit_description = new QTextEdit(widgetInner);
        textEdit_description->setObjectName(QStringLiteral("textEdit_description"));
        textEdit_description->setMaximumSize(QSize(16777215, 100));

        gridLayout_2->addWidget(textEdit_description, 6, 1, 1, 1);

        label_4 = new QLabel(widgetInner);
        label_4->setObjectName(QStringLiteral("label_4"));
        label_4->setMinimumSize(QSize(100, 20));
        label_4->setMaximumSize(QSize(100, 20));
        label_4->setAlignment(Qt::AlignCenter);

        gridLayout_2->addWidget(label_4, 3, 0, 1, 1);

        widget_2 = new QWidget(widgetInner);
        widget_2->setObjectName(QStringLiteral("widget_2"));
        widget_2->setMinimumSize(QSize(0, 40));
        widget_2->setMaximumSize(QSize(16777215, 40));
        horizontalLayout = new QHBoxLayout(widget_2);
        horizontalLayout->setSpacing(0);
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        horizontalLayout->setContentsMargins(0, 0, 0, 0);
        label_13 = new QLabel(widget_2);
        label_13->setObjectName(QStringLiteral("label_13"));

        horizontalLayout->addWidget(label_13);

        horizontalSpacer_2 = new QSpacerItem(349, 19, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout->addItem(horizontalSpacer_2);

        toolButton_min = new QToolButton(widget_2);
        toolButton_min->setObjectName(QStringLiteral("toolButton_min"));
        toolButton_min->setMinimumSize(QSize(30, 30));
        toolButton_min->setMaximumSize(QSize(30, 30));
        toolButton_min->setAutoRaise(true);

        horizontalLayout->addWidget(toolButton_min);

        toolButton_close = new QToolButton(widget_2);
        toolButton_close->setObjectName(QStringLiteral("toolButton_close"));
        toolButton_close->setMinimumSize(QSize(30, 30));
        toolButton_close->setMaximumSize(QSize(30, 30));
        toolButton_close->setAutoRaise(true);

        horizontalLayout->addWidget(toolButton_close);


        gridLayout_2->addWidget(widget_2, 0, 0, 1, 3);

        widget_3 = new QWidget(widgetInner);
        widget_3->setObjectName(QStringLiteral("widget_3"));
        widget_3->setMinimumSize(QSize(0, 40));
        pushButton_sure = new QPushButton(widget_3);
        pushButton_sure->setObjectName(QStringLiteral("pushButton_sure"));
        pushButton_sure->setGeometry(QRect(270, 10, 111, 23));
        pushButton_cancel = new QPushButton(widget_3);
        pushButton_cancel->setObjectName(QStringLiteral("pushButton_cancel"));
        pushButton_cancel->setGeometry(QRect(410, 10, 101, 23));
        pushButton_update_image = new QPushButton(widget_3);
        pushButton_update_image->setObjectName(QStringLiteral("pushButton_update_image"));
        pushButton_update_image->setGeometry(QRect(20, 10, 91, 23));
        label_show_image_num = new QLabel(widget_3);
        label_show_image_num->setObjectName(QStringLiteral("label_show_image_num"));
        label_show_image_num->setGeometry(QRect(110, 10, 100, 23));
        label_show_image_num->setMinimumSize(QSize(100, 0));
        pushButton = new QPushButton(widget_3);
        pushButton->setObjectName(QStringLiteral("pushButton"));
        pushButton->setGeometry(QRect(130, 10, 101, 23));

        gridLayout_2->addWidget(widget_3, 11, 0, 1, 2);

        listWidget_act_manager = new QListWidget(widgetInner);
        listWidget_act_manager->setObjectName(QStringLiteral("listWidget_act_manager"));

        gridLayout_2->addWidget(listWidget_act_manager, 10, 0, 1, 2);


        gridLayout->addWidget(widgetInner, 0, 0, 1, 1);


        retranslateUi(UpdateActivity);

        QMetaObject::connectSlotsByName(UpdateActivity);
    } // setupUi

    void retranslateUi(QWidget *UpdateActivity)
    {
        UpdateActivity->setWindowTitle(QApplication::translate("UpdateActivity", "Form", 0));
        label_10->setText(QApplication::translate("UpdateActivity", "\345\275\223\345\211\215\345\217\202\344\270\216\344\272\272\346\225\260", 0));
        label_7->setText(QApplication::translate("UpdateActivity", "\346\264\273\345\212\250\346\221\230\350\246\201", 0));
        label_12->setText(QApplication::translate("UpdateActivity", "\345\275\223\345\211\215\347\256\241\347\220\206\345\221\230\357\274\232", 0));
        label_9->setText(QApplication::translate("UpdateActivity", "\346\264\273\345\212\250\345\234\260\347\202\271", 0));
        label_join_num->setText(QApplication::translate("UpdateActivity", "TextLabel", 0));
        label_id->setText(QApplication::translate("UpdateActivity", "TextLabel", 0));
        label->setText(QApplication::translate("UpdateActivity", "\346\264\273\345\212\250id", 0));
        label_create_time->setText(QApplication::translate("UpdateActivity", "TextLabel", 0));
        label_3->setText(QApplication::translate("UpdateActivity", "\346\264\273\345\212\250\345\220\215\347\247\260", 0));
        label_6->setText(QApplication::translate("UpdateActivity", "\346\264\273\345\212\250\346\210\252\346\255\242\346\227\266\351\227\264", 0));
        label_8->setText(QApplication::translate("UpdateActivity", "\346\264\273\345\212\250\346\217\217\350\277\260", 0));
        label_4->setText(QApplication::translate("UpdateActivity", "\346\264\273\345\212\250\345\210\233\345\273\272\346\227\266\351\227\264", 0));
        label_13->setText(QApplication::translate("UpdateActivity", "\346\264\273\345\212\250\350\257\246\347\273\206\344\277\241\346\201\257", 0));
        toolButton_min->setText(QApplication::translate("UpdateActivity", "--", 0));
        toolButton_close->setText(QApplication::translate("UpdateActivity", "\303\227", 0));
        pushButton_sure->setText(QApplication::translate("UpdateActivity", "\347\241\256\350\256\244", 0));
        pushButton_cancel->setText(QApplication::translate("UpdateActivity", "\345\217\226\346\266\210", 0));
        pushButton_update_image->setText(QApplication::translate("UpdateActivity", "\344\270\212\344\274\240\346\264\273\345\212\250\345\233\276\347\211\207", 0));
        label_show_image_num->setText(QString());
        pushButton->setText(QApplication::translate("UpdateActivity", "\345\257\274\345\207\272\346\212\245\345\220\215\350\241\250", 0));
    } // retranslateUi

};

namespace Ui {
    class UpdateActivity: public Ui_UpdateActivity {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_UPDATEACTIVITY_H
