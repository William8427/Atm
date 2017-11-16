package com.tuner.navi.atm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by square on 2017/11/13.
 */

public class MyDBHelper extends SQLiteOpenHelper {


    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        getWritableDatabase().execSQL("CREATE TABLE main.exp, " +
                "(_id INTEGER PRIMARY KEY NOT NULL, " +
                "cdate datetime not null, " +
                "info varchar, amount integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
