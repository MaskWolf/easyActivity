/********************************************************************************
** Form generated from reading UI file 'userdefinetypeshow.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_USERDEFINETYPESHOW_H
#define UI_USERDEFINETYPESHOW_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_UserDefineTypeShow
{
public:
    QGridLayout *gridLayout;
    QWidget *widget;
    QVBoxLayout *verticalLayout;
    QLabel *label;
    QLabel *label_2;

    void setupUi(QWidget *UserDefineTypeShow)
    {
        if (UserDefineTypeShow->objectName().isEmpty())
            UserDefineTypeShow->setObjectName(QStringLiteral("UserDefineTypeShow"));
        UserDefineTypeShow->resize(584, 138);
        gridLayout = new QGridLayout(UserDefineTypeShow);
        gridLayout->setSpacing(0);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        gridLayout->setContentsMargins(0, 0, 0, 0);
        widget = new QWidget(UserDefineTypeShow);
        widget->setObjectName(QStringLiteral("widget"));
        verticalLayout = new QVBoxLayout(widget);
        verticalLayout->setSpacing(0);
        verticalLayout->setObjectName(QStringLiteral("verticalLayout"));
        verticalLayout->setContentsMargins(0, 0, 0, 0);
        label = new QLabel(widget);
        label->setObjectName(QStringLiteral("label"));
        label->setMinimumSize(QSize(0, 0));
        label->setMaximumSize(QSize(16777215, 40));
        QFont font;
        font.setPointSize(10);
        font.setBold(true);
        font.setWeight(75);
        label->setFont(font);

        verticalLayout->addWidget(label);

        label_2 = new QLabel(widget);
        label_2->setObjectName(QStringLiteral("label_2"));
        label_2->setMinimumSize(QSize(0, 0));
        label_2->setMaximumSize(QSize(16777215, 80));

        verticalLayout->addWidget(label_2);


        gridLayout->addWidget(widget, 0, 0, 1, 1);


        retranslateUi(UserDefineTypeShow);

        QMetaObject::connectSlotsByName(UserDefineTypeShow);
    } // setupUi

    void retranslateUi(QWidget *UserDefineTypeShow)
    {
        UserDefineTypeShow->setWindowTitle(QApplication::translate("UserDefineTypeShow", "Form", 0));
        label->setText(QApplication::translate("UserDefineTypeShow", "\350\207\252\345\256\232\344\271\211\347\261\273\345\236\213", 0));
        label_2->setText(QApplication::translate("UserDefineTypeShow", "\350\207\252\345\256\232\344\271\211\346\217\217\350\277\260", 0));
    } // retranslateUi

};

namespace Ui {
    class UserDefineTypeShow: public Ui_UserDefineTypeShow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_USERDEFINETYPESHOW_H
