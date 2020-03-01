/********************************************************************************
** Form generated from reading UI file 'contentitem.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_CONTENTITEM_H
#define UI_CONTENTITEM_H

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

class Ui_ContentItem
{
public:
    QGridLayout *gridLayout_4;
    QWidget *widgetInner;
    QGridLayout *gridLayout;
    QWidget *widgetHead;
    QGridLayout *gridLayout_2;
    QLabel *label_name;
    QSpacerItem *horizontalSpacer;
    QPushButton *toolButton_sign_up;
    QLabel *label_create_time;
    QLabel *label_abstract;
    QWidget *widget_2;
    QGridLayout *gridLayout_3;
    QSpacerItem *horizontalSpacer_4;
    QWidget *widgetImageContent;
    QSpacerItem *horizontalSpacer_3;
    QWidget *widgetFoot;
    QHBoxLayout *horizontalLayout;
    QLabel *label_join_num;
    QSpacerItem *horizontalSpacer_2;
    QPushButton *pushButton_praise;
    QPushButton *pushButton_write_comment;

    void setupUi(QWidget *ContentItem)
    {
        if (ContentItem->objectName().isEmpty())
            ContentItem->setObjectName(QStringLiteral("ContentItem"));
        ContentItem->resize(450, 472);
        gridLayout_4 = new QGridLayout(ContentItem);
        gridLayout_4->setSpacing(0);
        gridLayout_4->setObjectName(QStringLiteral("gridLayout_4"));
        gridLayout_4->setContentsMargins(0, 0, 0, 0);
        widgetInner = new QWidget(ContentItem);
        widgetInner->setObjectName(QStringLiteral("widgetInner"));
        widgetInner->setStyleSheet(QStringLiteral("background-color:rgb(248,246,242);"));
        gridLayout = new QGridLayout(widgetInner);
        gridLayout->setSpacing(0);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        gridLayout->setContentsMargins(0, 0, 0, 0);
        widgetHead = new QWidget(widgetInner);
        widgetHead->setObjectName(QStringLiteral("widgetHead"));
        widgetHead->setMinimumSize(QSize(0, 100));
        widgetHead->setMaximumSize(QSize(16777215, 100));
        gridLayout_2 = new QGridLayout(widgetHead);
        gridLayout_2->setObjectName(QStringLiteral("gridLayout_2"));
        label_name = new QLabel(widgetHead);
        label_name->setObjectName(QStringLiteral("label_name"));
        QFont font;
        font.setFamily(QString::fromUtf8("\345\256\213\344\275\223"));
        font.setPointSize(16);
        font.setBold(true);
        font.setWeight(75);
        label_name->setFont(font);

        gridLayout_2->addWidget(label_name, 0, 0, 1, 1);

        horizontalSpacer = new QSpacerItem(236, 17, QSizePolicy::Expanding, QSizePolicy::Minimum);

        gridLayout_2->addItem(horizontalSpacer, 0, 1, 1, 1);

        toolButton_sign_up = new QPushButton(widgetHead);
        toolButton_sign_up->setObjectName(QStringLiteral("toolButton_sign_up"));
        toolButton_sign_up->setCursor(QCursor(Qt::PointingHandCursor));

        gridLayout_2->addWidget(toolButton_sign_up, 0, 2, 1, 1);

        label_create_time = new QLabel(widgetHead);
        label_create_time->setObjectName(QStringLiteral("label_create_time"));
        label_create_time->setMinimumSize(QSize(0, 0));
        label_create_time->setMaximumSize(QSize(16777215, 16777215));

        gridLayout_2->addWidget(label_create_time, 1, 0, 1, 3);

        label_abstract = new QLabel(widgetHead);
        label_abstract->setObjectName(QStringLiteral("label_abstract"));
        label_abstract->setMinimumSize(QSize(0, 0));
        label_abstract->setMaximumSize(QSize(16777215, 16777215));

        gridLayout_2->addWidget(label_abstract, 2, 0, 1, 3);


        gridLayout->addWidget(widgetHead, 0, 0, 1, 1);

        widget_2 = new QWidget(widgetInner);
        widget_2->setObjectName(QStringLiteral("widget_2"));
        gridLayout_3 = new QGridLayout(widget_2);
        gridLayout_3->setSpacing(0);
        gridLayout_3->setObjectName(QStringLiteral("gridLayout_3"));
        gridLayout_3->setContentsMargins(0, 0, 0, 0);
        horizontalSpacer_4 = new QSpacerItem(40, 20, QSizePolicy::Fixed, QSizePolicy::Minimum);

        gridLayout_3->addItem(horizontalSpacer_4, 0, 0, 1, 1);

        widgetImageContent = new QWidget(widget_2);
        widgetImageContent->setObjectName(QStringLiteral("widgetImageContent"));
        widgetImageContent->setMinimumSize(QSize(315, 315));
        widgetImageContent->setMaximumSize(QSize(315, 315));

        gridLayout_3->addWidget(widgetImageContent, 0, 1, 1, 1);

        horizontalSpacer_3 = new QSpacerItem(62, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        gridLayout_3->addItem(horizontalSpacer_3, 0, 2, 1, 1);

        widgetFoot = new QWidget(widget_2);
        widgetFoot->setObjectName(QStringLiteral("widgetFoot"));
        widgetFoot->setMaximumSize(QSize(16777215, 35));
        horizontalLayout = new QHBoxLayout(widgetFoot);
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        label_join_num = new QLabel(widgetFoot);
        label_join_num->setObjectName(QStringLiteral("label_join_num"));

        horizontalLayout->addWidget(label_join_num);

        horizontalSpacer_2 = new QSpacerItem(201, 14, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout->addItem(horizontalSpacer_2);

        pushButton_praise = new QPushButton(widgetFoot);
        pushButton_praise->setObjectName(QStringLiteral("pushButton_praise"));
        pushButton_praise->setMinimumSize(QSize(75, 20));
        pushButton_praise->setMaximumSize(QSize(75, 20));
        pushButton_praise->setCursor(QCursor(Qt::PointingHandCursor));
        QIcon icon;
        icon.addFile(QStringLiteral(":/Main/C:/Users/ASUS/Pictures/Camera Roll/wgz.png"), QSize(), QIcon::Normal, QIcon::Off);
        pushButton_praise->setIcon(icon);

        horizontalLayout->addWidget(pushButton_praise);

        pushButton_write_comment = new QPushButton(widgetFoot);
        pushButton_write_comment->setObjectName(QStringLiteral("pushButton_write_comment"));
        pushButton_write_comment->setMinimumSize(QSize(75, 20));
        pushButton_write_comment->setMaximumSize(QSize(75, 20));
        pushButton_write_comment->setCursor(QCursor(Qt::PointingHandCursor));

        horizontalLayout->addWidget(pushButton_write_comment);


        gridLayout_3->addWidget(widgetFoot, 1, 0, 1, 3);


        gridLayout->addWidget(widget_2, 1, 0, 1, 1);


        gridLayout_4->addWidget(widgetInner, 0, 0, 1, 1);


        retranslateUi(ContentItem);

        QMetaObject::connectSlotsByName(ContentItem);
    } // setupUi

    void retranslateUi(QWidget *ContentItem)
    {
        ContentItem->setWindowTitle(QApplication::translate("ContentItem", "Form", 0));
        label_name->setText(QApplication::translate("ContentItem", "\346\264\273\345\212\250\345\220\215\347\247\260", 0));
        toolButton_sign_up->setText(QApplication::translate("ContentItem", "\342\225\213\347\253\213\345\215\263\345\217\202\345\212\240", 0));
        label_create_time->setText(QApplication::translate("ContentItem", "\346\264\273\345\212\250\345\210\233\345\273\272\346\227\266\351\227\264", 0));
        label_abstract->setText(QApplication::translate("ContentItem", "\346\264\273\345\212\250\346\221\230\350\246\201", 0));
#ifndef QT_NO_TOOLTIP
        widgetImageContent->setToolTip(QString());
#endif // QT_NO_TOOLTIP
#ifndef QT_NO_WHATSTHIS
        widgetImageContent->setWhatsThis(QString());
#endif // QT_NO_WHATSTHIS
        label_join_num->setText(QApplication::translate("ContentItem", "\345\267\262\345\217\202\345\212\24020\344\272\272", 0));
        pushButton_praise->setText(QApplication::translate("ContentItem", "(100)", 0));
        pushButton_write_comment->setText(QApplication::translate("ContentItem", "\350\257\204\350\256\272", 0));
    } // retranslateUi

};

namespace Ui {
    class ContentItem: public Ui_ContentItem {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_CONTENTITEM_H
