package com.ejemplo.rossv.agenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ROSSV on 22/11/2017.
 */

public class UsuarioControlador {
    private DataBaseHelper dbhelper;
    private Context context;
    private SQLiteDatabase database;



    public UsuarioControlador(Context context) {
        this.context = context;
    }

    public UsuarioControlador abriBD() throws SQLException {
        dbhelper = new DataBaseHelper(context);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrarBD(){
        dbhelper.close();

    }

    public void insertarDatos(String nombre,String apellidos,String telefono,String email){
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.USER_NAME , nombre);
        cv.put(DataBaseHelper.USER_SURNAME,apellidos);
        cv.put(DataBaseHelper.USER_PHONE,telefono);
        cv.put(DataBaseHelper.USER_EMAIL,email);
        long newRowId = database.insert(DataBaseHelper.TABLE_NAME, null, cv);
    }

    public void borrarDatos(long personalID){
        database.delete(DataBaseHelper.TABLE_NAME, DataBaseHelper.USER_ID
                +" = " + personalID, null);
    }

    public int actualizarDatos(long personalID, String nombre){
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.USER_NAME, nombre);
        int i = database.update(DataBaseHelper.TABLE_NAME, cv,
                DataBaseHelper.USER_ID + " = " + personalID, null);
        return i;
    }

    public Cursor leerDatos(){
        String[] col = new String[]{
                DataBaseHelper.USER_ID, DataBaseHelper.USER_NAME
        };
        Cursor c = database.query(DataBaseHelper.TABLE_NAME, col,
                null, null, null, null, null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }


}
