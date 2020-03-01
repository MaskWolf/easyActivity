/********************************************************************************
** Form generated from reading UI file 'outerwidget.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_OUTERWIDGET_H
#define UI_OUTERWIDGET_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_OuterWidget
{
public:

    void setupUi(QWidget *OuterWidget)
    {
        if (OuterWidget->objectName().isEmpty())
            OuterWidget->setObjectName(QStringLiteral("OuterWidget"));
        OuterWidget->resize(400, 300);

        retranslateUi(OuterWidget);

        QMetaObject::connectSlotsByName(OuterWidget);
    } // setupUi

    void retranslateUi(QWidget *OuterWidget)
    {
        OuterWidget->setWindowTitle(QApplication::translate("OuterWidget", "Form", 0));
    } // retranslateUi

};

namespace Ui {
    class OuterWidget: public Ui_OuterWidget {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_OUTERWIDGET_H
