/********************************************************************************
** Form generated from reading UI file 'userdefinetype.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_USERDEFINETYPE_H
#define UI_USERDEFINETYPE_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QDialog>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QTextEdit>
#include <QtWidgets/QToolButton>
#include <mywidgetregister.h>

QT_BEGIN_NAMESPACE

class Ui_UserDefineType
{
public:
    QGridLayout *gridLayout;
    MyWidgetRegister *widgetInner;
    QLineEdit *lineEdit;
    QTextEdit *textEdit;
    QPushButton *pushButton_sure;
    QToolButton *toolButton_close;

    void setupUi(QDialog *UserDefineType)
    {
        if (UserDefineType->objectName().isEmpty())
            UserDefineType->setObjectName(QStringLiteral("UserDefineType"));
        UserDefineType->resize(370, 304);
        gridLayout = new QGridLayout(UserDefineType);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        widgetInner = new MyWidgetRegister(UserDefineType);
        widgetInner->setObjectName(QStringLiteral("widgetInner"));
        lineEdit = new QLineEdit(widgetInner);
        lineEdit->setObjectName(QStringLiteral("lineEdit"));
        lineEdit->setGeometry(QRect(70, 40, 221, 20));
        textEdit = new QTextEdit(widgetInner);
        textEdit->setObjectName(QStringLiteral("textEdit"));
        textEdit->setGeometry(QRect(70, 80, 221, 51));
        pushButton_sure = new QPushButton(widgetInner);
        pushButton_sure->setObjectName(QStringLiteral("pushButton_sure"));
        pushButton_sure->setGeometry(QRect(140, 170, 75, 23));
        pushButton_sure->setCursor(QCursor(Qt::PointingHandCursor));
        toolButton_close = new QToolButton(widgetInner);
        toolButton_close->setObjectName(QStringLiteral("toolButton_close"));
        toolButton_close->setGeometry(QRect(320, 0, 30, 30));
        toolButton_close->setAutoRaise(true);

        gridLayout->addWidget(widgetInner, 0, 0, 1, 1);


        retranslateUi(UserDefineType);

        QMetaObject::connectSlotsByName(UserDefineType);
    } // setupUi

    void retranslateUi(QDialog *UserDefineType)
    {
        UserDefineType->setWindowTitle(QApplication::translate("UserDefineType", "Dialog", 0));
        lineEdit->setPlaceholderText(QApplication::translate("UserDefineType", "\350\257\267\350\276\223\345\205\245\350\207\252\345\256\232\344\271\211\347\232\204\347\261\273\345\236\213\345\220\215", 0));
        textEdit->setPlaceholderText(QApplication::translate("UserDefineType", "\350\257\267\350\276\223\345\205\245\345\257\271\346\255\244\350\207\252\345\256\232\344\271\211\347\261\273\345\236\213\347\232\204\346\217\217\350\277\260", 0));
        pushButton_sure->setText(QApplication::translate("UserDefineType", "\347\241\256\345\256\232", 0));
        toolButton_close->setText(QApplication::translate("UserDefineType", "\303\227", 0));
    } // retranslateUi

};

namespace Ui {
    class UserDefineType: public Ui_UserDefineType {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_USERDEFINETYPE_H
