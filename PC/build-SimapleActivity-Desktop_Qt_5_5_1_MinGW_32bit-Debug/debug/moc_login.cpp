/****************************************************************************
** Meta object code from reading C++ file 'login.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.5.1)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../SimapleActivity/login.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'login.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.5.1. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
struct qt_meta_stringdata_Login_t {
    QByteArrayData data[19];
    char stringdata0[362];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_Login_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_Login_t qt_meta_stringdata_Login = {
    {
QT_MOC_LITERAL(0, 0, 5), // "Login"
QT_MOC_LITERAL(1, 6, 4), // "isOk"
QT_MOC_LITERAL(2, 11, 0), // ""
QT_MOC_LITERAL(3, 12, 4), // "User"
QT_MOC_LITERAL(4, 17, 4), // "user"
QT_MOC_LITERAL(5, 22, 21), // "on_toolButton_clicked"
QT_MOC_LITERAL(6, 44, 27), // "on_toolButtonTonote_clicked"
QT_MOC_LITERAL(7, 72, 25), // "on_toolButtonToId_clicked"
QT_MOC_LITERAL(8, 98, 29), // "on_toolButtonRegister_clicked"
QT_MOC_LITERAL(9, 128, 27), // "on_pushButton_login_clicked"
QT_MOC_LITERAL(10, 156, 38), // "on_pushButton_login_id_and_pw..."
QT_MOC_LITERAL(11, 195, 11), // "dealGetData"
QT_MOC_LITERAL(12, 207, 14), // "QNetworkReply*"
QT_MOC_LITERAL(13, 222, 5), // "reply"
QT_MOC_LITERAL(14, 228, 23), // "on_toolButton_3_clicked"
QT_MOC_LITERAL(15, 252, 26), // "on_pushButton_sure_clicked"
QT_MOC_LITERAL(16, 279, 28), // "on_pushButton_cancel_clicked"
QT_MOC_LITERAL(17, 308, 27), // "on_toolButton_close_clicked"
QT_MOC_LITERAL(18, 336, 25) // "on_toolButton_set_clicked"

    },
    "Login\0isOk\0\0User\0user\0on_toolButton_clicked\0"
    "on_toolButtonTonote_clicked\0"
    "on_toolButtonToId_clicked\0"
    "on_toolButtonRegister_clicked\0"
    "on_pushButton_login_clicked\0"
    "on_pushButton_login_id_and_pwd_clicked\0"
    "dealGetData\0QNetworkReply*\0reply\0"
    "on_toolButton_3_clicked\0"
    "on_pushButton_sure_clicked\0"
    "on_pushButton_cancel_clicked\0"
    "on_toolButton_close_clicked\0"
    "on_toolButton_set_clicked"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_Login[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
      13,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       1,       // signalCount

 // signals: name, argc, parameters, tag, flags
       1,    1,   79,    2, 0x06 /* Public */,

 // slots: name, argc, parameters, tag, flags
       5,    0,   82,    2, 0x08 /* Private */,
       6,    0,   83,    2, 0x08 /* Private */,
       7,    0,   84,    2, 0x08 /* Private */,
       8,    0,   85,    2, 0x08 /* Private */,
       9,    0,   86,    2, 0x08 /* Private */,
      10,    0,   87,    2, 0x08 /* Private */,
      11,    1,   88,    2, 0x08 /* Private */,
      14,    0,   91,    2, 0x08 /* Private */,
      15,    0,   92,    2, 0x08 /* Private */,
      16,    0,   93,    2, 0x08 /* Private */,
      17,    0,   94,    2, 0x08 /* Private */,
      18,    0,   95,    2, 0x08 /* Private */,

 // signals: parameters
    QMetaType::Void, 0x80000000 | 3,    4,

 // slots: parameters
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void, 0x80000000 | 12,   13,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,

       0        // eod
};

void Login::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        Login *_t = static_cast<Login *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->isOk((*reinterpret_cast< User(*)>(_a[1]))); break;
        case 1: _t->on_toolButton_clicked(); break;
        case 2: _t->on_toolButtonTonote_clicked(); break;
        case 3: _t->on_toolButtonToId_clicked(); break;
        case 4: _t->on_toolButtonRegister_clicked(); break;
        case 5: _t->on_pushButton_login_clicked(); break;
        case 6: _t->on_pushButton_login_id_and_pwd_clicked(); break;
        case 7: _t->dealGetData((*reinterpret_cast< QNetworkReply*(*)>(_a[1]))); break;
        case 8: _t->on_toolButton_3_clicked(); break;
        case 9: _t->on_pushButton_sure_clicked(); break;
        case 10: _t->on_pushButton_cancel_clicked(); break;
        case 11: _t->on_toolButton_close_clicked(); break;
        case 12: _t->on_toolButton_set_clicked(); break;
        default: ;
        }
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        switch (_id) {
        default: *reinterpret_cast<int*>(_a[0]) = -1; break;
        case 7:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QNetworkReply* >(); break;
            }
            break;
        }
    } else if (_c == QMetaObject::IndexOfMethod) {
        int *result = reinterpret_cast<int *>(_a[0]);
        void **func = reinterpret_cast<void **>(_a[1]);
        {
            typedef void (Login::*_t)(User );
            if (*reinterpret_cast<_t *>(func) == static_cast<_t>(&Login::isOk)) {
                *result = 0;
            }
        }
    }
}

const QMetaObject Login::staticMetaObject = {
    { &QWidget::staticMetaObject, qt_meta_stringdata_Login.data,
      qt_meta_data_Login,  qt_static_metacall, Q_NULLPTR, Q_NULLPTR}
};


const QMetaObject *Login::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *Login::qt_metacast(const char *_clname)
{
    if (!_clname) return Q_NULLPTR;
    if (!strcmp(_clname, qt_meta_stringdata_Login.stringdata0))
        return static_cast<void*>(const_cast< Login*>(this));
    return QWidget::qt_metacast(_clname);
}

int Login::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QWidget::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 13)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 13;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 13)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 13;
    }
    return _id;
}

// SIGNAL 0
void Login::isOk(User _t1)
{
    void *_a[] = { Q_NULLPTR, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 0, _a);
}
QT_END_MOC_NAMESPACE
