/****************************************************************************
** Meta object code from reading C++ file 'createdynamic.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.5.1)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../SimapleActivity/createdynamic.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'createdynamic.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.5.1. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
struct qt_meta_stringdata_CreateDynamic_t {
    QByteArrayData data[12];
    char stringdata0[189];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_CreateDynamic_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_CreateDynamic_t qt_meta_stringdata_CreateDynamic = {
    {
QT_MOC_LITERAL(0, 0, 13), // "CreateDynamic"
QT_MOC_LITERAL(1, 14, 13), // "createDynamic"
QT_MOC_LITERAL(2, 28, 0), // ""
QT_MOC_LITERAL(3, 29, 7), // "content"
QT_MOC_LITERAL(4, 37, 12), // "QStringList&"
QT_MOC_LITERAL(5, 50, 4), // "list"
QT_MOC_LITERAL(6, 55, 31), // "on_toolButton_add_image_clicked"
QT_MOC_LITERAL(7, 87, 29), // "on_pushButton_publish_clicked"
QT_MOC_LITERAL(8, 117, 11), // "reduce_item"
QT_MOC_LITERAL(9, 129, 5), // "index"
QT_MOC_LITERAL(10, 135, 27), // "on_toolButton_close_clicked"
QT_MOC_LITERAL(11, 163, 25) // "on_toolButton_min_clicked"

    },
    "CreateDynamic\0createDynamic\0\0content\0"
    "QStringList&\0list\0on_toolButton_add_image_clicked\0"
    "on_pushButton_publish_clicked\0reduce_item\0"
    "index\0on_toolButton_close_clicked\0"
    "on_toolButton_min_clicked"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_CreateDynamic[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
       6,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       1,       // signalCount

 // signals: name, argc, parameters, tag, flags
       1,    2,   44,    2, 0x06 /* Public */,

 // slots: name, argc, parameters, tag, flags
       6,    0,   49,    2, 0x08 /* Private */,
       7,    0,   50,    2, 0x08 /* Private */,
       8,    1,   51,    2, 0x08 /* Private */,
      10,    0,   54,    2, 0x08 /* Private */,
      11,    0,   55,    2, 0x08 /* Private */,

 // signals: parameters
    QMetaType::Void, QMetaType::QString, 0x80000000 | 4,    3,    5,

 // slots: parameters
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void, QMetaType::QModelIndex,    9,
    QMetaType::Void,
    QMetaType::Void,

       0        // eod
};

void CreateDynamic::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        CreateDynamic *_t = static_cast<CreateDynamic *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->createDynamic((*reinterpret_cast< QString(*)>(_a[1])),(*reinterpret_cast< QStringList(*)>(_a[2]))); break;
        case 1: _t->on_toolButton_add_image_clicked(); break;
        case 2: _t->on_pushButton_publish_clicked(); break;
        case 3: _t->reduce_item((*reinterpret_cast< const QModelIndex(*)>(_a[1]))); break;
        case 4: _t->on_toolButton_close_clicked(); break;
        case 5: _t->on_toolButton_min_clicked(); break;
        default: ;
        }
    } else if (_c == QMetaObject::IndexOfMethod) {
        int *result = reinterpret_cast<int *>(_a[0]);
        void **func = reinterpret_cast<void **>(_a[1]);
        {
            typedef void (CreateDynamic::*_t)(QString , QStringList & );
            if (*reinterpret_cast<_t *>(func) == static_cast<_t>(&CreateDynamic::createDynamic)) {
                *result = 0;
            }
        }
    }
}

const QMetaObject CreateDynamic::staticMetaObject = {
    { &QWidget::staticMetaObject, qt_meta_stringdata_CreateDynamic.data,
      qt_meta_data_CreateDynamic,  qt_static_metacall, Q_NULLPTR, Q_NULLPTR}
};


const QMetaObject *CreateDynamic::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *CreateDynamic::qt_metacast(const char *_clname)
{
    if (!_clname) return Q_NULLPTR;
    if (!strcmp(_clname, qt_meta_stringdata_CreateDynamic.stringdata0))
        return static_cast<void*>(const_cast< CreateDynamic*>(this));
    return QWidget::qt_metacast(_clname);
}

int CreateDynamic::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QWidget::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 6)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 6;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 6)
            *reinterpret_cast<int*>(_a[0]) = -1;
        _id -= 6;
    }
    return _id;
}

// SIGNAL 0
void CreateDynamic::createDynamic(QString _t1, QStringList & _t2)
{
    void *_a[] = { Q_NULLPTR, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 0, _a);
}
QT_END_MOC_NAMESPACE
