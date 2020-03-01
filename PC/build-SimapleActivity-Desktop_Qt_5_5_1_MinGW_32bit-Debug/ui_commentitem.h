/********************************************************************************
** Form generated from reading UI file 'commentitem.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_COMMENTITEM_H
#define UI_COMMENTITEM_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_CommentItem
{
public:
    QGridLayout *gridLayout;
    QWidget *widgetInner;
    QGridLayout *gridLayout_2;
    QWidget *widget_foot_nav;
    QHBoxLayout *horizontalLayout;
    QLabel *label_time;
    QSpacerItem *horizontalSpacer;
    QPushButton *pushButton_reply;
    QWidget *widget_curr_content;
    QHBoxLayout *horizontalLayout_2;
    QLabel *label_curr_name;
    QLabel *label_curr_content;
    QLabel *label_head;
    QSpacerItem *horizontalSpacer_2;
    QWidget *widget_last_cpntent;
    QGridLayout *gridLayout_3;
    QLabel *label_last_content;
    QLabel *label_last_name;

    void setupUi(QWidget *CommentItem)
    {
        if (CommentItem->objectName().isEmpty())
            CommentItem->setObjectName(QStringLiteral("CommentItem"));
        CommentItem->resize(926, 124);
        gridLayout = new QGridLayout(CommentItem);
        gridLayout->setSpacing(0);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        gridLayout->setContentsMargins(0, 0, 0, 0);
        widgetInner = new QWidget(CommentItem);
        widgetInner->setObjectName(QStringLiteral("widgetInner"));
        gridLayout_2 = new QGridLayout(widgetInner);
        gridLayout_2->setObjectName(QStringLiteral("gridLayout_2"));
        widget_foot_nav = new QWidget(widgetInner);
        widget_foot_nav->setObjectName(QStringLiteral("widget_foot_nav"));
        widget_foot_nav->setMaximumSize(QSize(16777215, 21));
        horizontalLayout = new QHBoxLayout(widget_foot_nav);
        horizontalLayout->setSpacing(0);
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        horizontalLayout->setContentsMargins(0, 0, 0, 0);
        label_time = new QLabel(widget_foot_nav);
        label_time->setObjectName(QStringLiteral("label_time"));
        label_time->setMinimumSize(QSize(100, 0));

        horizontalLayout->addWidget(label_time);

        horizontalSpacer = new QSpacerItem(693, 17, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout->addItem(horizontalSpacer);

        pushButton_reply = new QPushButton(widget_foot_nav);
        pushButton_reply->setObjectName(QStringLiteral("pushButton_reply"));
        pushButton_reply->setCursor(QCursor(Qt::PointingHandCursor));

        horizontalLayout->addWidget(pushButton_reply);


        gridLayout_2->addWidget(widget_foot_nav, 2, 1, 1, 1);

        widget_curr_content = new QWidget(widgetInner);
        widget_curr_content->setObjectName(QStringLiteral("widget_curr_content"));
        horizontalLayout_2 = new QHBoxLayout(widget_curr_content);
        horizontalLayout_2->setObjectName(QStringLiteral("horizontalLayout_2"));
        label_curr_name = new QLabel(widget_curr_content);
        label_curr_name->setObjectName(QStringLiteral("label_curr_name"));
        QSizePolicy sizePolicy(QSizePolicy::Maximum, QSizePolicy::Minimum);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(0);
        sizePolicy.setHeightForWidth(label_curr_name->sizePolicy().hasHeightForWidth());
        label_curr_name->setSizePolicy(sizePolicy);
        label_curr_name->setMaximumSize(QSize(16777215, 16777215));
        label_curr_name->setTextFormat(Qt::AutoText);
        label_curr_name->setScaledContents(true);
        label_curr_name->setAlignment(Qt::AlignLeading|Qt::AlignLeft|Qt::AlignTop);
        label_curr_name->setWordWrap(true);

        horizontalLayout_2->addWidget(label_curr_name);

        label_curr_content = new QLabel(widget_curr_content);
        label_curr_content->setObjectName(QStringLiteral("label_curr_content"));
        label_curr_content->setScaledContents(true);
        label_curr_content->setAlignment(Qt::AlignLeading|Qt::AlignLeft|Qt::AlignTop);
        label_curr_content->setWordWrap(true);

        horizontalLayout_2->addWidget(label_curr_content);


        gridLayout_2->addWidget(widget_curr_content, 0, 1, 1, 1);

        label_head = new QLabel(widgetInner);
        label_head->setObjectName(QStringLiteral("label_head"));
        label_head->setMinimumSize(QSize(40, 40));
        label_head->setMaximumSize(QSize(40, 40));

        gridLayout_2->addWidget(label_head, 0, 0, 1, 1);

        horizontalSpacer_2 = new QSpacerItem(40, 20, QSizePolicy::Fixed, QSizePolicy::Minimum);

        gridLayout_2->addItem(horizontalSpacer_2, 2, 0, 1, 1);

        widget_last_cpntent = new QWidget(widgetInner);
        widget_last_cpntent->setObjectName(QStringLiteral("widget_last_cpntent"));
        gridLayout_3 = new QGridLayout(widget_last_cpntent);
        gridLayout_3->setObjectName(QStringLiteral("gridLayout_3"));
        label_last_content = new QLabel(widget_last_cpntent);
        label_last_content->setObjectName(QStringLiteral("label_last_content"));
        label_last_content->setScaledContents(true);
        label_last_content->setAlignment(Qt::AlignLeading|Qt::AlignLeft|Qt::AlignTop);
        label_last_content->setWordWrap(true);

        gridLayout_3->addWidget(label_last_content, 0, 1, 1, 1);

        label_last_name = new QLabel(widget_last_cpntent);
        label_last_name->setObjectName(QStringLiteral("label_last_name"));
        QSizePolicy sizePolicy1(QSizePolicy::Fixed, QSizePolicy::Minimum);
        sizePolicy1.setHorizontalStretch(0);
        sizePolicy1.setVerticalStretch(0);
        sizePolicy1.setHeightForWidth(label_last_name->sizePolicy().hasHeightForWidth());
        label_last_name->setSizePolicy(sizePolicy1);
        label_last_name->setMaximumSize(QSize(16777215, 16777215));
        label_last_name->setScaledContents(true);
        label_last_name->setAlignment(Qt::AlignLeading|Qt::AlignLeft|Qt::AlignTop);
        label_last_name->setWordWrap(true);

        gridLayout_3->addWidget(label_last_name, 0, 0, 1, 1);


        gridLayout_2->addWidget(widget_last_cpntent, 1, 1, 1, 1);


        gridLayout->addWidget(widgetInner, 0, 0, 1, 1);


        retranslateUi(CommentItem);

        QMetaObject::connectSlotsByName(CommentItem);
    } // setupUi

    void retranslateUi(QWidget *CommentItem)
    {
        CommentItem->setWindowTitle(QApplication::translate("CommentItem", "Form", 0));
        label_time->setText(QApplication::translate("CommentItem", "\345\217\221\345\270\203\346\227\266\351\227\264", 0));
        pushButton_reply->setText(QApplication::translate("CommentItem", "\345\233\236\345\244\215", 0));
        label_curr_name->setText(QApplication::translate("CommentItem", "buzhidao1", 0));
        label_curr_content->setText(QApplication::translate("CommentItem", "\345\206\205\345\256\271", 0));
        label_head->setText(QApplication::translate("CommentItem", "\345\244\264\345\203\217", 0));
        label_last_content->setText(QApplication::translate("CommentItem", "\345\206\205\345\256\271", 0));
        label_last_name->setText(QApplication::translate("CommentItem", "sdaasdaasdas", 0));
    } // retranslateUi

};

namespace Ui {
    class CommentItem: public Ui_CommentItem {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_COMMENTITEM_H
