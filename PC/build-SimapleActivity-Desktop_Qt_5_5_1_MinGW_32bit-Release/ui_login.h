/********************************************************************************
** Form generated from reading UI file 'login.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_LOGIN_H
#define UI_LOGIN_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QCheckBox>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QStackedWidget>
#include <QtWidgets/QToolButton>
#include <QtWidgets/QWidget>
#include <mywidgetregister.h>
#include "mycombobox.h"
#include "mylineedit.h"

QT_BEGIN_NAMESPACE

class Ui_Login
{
public:
    MyWidgetRegister *LoginInner;
    QWidget *LoginContent;
    QStackedWidget *stackedWidget;
    QWidget *page;
    QStackedWidget *stackedWidgetLeft;
    QWidget *pageId;
    QLabel *label_2;
    QToolButton *toolButtonTonote;
    QCheckBox *checkBox;
    QCheckBox *checkBox_2;
    QToolButton *toolButton_5;
    QPushButton *pushButton_login_id_and_pwd;
    QWidget *widgetId;
    QHBoxLayout *horizontalLayout_2;
    QLabel *label_id;
    MyComboBox *comboBox_id;
    QWidget *widgetPwd;
    QHBoxLayout *horizontalLayout;
    QLabel *label_pwd;
    MyLineEdit *lineEdit_password;
    QWidget *pageShortMsg;
    QLabel *label_9;
    QToolButton *toolButtonToId;
    QWidget *widget;
    QLineEdit *lineEdit_2;
    QLabel *label_11;
    QWidget *widget_2;
    QLineEdit *lineEdit_3;
    QToolButton *toolButton_11;
    QLabel *label_12;
    QPushButton *pushButton_login;
    QWidget *widgetRight;
    QLabel *label_3;
    QLabel *label_double_code;
    QLabel *label_6;
    QLabel *label_8;
    QToolButton *toolButton_9;
    QToolButton *toolButtonRegister;
    QWidget *page_2;
    QLabel *label;
    QLabel *label_4;
    QLineEdit *lineEdit_url;
    QPushButton *pushButton_sure;
    QPushButton *pushButton_cancel;
    QLabel *label_head;
    QToolButton *toolButton_close;
    QToolButton *toolButton_min;
    QToolButton *toolButton_set;

    void setupUi(QWidget *Login)
    {
        if (Login->objectName().isEmpty())
            Login->setObjectName(QStringLiteral("Login"));
        Login->resize(670, 452);
        QSizePolicy sizePolicy(QSizePolicy::Preferred, QSizePolicy::Preferred);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(0);
        sizePolicy.setHeightForWidth(Login->sizePolicy().hasHeightForWidth());
        Login->setSizePolicy(sizePolicy);
        Login->setMinimumSize(QSize(670, 451));
        Login->setMaximumSize(QSize(16777215, 16777215));
        LoginInner = new MyWidgetRegister(Login);
        LoginInner->setObjectName(QStringLiteral("LoginInner"));
        LoginInner->setGeometry(QRect(2, 2, 662, 442));
        LoginInner->setMinimumSize(QSize(662, 442));
        LoginInner->setMaximumSize(QSize(662, 442));
        LoginContent = new QWidget(LoginInner);
        LoginContent->setObjectName(QStringLiteral("LoginContent"));
        LoginContent->setGeometry(QRect(0, 75, 662, 367));
        sizePolicy.setHeightForWidth(LoginContent->sizePolicy().hasHeightForWidth());
        LoginContent->setSizePolicy(sizePolicy);
        LoginContent->setMinimumSize(QSize(662, 367));
        LoginContent->setMaximumSize(QSize(662, 367));
        stackedWidget = new QStackedWidget(LoginContent);
        stackedWidget->setObjectName(QStringLiteral("stackedWidget"));
        stackedWidget->setGeometry(QRect(0, 0, 662, 367));
        page = new QWidget();
        page->setObjectName(QStringLiteral("page"));
        stackedWidgetLeft = new QStackedWidget(page);
        stackedWidgetLeft->setObjectName(QStringLiteral("stackedWidgetLeft"));
        stackedWidgetLeft->setGeometry(QRect(0, 0, 381, 321));
        pageId = new QWidget();
        pageId->setObjectName(QStringLiteral("pageId"));
        label_2 = new QLabel(pageId);
        label_2->setObjectName(QStringLiteral("label_2"));
        label_2->setGeometry(QRect(30, 20, 131, 31));
        QFont font;
        font.setPointSize(12);
        label_2->setFont(font);
        toolButtonTonote = new QToolButton(pageId);
        toolButtonTonote->setObjectName(QStringLiteral("toolButtonTonote"));
        toolButtonTonote->setEnabled(false);
        toolButtonTonote->setGeometry(QRect(210, 30, 141, 18));
        QFont font1;
        font1.setPointSize(10);
        font1.setUnderline(true);
        toolButtonTonote->setFont(font1);
        toolButtonTonote->setAutoRaise(true);
        checkBox = new QCheckBox(pageId);
        checkBox->setObjectName(QStringLiteral("checkBox"));
        checkBox->setGeometry(QRect(30, 210, 71, 16));
        checkBox_2 = new QCheckBox(pageId);
        checkBox_2->setObjectName(QStringLiteral("checkBox_2"));
        checkBox_2->setGeometry(QRect(120, 210, 71, 16));
        toolButton_5 = new QToolButton(pageId);
        toolButton_5->setObjectName(QStringLiteral("toolButton_5"));
        toolButton_5->setGeometry(QRect(250, 210, 71, 20));
        toolButton_5->setAutoRaise(true);
        pushButton_login_id_and_pwd = new QPushButton(pageId);
        pushButton_login_id_and_pwd->setObjectName(QStringLiteral("pushButton_login_id_and_pwd"));
        pushButton_login_id_and_pwd->setGeometry(QRect(30, 260, 291, 40));
        pushButton_login_id_and_pwd->setCursor(QCursor(Qt::PointingHandCursor));
        widgetId = new QWidget(pageId);
        widgetId->setObjectName(QStringLiteral("widgetId"));
        widgetId->setGeometry(QRect(30, 70, 291, 41));
        horizontalLayout_2 = new QHBoxLayout(widgetId);
        horizontalLayout_2->setSpacing(0);
        horizontalLayout_2->setObjectName(QStringLiteral("horizontalLayout_2"));
        horizontalLayout_2->setContentsMargins(-1, -1, -1, 0);
        label_id = new QLabel(widgetId);
        label_id->setObjectName(QStringLiteral("label_id"));
        label_id->setMinimumSize(QSize(30, 30));
        label_id->setMaximumSize(QSize(30, 30));
        label_id->setPixmap(QPixmap(QString::fromUtf8(":/Login/C:/Users/ASUS/Pictures/Login/human-1-fill-gray.png")));

        horizontalLayout_2->addWidget(label_id);

        comboBox_id = new MyComboBox(widgetId);
        comboBox_id->setObjectName(QStringLiteral("comboBox_id"));
        comboBox_id->setMinimumSize(QSize(0, 30));
        comboBox_id->setMaximumSize(QSize(16777215, 30));
        comboBox_id->setEditable(true);
        comboBox_id->setMaxVisibleItems(4);
        comboBox_id->setIconSize(QSize(16, 16));

        horizontalLayout_2->addWidget(comboBox_id);

        widgetPwd = new QWidget(pageId);
        widgetPwd->setObjectName(QStringLiteral("widgetPwd"));
        widgetPwd->setGeometry(QRect(30, 130, 291, 41));
        horizontalLayout = new QHBoxLayout(widgetPwd);
        horizontalLayout->setSpacing(0);
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        horizontalLayout->setContentsMargins(9, 9, -1, 0);
        label_pwd = new QLabel(widgetPwd);
        label_pwd->setObjectName(QStringLiteral("label_pwd"));
        label_pwd->setMinimumSize(QSize(30, 30));
        label_pwd->setMaximumSize(QSize(30, 30));
        label_pwd->setPixmap(QPixmap(QString::fromUtf8(":/Login/C:/Users/ASUS/Pictures/Login/lock.png")));

        horizontalLayout->addWidget(label_pwd);

        lineEdit_password = new MyLineEdit(widgetPwd);
        lineEdit_password->setObjectName(QStringLiteral("lineEdit_password"));
        lineEdit_password->setMinimumSize(QSize(0, 30));
        lineEdit_password->setMaximumSize(QSize(16777215, 30));
        lineEdit_password->setAlignment(Qt::AlignLeading|Qt::AlignLeft|Qt::AlignVCenter);

        horizontalLayout->addWidget(lineEdit_password);

        stackedWidgetLeft->addWidget(pageId);
        pageShortMsg = new QWidget();
        pageShortMsg->setObjectName(QStringLiteral("pageShortMsg"));
        label_9 = new QLabel(pageShortMsg);
        label_9->setObjectName(QStringLiteral("label_9"));
        label_9->setGeometry(QRect(40, 40, 91, 16));
        toolButtonToId = new QToolButton(pageShortMsg);
        toolButtonToId->setObjectName(QStringLiteral("toolButtonToId"));
        toolButtonToId->setGeometry(QRect(250, 40, 101, 18));
        QFont font2;
        font2.setUnderline(true);
        toolButtonToId->setFont(font2);
        toolButtonToId->setAutoRaise(true);
        widget = new QWidget(pageShortMsg);
        widget->setObjectName(QStringLiteral("widget"));
        widget->setGeometry(QRect(40, 90, 290, 40));
        lineEdit_2 = new QLineEdit(widget);
        lineEdit_2->setObjectName(QStringLiteral("lineEdit_2"));
        lineEdit_2->setGeometry(QRect(40, 5, 241, 30));
        label_11 = new QLabel(widget);
        label_11->setObjectName(QStringLiteral("label_11"));
        label_11->setGeometry(QRect(5, 5, 30, 30));
        widget_2 = new QWidget(pageShortMsg);
        widget_2->setObjectName(QStringLiteral("widget_2"));
        widget_2->setGeometry(QRect(40, 150, 290, 40));
        lineEdit_3 = new QLineEdit(widget_2);
        lineEdit_3->setObjectName(QStringLiteral("lineEdit_3"));
        lineEdit_3->setGeometry(QRect(42, 5, 101, 30));
        toolButton_11 = new QToolButton(widget_2);
        toolButton_11->setObjectName(QStringLiteral("toolButton_11"));
        toolButton_11->setGeometry(QRect(160, 5, 121, 30));
        label_12 = new QLabel(widget_2);
        label_12->setObjectName(QStringLiteral("label_12"));
        label_12->setGeometry(QRect(5, 5, 30, 30));
        pushButton_login = new QPushButton(pageShortMsg);
        pushButton_login->setObjectName(QStringLiteral("pushButton_login"));
        pushButton_login->setGeometry(QRect(40, 240, 290, 40));
        stackedWidgetLeft->addWidget(pageShortMsg);
        widgetRight = new QWidget(page);
        widgetRight->setObjectName(QStringLiteral("widgetRight"));
        widgetRight->setEnabled(true);
        widgetRight->setGeometry(QRect(380, 0, 281, 361));
        label_3 = new QLabel(widgetRight);
        label_3->setObjectName(QStringLiteral("label_3"));
        label_3->setGeometry(QRect(100, 30, 151, 20));
        label_double_code = new QLabel(widgetRight);
        label_double_code->setObjectName(QStringLiteral("label_double_code"));
        label_double_code->setGeometry(QRect(70, 140, 154, 154));
        label_double_code->setPixmap(QPixmap(QString::fromUtf8(":/Login/C:/Users/ASUS/Pictures/Login/code.png")));
        label_6 = new QLabel(widgetRight);
        label_6->setObjectName(QStringLiteral("label_6"));
        label_6->setGeometry(QRect(50, 90, 54, 12));
        label_8 = new QLabel(widgetRight);
        label_8->setObjectName(QStringLiteral("label_8"));
        label_8->setGeometry(QRect(180, 90, 54, 12));
        toolButton_9 = new QToolButton(widgetRight);
        toolButton_9->setObjectName(QStringLiteral("toolButton_9"));
        toolButton_9->setGeometry(QRect(100, 88, 71, 18));
        toolButton_9->setAutoRaise(true);
        toolButtonRegister = new QToolButton(page);
        toolButtonRegister->setObjectName(QStringLiteral("toolButtonRegister"));
        toolButtonRegister->setGeometry(QRect(30, 320, 61, 18));
        toolButtonRegister->setAutoRaise(true);
        stackedWidget->addWidget(page);
        page_2 = new QWidget();
        page_2->setObjectName(QStringLiteral("page_2"));
        label = new QLabel(page_2);
        label->setObjectName(QStringLiteral("label"));
        label->setGeometry(QRect(60, 70, 161, 16));
        label_4 = new QLabel(page_2);
        label_4->setObjectName(QStringLiteral("label_4"));
        label_4->setGeometry(QRect(60, 120, 54, 12));
        lineEdit_url = new QLineEdit(page_2);
        lineEdit_url->setObjectName(QStringLiteral("lineEdit_url"));
        lineEdit_url->setGeometry(QRect(150, 120, 371, 20));
        pushButton_sure = new QPushButton(page_2);
        pushButton_sure->setObjectName(QStringLiteral("pushButton_sure"));
        pushButton_sure->setGeometry(QRect(180, 300, 75, 23));
        pushButton_cancel = new QPushButton(page_2);
        pushButton_cancel->setObjectName(QStringLiteral("pushButton_cancel"));
        pushButton_cancel->setGeometry(QRect(350, 300, 75, 23));
        stackedWidget->addWidget(page_2);
        label_head = new QLabel(LoginInner);
        label_head->setObjectName(QStringLiteral("label_head"));
        label_head->setGeometry(QRect(266, 20, 131, 41));
        QFont font3;
        font3.setFamily(QString::fromUtf8("\346\245\267\344\275\223"));
        font3.setPointSize(24);
        label_head->setFont(font3);
        toolButton_close = new QToolButton(LoginInner);
        toolButton_close->setObjectName(QStringLiteral("toolButton_close"));
        toolButton_close->setGeometry(QRect(630, 0, 30, 30));
        toolButton_close->setMinimumSize(QSize(30, 30));
        toolButton_close->setMaximumSize(QSize(30, 30));
        toolButton_close->setAutoRaise(true);
        toolButton_min = new QToolButton(LoginInner);
        toolButton_min->setObjectName(QStringLiteral("toolButton_min"));
        toolButton_min->setGeometry(QRect(600, 0, 30, 30));
        toolButton_min->setMinimumSize(QSize(30, 30));
        toolButton_min->setMaximumSize(QSize(30, 30));
        toolButton_min->setAutoRaise(true);
        toolButton_set = new QToolButton(LoginInner);
        toolButton_set->setObjectName(QStringLiteral("toolButton_set"));
        toolButton_set->setGeometry(QRect(570, 0, 30, 30));
        toolButton_set->setMinimumSize(QSize(30, 30));
        toolButton_set->setMaximumSize(QSize(30, 30));
        QIcon icon;
        icon.addFile(QStringLiteral(":/Login/C:/Users/ASUS/Pictures/Login/set2.png"), QSize(), QIcon::Normal, QIcon::Off);
        toolButton_set->setIcon(icon);
        toolButton_set->setAutoRaise(true);

        retranslateUi(Login);

        stackedWidget->setCurrentIndex(0);
        stackedWidgetLeft->setCurrentIndex(0);


        QMetaObject::connectSlotsByName(Login);
    } // setupUi

    void retranslateUi(QWidget *Login)
    {
        Login->setWindowTitle(QApplication::translate("Login", "Form", 0));
        label_2->setText(QApplication::translate("Login", "\350\264\246\345\217\267\345\257\206\347\240\201\347\231\273\345\275\225", 0));
        toolButtonTonote->setText(QApplication::translate("Login", "\347\237\255\344\277\241\345\277\253\346\215\267\347\231\273\345\275\225", 0));
        checkBox->setText(QApplication::translate("Login", "\350\256\260\344\275\217\345\257\206\347\240\201", 0));
        checkBox_2->setText(QApplication::translate("Login", "\350\207\252\345\212\250\347\231\273\345\275\225", 0));
        toolButton_5->setText(QApplication::translate("Login", "\345\277\230\350\256\260\345\257\206\347\240\201\357\274\237", 0));
        pushButton_login_id_and_pwd->setText(QApplication::translate("Login", "\347\231\273\345\275\225", 0));
        label_id->setText(QString());
        comboBox_id->setCurrentText(QApplication::translate("Login", "zhangsan", 0));
        label_pwd->setText(QString());
        lineEdit_password->setText(QApplication::translate("Login", "123456", 0));
        label_9->setText(QApplication::translate("Login", "\347\237\255\344\277\241\345\277\253\346\215\267\347\231\273\345\275\225", 0));
        toolButtonToId->setText(QApplication::translate("Login", "\350\264\246\345\217\267\345\257\206\347\240\201\347\231\273\345\275\225", 0));
        label_11->setText(QApplication::translate("Login", "TextLabel", 0));
        toolButton_11->setText(QApplication::translate("Login", "\350\216\267\345\217\226\345\212\250\346\200\201\345\257\206\347\240\201", 0));
        label_12->setText(QApplication::translate("Login", "TextLabel", 0));
        pushButton_login->setText(QApplication::translate("Login", "\347\231\273\345\275\225", 0));
        label_3->setText(QApplication::translate("Login", "\346\211\253\344\270\200\346\211\253\347\231\273\345\275\225", 0));
        label_double_code->setText(QString());
        label_6->setText(QApplication::translate("Login", "\350\257\267\344\275\277\347\224\250", 0));
        label_8->setText(QApplication::translate("Login", "\346\211\253\347\240\201\347\231\273\345\275\225", 0));
        toolButton_9->setText(QApplication::translate("Login", "\347\256\200\302\267\346\264\273\345\212\250App", 0));
        toolButtonRegister->setText(QApplication::translate("Login", "\346\263\250\345\206\214\350\264\246\345\217\267", 0));
        label->setText(QApplication::translate("Login", "\350\277\236\346\216\245\346\234\215\345\212\241\345\231\250", 0));
        label_4->setText(QApplication::translate("Login", "\345\234\260\345\235\200\357\274\232", 0));
        lineEdit_url->setPlaceholderText(QApplication::translate("Login", "\344\276\213\357\274\210http://127.0.0.1)", 0));
        pushButton_sure->setText(QApplication::translate("Login", "\347\241\256\345\256\232", 0));
        pushButton_cancel->setText(QApplication::translate("Login", "\345\217\226\346\266\210", 0));
        label_head->setText(QApplication::translate("Login", "\347\256\200\302\267\346\264\273\345\212\250", 0));
        toolButton_close->setText(QApplication::translate("Login", "\303\227", 0));
        toolButton_min->setText(QApplication::translate("Login", "--", 0));
        toolButton_set->setText(QApplication::translate("Login", "...", 0));
    } // retranslateUi

};

namespace Ui {
    class Login: public Ui_Login {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_LOGIN_H
