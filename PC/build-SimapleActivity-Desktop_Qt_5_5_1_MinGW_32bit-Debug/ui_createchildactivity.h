/********************************************************************************
** Form generated from reading UI file 'createchildactivity.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_CREATECHILDACTIVITY_H
#define UI_CREATECHILDACTIVITY_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDoubleSpinBox>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QSpinBox>
#include <QtWidgets/QTextEdit>
#include <QtWidgets/QToolButton>
#include <mywidgetregister.h>

QT_BEGIN_NAMESPACE

class Ui_CreateChildActivity
{
public:
    QGridLayout *gridLayout;
    MyWidgetRegister *widgetInner;
    QLabel *label;
    QLineEdit *lineEdit;
    QTextEdit *textEdit;
    QLabel *label_2;
    QPushButton *pushButton_finished;
    QLabel *label_3;
    QLabel *label_4;
    QSpinBox *spinBox;
    QDoubleSpinBox *doubleSpinBox;
    QToolButton *toolButton;

    void setupUi(QDialog *CreateChildActivity)
    {
        if (CreateChildActivity->objectName().isEmpty())
            CreateChildActivity->setObjectName(QStringLiteral("CreateChildActivity"));
        CreateChildActivity->resize(435, 380);
        gridLayout = new QGridLayout(CreateChildActivity);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        widgetInner = new MyWidgetRegister(CreateChildActivity);
        widgetInner->setObjectName(QStringLiteral("widgetInner"));
        label = new QLabel(widgetInner);
        label->setObjectName(QStringLiteral("label"));
        label->setGeometry(QRect(20, 70, 100, 20));
        label->setMinimumSize(QSize(100, 20));
        label->setMaximumSize(QSize(100, 20));
        lineEdit = new QLineEdit(widgetInner);
        lineEdit->setObjectName(QStringLiteral("lineEdit"));
        lineEdit->setGeometry(QRect(140, 70, 221, 20));
        textEdit = new QTextEdit(widgetInner);
        textEdit->setObjectName(QStringLiteral("textEdit"));
        textEdit->setGeometry(QRect(140, 120, 221, 61));
        label_2 = new QLabel(widgetInner);
        label_2->setObjectName(QStringLiteral("label_2"));
        label_2->setGeometry(QRect(20, 130, 100, 20));
        label_2->setMinimumSize(QSize(100, 20));
        label_2->setMaximumSize(QSize(100, 20));
        pushButton_finished = new QPushButton(widgetInner);
        pushButton_finished->setObjectName(QStringLiteral("pushButton_finished"));
        pushButton_finished->setGeometry(QRect(120, 320, 151, 23));
        pushButton_finished->setCursor(QCursor(Qt::PointingHandCursor));
        label_3 = new QLabel(widgetInner);
        label_3->setObjectName(QStringLiteral("label_3"));
        label_3->setGeometry(QRect(20, 200, 100, 20));
        label_3->setMinimumSize(QSize(100, 20));
        label_3->setMaximumSize(QSize(100, 20));
        label_4 = new QLabel(widgetInner);
        label_4->setObjectName(QStringLiteral("label_4"));
        label_4->setGeometry(QRect(20, 270, 100, 20));
        label_4->setMinimumSize(QSize(100, 20));
        label_4->setMaximumSize(QSize(100, 20));
        spinBox = new QSpinBox(widgetInner);
        spinBox->setObjectName(QStringLiteral("spinBox"));
        spinBox->setGeometry(QRect(140, 210, 221, 22));
        doubleSpinBox = new QDoubleSpinBox(widgetInner);
        doubleSpinBox->setObjectName(QStringLiteral("doubleSpinBox"));
        doubleSpinBox->setGeometry(QRect(140, 270, 221, 22));
        toolButton = new QToolButton(widgetInner);
        toolButton->setObjectName(QStringLiteral("toolButton"));
        toolButton->setGeometry(QRect(380, 0, 30, 30));
        toolButton->setAutoRaise(true);

        gridLayout->addWidget(widgetInner, 0, 0, 1, 1);


        retranslateUi(CreateChildActivity);

        QMetaObject::connectSlotsByName(CreateChildActivity);
    } // setupUi

    void retranslateUi(QDialog *CreateChildActivity)
    {
        CreateChildActivity->setWindowTitle(QApplication::translate("CreateChildActivity", "Dialog", 0));
        label->setText(QApplication::translate("CreateChildActivity", "\345\255\220\346\264\273\345\212\250\345\220\215\347\247\260", 0));
        label_2->setText(QApplication::translate("CreateChildActivity", "\345\255\220\346\264\273\345\212\250\346\217\217\350\277\260", 0));
        pushButton_finished->setText(QApplication::translate("CreateChildActivity", "\345\256\214\346\210\220", 0));
        label_3->setText(QApplication::translate("CreateChildActivity", "\344\270\200\345\244\251\345\217\257\345\217\202\345\212\240\346\254\241\346\225\260", 0));
        label_4->setText(QApplication::translate("CreateChildActivity", "\345\215\225\346\254\241\350\256\241\345\210\206", 0));
        toolButton->setText(QApplication::translate("CreateChildActivity", "\303\227", 0));
    } // retranslateUi

};

namespace Ui {
    class CreateChildActivity: public Ui_CreateChildActivity {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_CREATECHILDACTIVITY_H
