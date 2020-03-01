/********************************************************************************
** Form generated from reading UI file 'userdynamic.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_USERDYNAMIC_H
#define UI_USERDYNAMIC_H

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

class Ui_UserDynamic
{
public:
    QGridLayout *gridLayout;
    QWidget *widgetInner;
    QGridLayout *gridLayout_2;
    QWidget *widget_foot;
    QHBoxLayout *horizontalLayout;
    QSpacerItem *horizontalSpacer;
    QPushButton *pushButton_praise;
    QPushButton *pushButton_write_comment;
    QWidget *widget_head;
    QGridLayout *gridLayout_3;
    QLabel *label_user_name;
    QLabel *label_head;
    QLabel *label_write_time;
    QWidget *widget_text;
    QHBoxLayout *horizontalLayout_2;
    QSpacerItem *horizontalSpacer_4;
    QLabel *label_content;
    QWidget *widget_body;
    QGridLayout *gridLayout_4;
    QSpacerItem *horizontalSpacer_2;
    QWidget *widgetImageContent;
    QSpacerItem *horizontalSpacer_3;

    void setupUi(QWidget *UserDynamic)
    {
        if (UserDynamic->objectName().isEmpty())
            UserDynamic->setObjectName(QStringLiteral("UserDynamic"));
        UserDynamic->resize(815, 475);
        gridLayout = new QGridLayout(UserDynamic);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        gridLayout->setHorizontalSpacing(0);
        gridLayout->setContentsMargins(0, 0, 0, 0);
        widgetInner = new QWidget(UserDynamic);
        widgetInner->setObjectName(QStringLiteral("widgetInner"));
        gridLayout_2 = new QGridLayout(widgetInner);
        gridLayout_2->setSpacing(0);
        gridLayout_2->setObjectName(QStringLiteral("gridLayout_2"));
        gridLayout_2->setContentsMargins(0, 0, 0, 0);
        widget_foot = new QWidget(widgetInner);
        widget_foot->setObjectName(QStringLiteral("widget_foot"));
        widget_foot->setMinimumSize(QSize(0, 40));
        widget_foot->setMaximumSize(QSize(16777215, 40));
        horizontalLayout = new QHBoxLayout(widget_foot);
        horizontalLayout->setSpacing(0);
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        horizontalLayout->setContentsMargins(0, 0, 0, 0);
        horizontalSpacer = new QSpacerItem(673, 19, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout->addItem(horizontalSpacer);

        pushButton_praise = new QPushButton(widget_foot);
        pushButton_praise->setObjectName(QStringLiteral("pushButton_praise"));
        pushButton_praise->setMinimumSize(QSize(75, 24));
        pushButton_praise->setMaximumSize(QSize(75, 24));
        pushButton_praise->setCursor(QCursor(Qt::PointingHandCursor));
        QIcon icon;
        icon.addFile(QStringLiteral(":/Main/C:/Users/ASUS/Pictures/Camera Roll/wgz.png"), QSize(), QIcon::Normal, QIcon::Off);
        icon.addFile(QStringLiteral(":/Main/C:/Users/ASUS/Pictures/Camera Roll/wgw.png"), QSize(), QIcon::Normal, QIcon::On);
        pushButton_praise->setIcon(icon);
        pushButton_praise->setCheckable(false);

        horizontalLayout->addWidget(pushButton_praise);

        pushButton_write_comment = new QPushButton(widget_foot);
        pushButton_write_comment->setObjectName(QStringLiteral("pushButton_write_comment"));
        pushButton_write_comment->setMinimumSize(QSize(75, 23));
        pushButton_write_comment->setMaximumSize(QSize(75, 23));
        pushButton_write_comment->setCursor(QCursor(Qt::PointingHandCursor));

        horizontalLayout->addWidget(pushButton_write_comment);


        gridLayout_2->addWidget(widget_foot, 3, 0, 1, 1);

        widget_head = new QWidget(widgetInner);
        widget_head->setObjectName(QStringLiteral("widget_head"));
        widget_head->setMinimumSize(QSize(0, 60));
        widget_head->setMaximumSize(QSize(16777215, 60));
        gridLayout_3 = new QGridLayout(widget_head);
        gridLayout_3->setObjectName(QStringLiteral("gridLayout_3"));
        label_user_name = new QLabel(widget_head);
        label_user_name->setObjectName(QStringLiteral("label_user_name"));
        QFont font;
        font.setPointSize(12);
        font.setBold(true);
        font.setWeight(75);
        label_user_name->setFont(font);

        gridLayout_3->addWidget(label_user_name, 0, 2, 1, 1);

        label_head = new QLabel(widget_head);
        label_head->setObjectName(QStringLiteral("label_head"));
        label_head->setMinimumSize(QSize(40, 40));
        label_head->setMaximumSize(QSize(40, 40));

        gridLayout_3->addWidget(label_head, 0, 0, 2, 1);

        label_write_time = new QLabel(widget_head);
        label_write_time->setObjectName(QStringLiteral("label_write_time"));

        gridLayout_3->addWidget(label_write_time, 1, 2, 1, 1);


        gridLayout_2->addWidget(widget_head, 0, 0, 1, 1);

        widget_text = new QWidget(widgetInner);
        widget_text->setObjectName(QStringLiteral("widget_text"));
        widget_text->setMinimumSize(QSize(0, 60));
        widget_text->setMaximumSize(QSize(16777215, 60));
        horizontalLayout_2 = new QHBoxLayout(widget_text);
        horizontalLayout_2->setSpacing(0);
        horizontalLayout_2->setObjectName(QStringLiteral("horizontalLayout_2"));
        horizontalLayout_2->setContentsMargins(9, 0, 0, 0);
        horizontalSpacer_4 = new QSpacerItem(40, 20, QSizePolicy::Fixed, QSizePolicy::Minimum);

        horizontalLayout_2->addItem(horizontalSpacer_4);

        label_content = new QLabel(widget_text);
        label_content->setObjectName(QStringLiteral("label_content"));
        label_content->setMinimumSize(QSize(0, 60));
        label_content->setMaximumSize(QSize(16777215, 60));
        label_content->setStyleSheet(QStringLiteral("padding-top:5px;"));
        label_content->setScaledContents(true);
        label_content->setAlignment(Qt::AlignLeading|Qt::AlignLeft|Qt::AlignTop);
        label_content->setWordWrap(true);

        horizontalLayout_2->addWidget(label_content);


        gridLayout_2->addWidget(widget_text, 1, 0, 1, 1);

        widget_body = new QWidget(widgetInner);
        widget_body->setObjectName(QStringLiteral("widget_body"));
        gridLayout_4 = new QGridLayout(widget_body);
        gridLayout_4->setSpacing(0);
        gridLayout_4->setObjectName(QStringLiteral("gridLayout_4"));
        gridLayout_4->setContentsMargins(-1, 0, 0, 0);
        horizontalSpacer_2 = new QSpacerItem(40, 20, QSizePolicy::Fixed, QSizePolicy::Minimum);

        gridLayout_4->addItem(horizontalSpacer_2, 0, 0, 1, 1);

        widgetImageContent = new QWidget(widget_body);
        widgetImageContent->setObjectName(QStringLiteral("widgetImageContent"));
        widgetImageContent->setMinimumSize(QSize(315, 315));
        widgetImageContent->setMaximumSize(QSize(315, 315));

        gridLayout_4->addWidget(widgetImageContent, 0, 1, 2, 1);

        horizontalSpacer_3 = new QSpacerItem(519, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        gridLayout_4->addItem(horizontalSpacer_3, 1, 2, 1, 1);


        gridLayout_2->addWidget(widget_body, 2, 0, 1, 1);


        gridLayout->addWidget(widgetInner, 0, 0, 1, 1);


        retranslateUi(UserDynamic);

        QMetaObject::connectSlotsByName(UserDynamic);
    } // setupUi

    void retranslateUi(QWidget *UserDynamic)
    {
        UserDynamic->setWindowTitle(QApplication::translate("UserDynamic", "Form", 0));
        pushButton_praise->setText(QApplication::translate("UserDynamic", "(100)", 0));
        pushButton_write_comment->setText(QApplication::translate("UserDynamic", "\350\257\204\350\256\272", 0));
        label_user_name->setText(QApplication::translate("UserDynamic", "\347\224\250\346\210\267\345\220\215", 0));
        label_head->setText(QApplication::translate("UserDynamic", "TextLabel", 0));
        label_write_time->setText(QApplication::translate("UserDynamic", "\345\217\221\345\270\203\346\227\266\351\227\264", 0));
        label_content->setText(QApplication::translate("UserDynamic", "TextLabel", 0));
    } // retranslateUi

};

namespace Ui {
    class UserDynamic: public Ui_UserDynamic {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_USERDYNAMIC_H
