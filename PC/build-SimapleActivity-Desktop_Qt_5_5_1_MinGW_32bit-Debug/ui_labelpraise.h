/********************************************************************************
** Form generated from reading UI file 'labelpraise.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_LABELPRAISE_H
#define UI_LABELPRAISE_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_LabelPraise
{
public:

    void setupUi(QWidget *LabelPraise)
    {
        if (LabelPraise->objectName().isEmpty())
            LabelPraise->setObjectName(QStringLiteral("LabelPraise"));
        LabelPraise->resize(400, 300);

        retranslateUi(LabelPraise);

        QMetaObject::connectSlotsByName(LabelPraise);
    } // setupUi

    void retranslateUi(QWidget *LabelPraise)
    {
        LabelPraise->setWindowTitle(QApplication::translate("LabelPraise", "Form", 0));
    } // retranslateUi

};

namespace Ui {
    class LabelPraise: public Ui_LabelPraise {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_LABELPRAISE_H
