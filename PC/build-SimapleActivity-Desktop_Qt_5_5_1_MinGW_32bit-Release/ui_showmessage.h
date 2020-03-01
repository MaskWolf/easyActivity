/********************************************************************************
** Form generated from reading UI file 'showmessage.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_SHOWMESSAGE_H
#define UI_SHOWMESSAGE_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QDialog>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_ShowMessage
{
public:
    QGridLayout *gridLayout;
    QWidget *widget;
    QGridLayout *gridLayout_2;
    QLabel *label;

    void setupUi(QDialog *ShowMessage)
    {
        if (ShowMessage->objectName().isEmpty())
            ShowMessage->setObjectName(QStringLiteral("ShowMessage"));
        ShowMessage->resize(231, 111);
        gridLayout = new QGridLayout(ShowMessage);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        widget = new QWidget(ShowMessage);
        widget->setObjectName(QStringLiteral("widget"));
        gridLayout_2 = new QGridLayout(widget);
        gridLayout_2->setSpacing(0);
        gridLayout_2->setObjectName(QStringLiteral("gridLayout_2"));
        gridLayout_2->setContentsMargins(0, 0, 0, 0);
        label = new QLabel(widget);
        label->setObjectName(QStringLiteral("label"));
        QFont font;
        font.setPointSize(16);
        label->setFont(font);
        label->setAlignment(Qt::AlignCenter);

        gridLayout_2->addWidget(label, 0, 0, 1, 1);


        gridLayout->addWidget(widget, 0, 0, 1, 1);


        retranslateUi(ShowMessage);

        QMetaObject::connectSlotsByName(ShowMessage);
    } // setupUi

    void retranslateUi(QDialog *ShowMessage)
    {
        ShowMessage->setWindowTitle(QApplication::translate("ShowMessage", "Dialog", 0));
        label->setText(QApplication::translate("ShowMessage", "TextLabel", 0));
    } // retranslateUi

};

namespace Ui {
    class ShowMessage: public Ui_ShowMessage {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_SHOWMESSAGE_H
