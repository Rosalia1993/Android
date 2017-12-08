package com.ejemplo.rossv.agenda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ROSSV on 22/11/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper{
//constuctor
    public DataBaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);

    }
    //declarar la cracion de la base
    public static final String DATABASE_NAME="agenda.db";
    static final int BD_VERSION = 1;
    //declara table
    public  static final String TABLE_NAME = "contacto";
    public  static final String USER_ID = "id";
    public  static final String USER_NAME = "nombre";
    public  static final String USER_SURNAME= "apellidos";
    //public  static final String USER_CITY= "ciudad";
    public  static final String USER_PHONE= "telefono";
    public  static final String USER_EMAIL= "email";

    private static final String CREATE_TABLE = "create table "
            + TABLE_NAME + "("
            +USER_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "
            + USER_NAME + " TEXT NOT NULL)"
            +USER_SURNAME+"text not null"
            + USER_PHONE +"text not null"
            +USER_EMAIL+"text not null);";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

        //db.execSQL("insert into contacto values('admin','admin')");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXIST "+ TABLE_NAME);
        onCreate(db);
    }
}
