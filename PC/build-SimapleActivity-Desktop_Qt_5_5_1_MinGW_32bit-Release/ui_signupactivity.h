/********************************************************************************
** Form generated from reading UI file 'signupactivity.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_SIGNUPACTIVITY_H
#define UI_SIGNUPACTIVITY_H

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
#include <QtWidgets/QToolButton>
#include <QtWidgets/QWidget>
#include <mywidgetregister.h>

QT_BEGIN_NAMESPACE

class Ui_SignUpActivity
{
public:
    QGridLayout *gridLayout;
    MyWidgetRegister *widget;
    QPushButton *pushButton_post;
    QListWidget *listWidget_data;
    QWidget *widget_sign_up_nav;
    QHBoxLayout *horizontalLayout;
    QLabel *label_name;
    QSpacerItem *horizontalSpacer;
    QToolButton *toolButton_min;
    QToolButton *toolButton_close;
    QLabel *label;
    QLabel *label_2;
    QListWidget *listWidget_child_data;

    void setupUi(QWidget *SignUpActivity)
    {
        if (SignUpActivity->objectName().isEmpty())
            SignUpActivity->setObjectName(QStringLiteral("SignUpActivity"));
        SignUpActivity->resize(977, 545);
        gridLayout = new QGridLayout(SignUpActivity);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        gridLayout->setContentsMargins(-1, 0, -1, -1);
        widget = new MyWidgetRegister(SignUpActivity);
        widget->setObjectName(QStringLiteral("widget"));
        widget->setMinimumSize(QSize(0, 40));
        pushButton_post = new QPushButton(widget);
        pushButton_post->setObjectName(QStringLiteral("pushButton_post"));
        pushButton_post->setGeometry(QRect(370, 490, 300, 30));
        pushButton_post->setMinimumSize(QSize(300, 30));
        pushButton_post->setCursor(QCursor(Qt::PointingHandCursor));
        listWidget_data = new QListWidget(widget);
        listWidget_data->setObjectName(QStringLiteral("listWidget_data"));
        listWidget_data->setGeometry(QRect(10, 110, 531, 361));
        listWidget_data->setMinimumSize(QSize(0, 321));
        listWidget_data->setSpacing(10);
        widget_sign_up_nav = new QWidget(widget);
        widget_sign_up_nav->setObjectName(QStringLiteral("widget_sign_up_nav"));
        widget_sign_up_nav->setGeometry(QRect(0, 0, 959, 41));
        horizontalLayout = new QHBoxLayout(widget_sign_up_nav);
        horizontalLayout->setSpacing(0);
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        horizontalLayout->setContentsMargins(9, 0, 9, 0);
        label_name = new QLabel(widget_sign_up_nav);
        label_name->setObjectName(QStringLiteral("label_name"));
        QFont font;
        font.setFamily(QString::fromUtf8("\351\232\266\344\271\246"));
        font.setPointSize(16);
        label_name->setFont(font);

        horizontalLayout->addWidget(label_name);

        horizontalSpacer = new QSpacerItem(789, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout->addItem(horizontalSpacer);

        toolButton_min = new QToolButton(widget_sign_up_nav);
        toolButton_min->setObjectName(QStringLiteral("toolButton_min"));
        toolButton_min->setMinimumSize(QSize(30, 30));
        toolButton_min->setAutoRaise(true);

        horizontalLayout->addWidget(toolButton_min);

        toolButton_close = new QToolButton(widget_sign_up_nav);
        toolButton_close->setObjectName(QStringLiteral("toolButton_close"));
        toolButton_close->setMinimumSize(QSize(30, 30));
        QIcon icon;
        icon.addFile(QStringLiteral(":/Login/C:/Users/ASUS/Pictures/Login/wkf.png"), QSize(), QIcon::Normal, QIcon::Off);
        toolButton_close->setIcon(icon);
        toolButton_close->setAutoRaise(true);

        horizontalLayout->addWidget(toolButton_close);

        label = new QLabel(widget);
        label->setObjectName(QStringLiteral("label"));
        label->setGeometry(QRect(30, 80, 331, 16));
        QFont font1;
        font1.setFamily(QString::fromUtf8("\346\245\267\344\275\223"));
        font1.setPointSize(16);
        label->setFont(font1);
        label_2 = new QLabel(widget);
        label_2->setObjectName(QStringLiteral("label_2"));
        label_2->setGeometry(QRect(620, 90, 291, 16));
        label_2->setFont(font1);
        listWidget_child_data = new QListWidget(widget);
        listWidget_child_data->setObjectName(QStringLiteral("listWidget_child_data"));
        listWidget_child_data->setGeometry(QRect(620, 110, 321, 361));
        listWidget_child_data->setSpacing(10);

        gridLayout->addWidget(widget, 0, 0, 1, 1);


        retranslateUi(SignUpActivity);

        QMetaObject::connectSlotsByName(SignUpActivity);
    } // setupUi

    void retranslateUi(QWidget *SignUpActivity)
    {
        SignUpActivity->setWindowTitle(QApplication::translate("SignUpActivity", "Form", 0));
        pushButton_post->setText(QApplication::translate("SignUpActivity", "\346\217\220\344\272\244", 0));
        label_name->setText(QApplication::translate("SignUpActivity", "\346\264\273\345\212\250\346\212\245\345\220\215", 0));
        toolButton_min->setText(QApplication::translate("SignUpActivity", "--", 0));
        toolButton_close->setText(QApplication::translate("SignUpActivity", "...", 0));
        label->setText(QApplication::translate("SignUpActivity", "\350\257\267\350\276\223\345\205\245\344\270\213\351\235\242\347\232\204\346\212\245\345\220\215\344\277\241\346\201\257", 0));
        label_2->setText(QApplication::translate("SignUpActivity", "\350\257\267\351\200\211\346\213\251\346\203\263\350\246\201\345\217\202\345\212\240\347\232\204\345\205\267\344\275\223\351\241\271\347\233\256", 0));
    } // retranslateUi

};

namespace Ui {
    class SignUpActivity: public Ui_SignUpActivity {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_SIGNUPACTIVITY_H
