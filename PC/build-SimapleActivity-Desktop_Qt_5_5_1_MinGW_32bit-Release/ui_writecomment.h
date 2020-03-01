/********************************************************************************
** Form generated from reading UI file 'writecomment.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_WRITECOMMENT_H
#define UI_WRITECOMMENT_H

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

class Ui_WriteComment
{
public:
    QGridLayout *gridLayout;
    MyWidgetRegister *widgetInner;
    QGridLayout *gridLayout_2;
    QWidget *widget_comment_nav;
    QHBoxLayout *horizontalLayout;
    QLabel *label;
    QSpacerItem *horizontalSpacer_2;
    QToolButton *toolButton_min;
    QToolButton *toolButton_max;
    QToolButton *toolButton_close;
    QWidget *widget;
    QGridLayout *gridLayout_3;
    QWidget *widget_write_comment;
    QGridLayout *gridLayout_4;
    QTextEdit *textEdit;
    QPushButton *pushButton_comment;
    QSpacerItem *horizontalSpacer;
    QLabel *label_2;
    QPushButton *pushButton_update;
    QListWidget *listWidget_show_coment;

    void setupUi(QWidget *WriteComment)
    {
        if (WriteComment->objectName().isEmpty())
            WriteComment->setObjectName(QStringLiteral("WriteComment"));
        WriteComment->resize(953, 529);
        gridLayout = new QGridLayout(WriteComment);
        gridLayout->setSpacing(6);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        gridLayout->setContentsMargins(9, 9, 9, 9);
        widgetInner = new MyWidgetRegister(WriteComment);
        widgetInner->setObjectName(QStringLiteral("widgetInner"));
        gridLayout_2 = new QGridLayout(widgetInner);
        gridLayout_2->setSpacing(0);
        gridLayout_2->setObjectName(QStringLiteral("gridLayout_2"));
        gridLayout_2->setContentsMargins(0, 0, 0, 0);
        widget_comment_nav = new QWidget(widgetInner);
        widget_comment_nav->setObjectName(QStringLiteral("widget_comment_nav"));
        widget_comment_nav->setMinimumSize(QSize(0, 40));
        widget_comment_nav->setMaximumSize(QSize(16777215, 40));
        horizontalLayout = new QHBoxLayout(widget_comment_nav);
        horizontalLayout->setSpacing(0);
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        horizontalLayout->setContentsMargins(10, 0, 0, 0);
        label = new QLabel(widget_comment_nav);
        label->setObjectName(QStringLiteral("label"));

        horizontalLayout->addWidget(label);

        horizontalSpacer_2 = new QSpacerItem(784, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout->addItem(horizontalSpacer_2);

        toolButton_min = new QToolButton(widget_comment_nav);
        toolButton_min->setObjectName(QStringLiteral("toolButton_min"));
        toolButton_min->setMinimumSize(QSize(30, 30));
        toolButton_min->setMaximumSize(QSize(30, 30));
        toolButton_min->setAutoRaise(true);

        horizontalLayout->addWidget(toolButton_min);

        toolButton_max = new QToolButton(widget_comment_nav);
        toolButton_max->setObjectName(QStringLiteral("toolButton_max"));
        toolButton_max->setMinimumSize(QSize(30, 30));
        toolButton_max->setMaximumSize(QSize(30, 30));
        toolButton_max->setAutoRaise(true);

        horizontalLayout->addWidget(toolButton_max);

        toolButton_close = new QToolButton(widget_comment_nav);
        toolButton_close->setObjectName(QStringLiteral("toolButton_close"));
        toolButton_close->setMinimumSize(QSize(30, 30));
        toolButton_close->setMaximumSize(QSize(30, 30));
        toolButton_close->setAutoRaise(true);

        horizontalLayout->addWidget(toolButton_close);


        gridLayout_2->addWidget(widget_comment_nav, 0, 0, 1, 1);

        widget = new QWidget(widgetInner);
        widget->setObjectName(QStringLiteral("widget"));
        gridLayout_3 = new QGridLayout(widget);
        gridLayout_3->setObjectName(QStringLiteral("gridLayout_3"));
        widget_write_comment = new QWidget(widget);
        widget_write_comment->setObjectName(QStringLiteral("widget_write_comment"));
        widget_write_comment->setMinimumSize(QSize(0, 150));
        widget_write_comment->setMaximumSize(QSize(16777215, 150));
        gridLayout_4 = new QGridLayout(widget_write_comment);
        gridLayout_4->setObjectName(QStringLiteral("gridLayout_4"));
        textEdit = new QTextEdit(widget_write_comment);
        textEdit->setObjectName(QStringLiteral("textEdit"));

        gridLayout_4->addWidget(textEdit, 0, 0, 1, 4);

        pushButton_comment = new QPushButton(widget_write_comment);
        pushButton_comment->setObjectName(QStringLiteral("pushButton_comment"));
        pushButton_comment->setCursor(QCursor(Qt::PointingHandCursor));

        gridLayout_4->addWidget(pushButton_comment, 1, 3, 1, 1);

        horizontalSpacer = new QSpacerItem(978, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        gridLayout_4->addItem(horizontalSpacer, 1, 1, 1, 1);

        label_2 = new QLabel(widget_write_comment);
        label_2->setObjectName(QStringLiteral("label_2"));

        gridLayout_4->addWidget(label_2, 1, 0, 1, 1);

        pushButton_update = new QPushButton(widget_write_comment);
        pushButton_update->setObjectName(QStringLiteral("pushButton_update"));

        gridLayout_4->addWidget(pushButton_update, 1, 2, 1, 1);


        gridLayout_3->addWidget(widget_write_comment, 0, 0, 1, 1);

        listWidget_show_coment = new QListWidget(widget);
        listWidget_show_coment->setObjectName(QStringLiteral("listWidget_show_coment"));
        listWidget_show_coment->setSpacing(0);

        gridLayout_3->addWidget(listWidget_show_coment, 1, 0, 1, 1);


        gridLayout_2->addWidget(widget, 1, 0, 1, 1);


        gridLayout->addWidget(widgetInner, 0, 0, 1, 1);


        retranslateUi(WriteComment);

        QMetaObject::connectSlotsByName(WriteComment);
    } // setupUi

    void retranslateUi(QWidget *WriteComment)
    {
        WriteComment->setWindowTitle(QApplication::translate("WriteComment", "Form", 0));
        label->setText(QApplication::translate("WriteComment", "\350\257\204\350\256\272\346\237\220\346\237\220", 0));
        toolButton_min->setText(QApplication::translate("WriteComment", "--", 0));
        toolButton_max->setText(QApplication::translate("WriteComment", "\342\226\241", 0));
        toolButton_close->setText(QApplication::translate("WriteComment", "\342\225\263", 0));
        textEdit->setPlaceholderText(QApplication::translate("WriteComment", "\350\257\267\350\276\223\345\205\245\350\257\204\350\256\272\343\200\202\343\200\202\343\200\202\343\200\202", 0));
        pushButton_comment->setText(QApplication::translate("WriteComment", "\350\257\204\350\256\272", 0));
        label_2->setText(QApplication::translate("WriteComment", "\347\262\276\345\275\251\350\257\204\350\256\272", 0));
        pushButton_update->setText(QApplication::translate("WriteComment", "\345\210\267\346\226\260", 0));
    } // retranslateUi

};

namespace Ui {
    class WriteComment: public Ui_WriteComment {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_WRITECOMMENT_H
