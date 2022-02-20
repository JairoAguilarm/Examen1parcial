package com.example.examen1parcial;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLconected extends SQLiteOpenHelper{

    public SQLconected(Context context, String dbname, SQLiteDatabase.CursorFactory factory, int version){
        super(context, dbname, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Transacciones.CreateTablecontacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newVersion) {
        db.execSQL(Transacciones.CreateTablecontacto);
        onCreate(db);
    }
}