/********************************************************************************
** Form generated from reading UI file 'signupitem.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_SIGNUPITEM_H
#define UI_SIGNUPITEM_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_SignUpItem
{
public:
    QGridLayout *gridLayout;
    QWidget *widget;
    QHBoxLayout *horizontalLayout;
    QLabel *label;
    QLineEdit *lineEdit;

    void setupUi(QWidget *SignUpItem)
    {
        if (SignUpItem->objectName().isEmpty())
            SignUpItem->setObjectName(QStringLiteral("SignUpItem"));
        SignUpItem->resize(672, 54);
        gridLayout = new QGridLayout(SignUpItem);
        gridLayout->setSpacing(0);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        gridLayout->setContentsMargins(0, 0, 0, 0);
        widget = new QWidget(SignUpItem);
        widget->setObjectName(QStringLiteral("widget"));
        horizontalLayout = new QHBoxLayout(widget);
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        label = new QLabel(widget);
        label->setObjectName(QStringLiteral("label"));
        QFont font;
        font.setFamily(QString::fromUtf8("\346\245\267\344\275\223"));
        font.setPointSize(12);
        label->setFont(font);

        horizontalLayout->addWidget(label);

        lineEdit = new QLineEdit(widget);
        lineEdit->setObjectName(QStringLiteral("lineEdit"));
        lineEdit->setMinimumSize(QSize(0, 30));
        QFont font1;
        font1.setPointSize(12);
        lineEdit->setFont(font1);

        horizontalLayout->addWidget(lineEdit);


        gridLayout->addWidget(widget, 0, 0, 1, 1);


        retranslateUi(SignUpItem);

        QMetaObject::connectSlotsByName(SignUpItem);
    } // setupUi

    void retranslateUi(QWidget *SignUpItem)
    {
        SignUpItem->setWindowTitle(QApplication::translate("SignUpItem", "Form", 0));
        label->setText(QApplication::translate("SignUpItem", "TextLabel", 0));
        lineEdit->setPlaceholderText(QApplication::translate("SignUpItem", "\350\257\267\350\276\223\345\205\245\347\202\271\344\270\234\350\245\277", 0));
    } // retranslateUi

};

namespace Ui {
    class SignUpItem: public Ui_SignUpItem {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_SIGNUPITEM_H
