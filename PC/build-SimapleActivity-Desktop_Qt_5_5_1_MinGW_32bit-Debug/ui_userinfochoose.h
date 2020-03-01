/********************************************************************************
** Form generated from reading UI file 'userinfochoose.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_USERINFOCHOOSE_H
#define UI_USERINFOCHOOSE_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QWidget>
#include <mywidgetregister.h>

QT_BEGIN_NAMESPACE

class Ui_UserInfoChoose
{
public:
    MyWidgetRegister *widget;
    QLabel *labelHead;
    QLabel *labelNickname;
    QWidget *widget_2;
    QGridLayout *gridLayout;
    QLabel *label_3;
    QLabel *labelJoinNum;
    QWidget *widget_3;
    QGridLayout *gridLayout_2;
    QLabel *label_4;
    QLabel *labelCreated;
    QLabel *label_7;
    QWidget *widget_4;
    QWidget *widget_6;
    QPushButton *pushButton_2;
    QWidget *widget_7;
    QPushButton *pushButton_3;
    QWidget *widget_5;
    QPushButton *pushButton;

    void setupUi(QWidget *UserInfoChoose)
    {
        if (UserInfoChoose->objectName().isEmpty())
            UserInfoChoose->setObjectName(QStringLiteral("UserInfoChoose"));
        UserInfoChoose->resize(284, 374);
        UserInfoChoose->setMinimumSize(QSize(284, 374));
        UserInfoChoose->setMaximumSize(QSize(284, 374));
        widget = new MyWidgetRegister(UserInfoChoose);
        widget->setObjectName(QStringLiteral("widget"));
        widget->setGeometry(QRect(4, 4, 276, 364));
        widget->setMinimumSize(QSize(276, 364));
        widget->setMaximumSize(QSize(276, 364));
        labelHead = new QLabel(widget);
        labelHead->setObjectName(QStringLiteral("labelHead"));
        labelHead->setGeometry(QRect(20, 20, 51, 51));
        labelNickname = new QLabel(widget);
        labelNickname->setObjectName(QStringLiteral("labelNickname"));
        labelNickname->setGeometry(QRect(100, 32, 81, 20));
        widget_2 = new QWidget(widget);
        widget_2->setObjectName(QStringLiteral("widget_2"));
        widget_2->setGeometry(QRect(0, 70, 134, 60));
        QSizePolicy sizePolicy(QSizePolicy::Preferred, QSizePolicy::Preferred);
        sizePolicy.setHorizontalStretch(134);
        sizePolicy.setVerticalStretch(60);
        sizePolicy.setHeightForWidth(widget_2->sizePolicy().hasHeightForWidth());
        widget_2->setSizePolicy(sizePolicy);
        widget_2->setMinimumSize(QSize(134, 60));
        widget_2->setMaximumSize(QSize(134, 60));
        gridLayout = new QGridLayout(widget_2);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        label_3 = new QLabel(widget_2);
        label_3->setObjectName(QStringLiteral("label_3"));
        label_3->setAlignment(Qt::AlignCenter);

        gridLayout->addWidget(label_3, 0, 0, 1, 1);

        labelJoinNum = new QLabel(widget_2);
        labelJoinNum->setObjectName(QStringLiteral("labelJoinNum"));
        QFont font;
        font.setBold(true);
        font.setWeight(75);
        labelJoinNum->setFont(font);
        labelJoinNum->setAlignment(Qt::AlignCenter);

        gridLayout->addWidget(labelJoinNum, 1, 0, 1, 1);

        widget_3 = new QWidget(widget);
        widget_3->setObjectName(QStringLiteral("widget_3"));
        widget_3->setGeometry(QRect(140, 70, 134, 60));
        widget_3->setMinimumSize(QSize(134, 60));
        widget_3->setMaximumSize(QSize(134, 60));
        gridLayout_2 = new QGridLayout(widget_3);
        gridLayout_2->setObjectName(QStringLiteral("gridLayout_2"));
        label_4 = new QLabel(widget_3);
        label_4->setObjectName(QStringLiteral("label_4"));
        label_4->setAlignment(Qt::AlignCenter);

        gridLayout_2->addWidget(label_4, 0, 0, 1, 1);

        labelCreated = new QLabel(widget_3);
        labelCreated->setObjectName(QStringLiteral("labelCreated"));
        labelCreated->setFont(font);
        labelCreated->setAlignment(Qt::AlignCenter);

        gridLayout_2->addWidget(labelCreated, 1, 0, 1, 1);

        label_7 = new QLabel(widget);
        label_7->setObjectName(QStringLiteral("label_7"));
        label_7->setGeometry(QRect(0, 130, 281, 10));
        widget_4 = new QWidget(widget);
        widget_4->setObjectName(QStringLiteral("widget_4"));
        widget_4->setGeometry(QRect(0, 140, 276, 221));
        widget_6 = new QWidget(widget_4);
        widget_6->setObjectName(QStringLiteral("widget_6"));
        widget_6->setGeometry(QRect(0, 70, 276, 74));
        pushButton_2 = new QPushButton(widget_6);
        pushButton_2->setObjectName(QStringLiteral("pushButton_2"));
        pushButton_2->setGeometry(QRect(-6, 4, 291, 71));
        pushButton_2->setCursor(QCursor(Qt::PointingHandCursor));
        pushButton_2->setStyleSheet(QLatin1String("text-align:left;\n"
"padding-left:20px;"));
        QIcon icon;
        icon.addFile(QStringLiteral(":/Login/C:/Users/ASUS/Pictures/Image/yyy.jpg"), QSize(), QIcon::Normal, QIcon::Off);
        pushButton_2->setIcon(icon);
        pushButton_2->setIconSize(QSize(30, 30));
        widget_7 = new QWidget(widget_4);
        widget_7->setObjectName(QStringLiteral("widget_7"));
        widget_7->setGeometry(QRect(0, 147, 276, 74));
        pushButton_3 = new QPushButton(widget_7);
        pushButton_3->setObjectName(QStringLiteral("pushButton_3"));
        pushButton_3->setGeometry(QRect(-6, 2, 291, 71));
        pushButton_3->setCursor(QCursor(Qt::PointingHandCursor));
        pushButton_3->setLayoutDirection(Qt::LeftToRight);
        pushButton_3->setStyleSheet(QLatin1String("text-align:left;\n"
"padding-left:20px;"));
        pushButton_3->setIcon(icon);
        pushButton_3->setIconSize(QSize(30, 30));
        widget_5 = new QWidget(widget_4);
        widget_5->setObjectName(QStringLiteral("widget_5"));
        widget_5->setGeometry(QRect(0, 0, 276, 74));
        widget_5->setAutoFillBackground(false);
        widget_5->setStyleSheet(QStringLiteral(""));
        pushButton = new QPushButton(widget_5);
        pushButton->setObjectName(QStringLiteral("pushButton"));
        pushButton->setGeometry(QRect(-6, -8, 291, 81));
        pushButton->setCursor(QCursor(Qt::PointingHandCursor));
        pushButton->setStyleSheet(QLatin1String("text-align:left;\n"
"padding-left:20px;"));
        pushButton->setIcon(icon);
        pushButton->setIconSize(QSize(30, 30));

        retranslateUi(UserInfoChoose);

        QMetaObject::connectSlotsByName(UserInfoChoose);
    } // setupUi

    void retranslateUi(QWidget *UserInfoChoose)
    {
        UserInfoChoose->setWindowTitle(QApplication::translate("UserInfoChoose", "Form", 0));
        labelHead->setText(QApplication::translate("UserInfoChoose", "\345\244\264\345\203\217", 0));
        labelNickname->setText(QApplication::translate("UserInfoChoose", "\346\230\265\347\247\260", 0));
        label_3->setText(QApplication::translate("UserInfoChoose", "\345\267\262\345\217\202\345\212\240", 0));
        labelJoinNum->setText(QApplication::translate("UserInfoChoose", "0", 0));
        label_4->setText(QApplication::translate("UserInfoChoose", "\345\267\262\345\210\233\345\273\272", 0));
        labelCreated->setText(QApplication::translate("UserInfoChoose", "0", 0));
        label_7->setText(QApplication::translate("UserInfoChoose", "----------------------------------------------", 0));
        pushButton_2->setText(QApplication::translate("UserInfoChoose", "\347\273\221\345\256\232\347\244\276\344\272\244\350\264\246\345\217\267", 0));
        pushButton_3->setText(QApplication::translate("UserInfoChoose", "\351\200\200\345\207\272\347\231\273\345\275\225", 0));
        pushButton->setText(QApplication::translate("UserInfoChoose", "\344\270\252\344\272\272\344\277\241\346\201\257\350\256\276\347\275\256", 0));
    } // retranslateUi

};

namespace Ui {
    class UserInfoChoose: public Ui_UserInfoChoose {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_USERINFOCHOOSE_H
