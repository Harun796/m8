package com.m9.myapplication.DB

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.m9.myapplication.DB.SeleccionEspContract.COLUMN_NAME_EQUIPO
import com.m9.myapplication.DB.SeleccionEspContract.COLUMN_NAME_NOMBRE
import com.m9.myapplication.DB.SeleccionEspContract.SQL_CREATE_ENTRIES
import com.m9.myapplication.DB.SeleccionEspContract.SQL_DELETE_ENTRIES
import com.m9.myapplication.DB.SeleccionEspContract.TABLE_NAME
import com.m9.myapplication.Jugador


class SeleccionEspDBHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)

    }
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "seleccion.db"
    }
    fun insertJugador(l: Jugador) {
        val values = ContentValues()
        values.put(COLUMN_NAME_EQUIPO, l.equipo)
        values.put(COLUMN_NAME_NOMBRE, l.nombre)

        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
    }
    fun deleteJugador(item: Int) {
        val db = this.writableDatabase
        db.execSQL("DELETE  FROM ${TABLE_NAME} WHERE id = $item")
    }
    @SuppressLint("Range")
    fun getJugadores(): ArrayList<Jugador>{
        val array: ArrayList<Jugador> = ArrayList();
        val db = this.readableDatabase
        val cursor : Cursor = db.rawQuery("select * from ${TABLE_NAME}",null)
        if(cursor.moveToFirst()){
            do {
                val equipo= cursor.getString(cursor.getColumnIndex(COLUMN_NAME_EQUIPO))
                val nombre=cursor.getString(cursor.getColumnIndex(COLUMN_NAME_NOMBRE))
                val id=cursor.getInt(cursor.getColumnIndex("id"))
                array.add(Jugador(id,equipo,nombre))
            }while (cursor.moveToNext())
        }
        return array;
    }
    fun deleteAllJugadores(){
        val db = this.writableDatabase
        db.delete(TABLE_NAME,null, null);
    }

}