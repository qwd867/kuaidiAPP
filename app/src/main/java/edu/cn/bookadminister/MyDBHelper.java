package edu.cn.bookadminister;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
    //常量定义
    public static final String name = "db_book1.db";
    public static final int DB_VERSION = 1;

    public static final String CREATE_USERDATA1 = "create table tb_Books(studentid char(10)primary key,studentname varchar(20),majoy varchar(20),booknum varchar(20))";
    //构造函数
    public MyDBHelper(Context context) {
        super(context, name, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USERDATA1);
        db.execSQL("insert into tb_Books(studentid,studentname,majoy,booknum)Values('40433','林锦雄','计科','123456')");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}