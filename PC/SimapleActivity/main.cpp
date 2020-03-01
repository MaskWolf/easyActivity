#include "mainwidget.h"
#include <QApplication>
#include "login.h"
#include "createdynamic.h"
#include "showmessage.h"

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    MainWidget w;

    return a.exec();
}
