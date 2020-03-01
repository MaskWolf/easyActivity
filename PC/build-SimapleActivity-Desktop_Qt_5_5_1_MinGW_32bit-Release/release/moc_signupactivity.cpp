/****************************************************************************
** Meta object code from reading C++ file 'signupactivity.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.5.1)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../SimapleActivity/signupactivity.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'signupactivity.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.5.1. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
struct qt_meta_stringdata_SignUpActivity_t {
    QByteArrayData data[6];
    char stringdata0[104];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_SignUpActivity_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_SignUpActivity_t qt_meta_stringdata_SignUpActivity = {
    {
QT_MOC_LITERAL(0, 0, 14), // "SignUpActivity"
QT_MOC_LITERAL(1, 15, 12), // "sign_up_item"
QT_MOC_LITERAL(2, 28, 0), // ""
QT_MOC_LITERAL(3, 29, 19), // "child_activity_item"
QT_MOC_LITERAL(4, 49, 27), // "on_toolButton_close_clicked"
QT_MOC_LITERAL(5, 77, 26) // "on_pushButton_post_clicked"

    },
    "SignUpActivity\0sign_up_item\0\0"
    "child_activity_item\0on_toolButton_close_clicked\0"
    "on_pushButton_post_clicked"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_SignUpActivity[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
       4,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       2,       // signalCount

 // signals: name, argc, parameters, tag, flags
       1,    0,   34,    2, 0x06 /* Public */,
       3,    0,   35,    2, 0x06 /* Public */,

 // slots: name, argc, parameters, tag, flags
       4,    0,   36,    2, 0x08 /* Private */,
       5,    0,   37,    2, 0x08 /* Private */,

 // signals: parameters
    QMetaType::Void,
    QMetaType::Void,

 // slots: parameters
    QMetaType::Void,
    QMetaType::Void,

       0        // eod
};

void SignUpActivity::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        SignUpActivity *_t = static_cast<SignUpActivity *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->sign_up_item(); break;
        case 1: _t->child_activity_item(); break;
        case 2: _t->on_toolButton_close_clicked(); break;
        case 3: _t->on_pushButton_post_clicked(); break;
        default: ;
        }
    } else if (_c == QMetaObject::IndexOfMethod) {
        int *result = reinterpret_cast<int *>(_a[0]);
        void **func = reinterpret_cast<void **>(_a[1]);
        {
            typedef void (SignUpActivity::*_t)();
            if (*reinterpret_cast<_t *>(func) == static_cast<_t>(&SignUpActivity::sign_up_item)) {
                *result = 0;
            }
        }
        {
            typedef void (SignUpActivity::*_t)();
            if (*reinterpret_cast<_t *>(func) == static_cast<_t>(&SignUpActivity::child_activity_item)) {
                *result = 1;
            }
        }
    }
    Q_UNUSED(_a);
}

const QMetaObject SignUpActivity::staticMetaObject = {
    { &QWidget::staticMetaObject, qt_meta_stringdata_SignUpActivity.data,
      qt_meta_data_SignUpActivity,  qt_static_metacall, Q_NULLPTR, Q_NULLPTR}
};


const QMetaObject *SignUpActivity::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *SignUpActivity::qt_metacast(const char *_clname)
{
    if (!_clname) return Q_NULLPTR;
    if (!strcmp(_clname, qt_meta_stringdata_SignUpActivity.stringdata0))
        return static_cast<void*>(const_cast< SignUpActivity*>(this));
    return QWidget::qt_metacast(_clname);
}

int SignUpActivity::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QWidget::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 4)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 4;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 4)
            *reinterpret_cast<int*>(_a[0]) = -1;
        _id -= 4;
    }
    return _id;
}

// SIGNAL 0
void SignUpActivity::sign_up_item()
{
    QMetaObject::activate(this, &staticMetaObject, 0, Q_NULLPTR);
}

// SIGNAL 1
void SignUpActivity::child_activity_item()
{
    QMetaObject::activate(this, &staticMetaObject, 1, Q_NULLPTR);
}
QT_END_MOC_NAMESPACE
