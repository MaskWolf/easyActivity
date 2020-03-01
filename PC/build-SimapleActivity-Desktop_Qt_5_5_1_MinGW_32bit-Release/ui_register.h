/********************************************************************************
** Form generated from reading UI file 'register.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_REGISTER_H
#define UI_REGISTER_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QRadioButton>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QStackedWidget>
#include <QtWidgets/QToolButton>
#include <QtWidgets/QWidget>
#include <mywidgetregister.h>

QT_BEGIN_NAMESPACE

class Ui_Register
{
public:
    QGridLayout *gridLayout;
    MyWidgetRegister *widgetInner;
    QGridLayout *gridLayout_4;
    QWidget *widget_register_nav;
    QHBoxLayout *horizontalLayout;
    QSpacerItem *horizontalSpacer;
    QToolButton *toolButton_3;
    QToolButton *toolButtonRegisterClose;
    QStackedWidget *stackedWidget;
    QWidget *page;
    QGridLayout *gridLayout_3;
    QWidget *widget_2;
    QGridLayout *gridLayout_2;
    QLabel *label_5;
    QWidget *widget;
    QLabel *label;
    QLabel *label_2;
    QLabel *label_3;
    QLineEdit *lineEdit_user_name;
    QLineEdit *lineEdit_pwd;
    QLineEdit *lineEdit_sure_pwd;
    QPushButton *pushButtonRegister;
    QLabel *label_4;
    QRadioButton *radioButton_man;
    QRadioButton *radioButton_woman;
    QLabel *label_6;
    QLineEdit *lineEdit_phone;
    QLabel *label_9;
    QLineEdit *lineEdit_email;
    QWidget *page_2;
    QLabel *label_7;
    QLabel *label_8;
    QLabel *label_user_name;
    QLabel *label_10;
    QLabel *label_pwd;
    QPushButton *pushButton_close;

    void setupUi(QWidget *Register)
    {
        if (Register->objectName().isEmpty())
            Register->setObjectName(QStringLiteral("Register"));
        Register->resize(485, 576);
        gridLayout = new QGridLayout(Register);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        widgetInner = new MyWidgetRegister(Register);
        widgetInner->setObjectName(QStringLiteral("widgetInner"));
        gridLayout_4 = new QGridLayout(widgetInner);
        gridLayout_4->setSpacing(0);
        gridLayout_4->setObjectName(QStringLiteral("gridLayout_4"));
        gridLayout_4->setContentsMargins(0, 0, 0, 0);
        widget_register_nav = new QWidget(widgetInner);
        widget_register_nav->setObjectName(QStringLiteral("widget_register_nav"));
        widget_register_nav->setMaximumSize(QSize(16777215, 40));
        horizontalLayout = new QHBoxLayout(widget_register_nav);
        horizontalLayout->setSpacing(0);
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        horizontalLayout->setContentsMargins(0, 0, 0, 0);
        horizontalSpacer = new QSpacerItem(403, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout->addItem(horizontalSpacer);

        toolButton_3 = new QToolButton(widget_register_nav);
        toolButton_3->setObjectName(QStringLiteral("toolButton_3"));
        toolButton_3->setMinimumSize(QSize(30, 30));
        toolButton_3->setAutoRaise(true);

        horizontalLayout->addWidget(toolButton_3);

        toolButtonRegisterClose = new QToolButton(widget_register_nav);
        toolButtonRegisterClose->setObjectName(QStringLiteral("toolButtonRegisterClose"));
        toolButtonRegisterClose->setMinimumSize(QSize(30, 30));
        QIcon icon;
        icon.addFile(QStringLiteral(":/Login/C:/Users/ASUS/Pictures/Login/wkf.png"), QSize(), QIcon::Normal, QIcon::Off);
        toolButtonRegisterClose->setIcon(icon);
        toolButtonRegisterClose->setAutoRaise(true);

        horizontalLayout->addWidget(toolButtonRegisterClose);


        gridLayout_4->addWidget(widget_register_nav, 0, 0, 1, 1);

        stackedWidget = new QStackedWidget(widgetInner);
        stackedWidget->setObjectName(QStringLiteral("stackedWidget"));
        page = new QWidget();
        page->setObjectName(QStringLiteral("page"));
        gridLayout_3 = new QGridLayout(page);
        gridLayout_3->setObjectName(QStringLiteral("gridLayout_3"));
        widget_2 = new QWidget(page);
        widget_2->setObjectName(QStringLiteral("widget_2"));
        gridLayout_2 = new QGridLayout(widget_2);
        gridLayout_2->setSpacing(0);
        gridLayout_2->setObjectName(QStringLiteral("gridLayout_2"));
        gridLayout_2->setContentsMargins(0, 0, 0, 0);
        label_5 = new QLabel(widget_2);
        label_5->setObjectName(QStringLiteral("label_5"));
        label_5->setMaximumSize(QSize(16777215, 40));
        QFont font;
        font.setFamily(QString::fromUtf8("\346\245\267\344\275\223"));
        font.setPointSize(20);
        label_5->setFont(font);
        label_5->setAlignment(Qt::AlignCenter);

        gridLayout_2->addWidget(label_5, 0, 0, 1, 1);

        widget = new QWidget(widget_2);
        widget->setObjectName(QStringLiteral("widget"));
        label = new QLabel(widget);
        label->setObjectName(QStringLiteral("label"));
        label->setGeometry(QRect(60, 65, 54, 12));
        label_2 = new QLabel(widget);
        label_2->setObjectName(QStringLiteral("label_2"));
        label_2->setGeometry(QRect(60, 115, 54, 12));
        label_3 = new QLabel(widget);
        label_3->setObjectName(QStringLiteral("label_3"));
        label_3->setGeometry(QRect(60, 165, 54, 12));
        lineEdit_user_name = new QLineEdit(widget);
        lineEdit_user_name->setObjectName(QStringLiteral("lineEdit_user_name"));
        lineEdit_user_name->setGeometry(QRect(140, 60, 211, 25));
        lineEdit_pwd = new QLineEdit(widget);
        lineEdit_pwd->setObjectName(QStringLiteral("lineEdit_pwd"));
        lineEdit_pwd->setGeometry(QRect(140, 110, 211, 25));
        lineEdit_pwd->setEchoMode(QLineEdit::Password);
        lineEdit_pwd->setCursorPosition(0);
        lineEdit_sure_pwd = new QLineEdit(widget);
        lineEdit_sure_pwd->setObjectName(QStringLiteral("lineEdit_sure_pwd"));
        lineEdit_sure_pwd->setGeometry(QRect(140, 160, 211, 25));
        lineEdit_sure_pwd->setEchoMode(QLineEdit::Password);
        pushButtonRegister = new QPushButton(widget);
        pushButtonRegister->setObjectName(QStringLiteral("pushButtonRegister"));
        pushButtonRegister->setGeometry(QRect(70, 350, 280, 30));
        pushButtonRegister->setCursor(QCursor(Qt::PointingHandCursor));
        label_4 = new QLabel(widget);
        label_4->setObjectName(QStringLiteral("label_4"));
        label_4->setGeometry(QRect(60, 210, 54, 12));
        radioButton_man = new QRadioButton(widget);
        radioButton_man->setObjectName(QStringLiteral("radioButton_man"));
        radioButton_man->setGeometry(QRect(140, 210, 89, 16));
        radioButton_woman = new QRadioButton(widget);
        radioButton_woman->setObjectName(QStringLiteral("radioButton_woman"));
        radioButton_woman->setGeometry(QRect(240, 210, 89, 16));
        label_6 = new QLabel(widget);
        label_6->setObjectName(QStringLiteral("label_6"));
        label_6->setGeometry(QRect(60, 255, 54, 12));
        lineEdit_phone = new QLineEdit(widget);
        lineEdit_phone->setObjectName(QStringLiteral("lineEdit_phone"));
        lineEdit_phone->setGeometry(QRect(140, 250, 211, 25));
        label_9 = new QLabel(widget);
        label_9->setObjectName(QStringLiteral("label_9"));
        label_9->setGeometry(QRect(60, 300, 54, 12));
        lineEdit_email = new QLineEdit(widget);
        lineEdit_email->setObjectName(QStringLiteral("lineEdit_email"));
        lineEdit_email->setGeometry(QRect(140, 299, 211, 25));

        gridLayout_2->addWidget(widget, 1, 0, 1, 1);


        gridLayout_3->addWidget(widget_2, 0, 0, 1, 1);

        stackedWidget->addWidget(page);
        page_2 = new QWidget();
        page_2->setObjectName(QStringLiteral("page_2"));
        label_7 = new QLabel(page_2);
        label_7->setObjectName(QStringLiteral("label_7"));
        label_7->setGeometry(QRect(0, 20, 440, 20));
        QFont font1;
        font1.setFamily(QString::fromUtf8("\346\245\267\344\275\223"));
        font1.setPointSize(16);
        font1.setBold(true);
        font1.setWeight(75);
        label_7->setFont(font1);
        label_7->setAlignment(Qt::AlignCenter);
        label_8 = new QLabel(page_2);
        label_8->setObjectName(QStringLiteral("label_8"));
        label_8->setGeometry(QRect(60, 100, 54, 12));
        label_user_name = new QLabel(page_2);
        label_user_name->setObjectName(QStringLiteral("label_user_name"));
        label_user_name->setGeometry(QRect(170, 100, 221, 16));
        label_user_name->setStyleSheet(QStringLiteral("color:red;"));
        label_10 = new QLabel(page_2);
        label_10->setObjectName(QStringLiteral("label_10"));
        label_10->setGeometry(QRect(60, 170, 54, 12));
        label_pwd = new QLabel(page_2);
        label_pwd->setObjectName(QStringLiteral("label_pwd"));
        label_pwd->setGeometry(QRect(170, 170, 221, 16));
        label_pwd->setStyleSheet(QStringLiteral("color:red;"));
        pushButton_close = new QPushButton(page_2);
        pushButton_close->setObjectName(QStringLiteral("pushButton_close"));
        pushButton_close->setGeometry(QRect(200, 310, 75, 23));
        stackedWidget->addWidget(page_2);

        gridLayout_4->addWidget(stackedWidget, 1, 0, 1, 1);


        gridLayout->addWidget(widgetInner, 0, 0, 1, 1);


        retranslateUi(Register);

        stackedWidget->setCurrentIndex(0);


        QMetaObject::connectSlotsByName(Register);
    } // setupUi

    void retranslateUi(QWidget *Register)
    {
        Register->setWindowTitle(QApplication::translate("Register", "Form", 0));
        toolButton_3->setText(QApplication::translate("Register", "--", 0));
        toolButtonRegisterClose->setText(QApplication::translate("Register", "...", 0));
        label_5->setText(QApplication::translate("Register", "\346\263\250\345\206\214\350\264\246\345\217\267", 0));
        label->setText(QApplication::translate("Register", "\347\224\250\346\210\267\345\220\215", 0));
        label_2->setText(QApplication::translate("Register", "\345\257\206\347\240\201", 0));
        label_3->setText(QApplication::translate("Register", "\347\241\256\350\256\244\345\257\206\347\240\201", 0));
        lineEdit_user_name->setPlaceholderText(QApplication::translate("Register", "\350\257\267\350\276\223\345\205\245\347\224\250\346\210\267\345\220\215", 0));
        lineEdit_pwd->setPlaceholderText(QApplication::translate("Register", "\350\257\267\350\276\223\345\205\245\345\257\206\347\240\201", 0));
        lineEdit_sure_pwd->setPlaceholderText(QApplication::translate("Register", "\350\257\267\347\241\256\350\256\244\345\257\206\347\240\201", 0));
        pushButtonRegister->setText(QApplication::translate("Register", "\346\263\250\345\206\214", 0));
        label_4->setText(QApplication::translate("Register", "\346\200\247\345\210\253", 0));
        radioButton_man->setText(QApplication::translate("Register", "\347\224\267", 0));
        radioButton_woman->setText(QApplication::translate("Register", "\345\245\263", 0));
        label_6->setText(QApplication::translate("Register", "\347\224\265\350\257\235", 0));
        lineEdit_phone->setPlaceholderText(QApplication::translate("Register", "\350\257\267\350\276\223\345\205\245\347\224\265\350\257\235", 0));
        label_9->setText(QApplication::translate("Register", "\351\202\256\347\256\261", 0));
        lineEdit_email->setPlaceholderText(QApplication::translate("Register", "\350\257\267\350\276\223\345\205\245\351\202\256\347\256\261", 0));
        label_7->setText(QApplication::translate("Register", "\346\263\250\345\206\214\346\210\220\345\212\237", 0));
        label_8->setText(QApplication::translate("Register", "\347\224\250\346\210\267\345\220\215:", 0));
        label_user_name->setText(QApplication::translate("Register", "TextLabel", 0));
        label_10->setText(QApplication::translate("Register", "\345\257\206\347\240\201:", 0));
        label_pwd->setText(QApplication::translate("Register", "TextLabel", 0));
        pushButton_close->setText(QApplication::translate("Register", "\345\205\263\351\227\255", 0));
    } // retranslateUi

};

namespace Ui {
    class Register: public Ui_Register {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_REGISTER_H
