package com.devgusta.sqlite_estudos.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DataBaseHelper(context: Context) : SQLiteOpenHelper(
    context,"loja.db",null,1
) {

    companion object{
        const val TABELA = "produtos"
        const val ID_PRODUTO = "id_produto"
        const val TITULO = "titulo"
        const val DESCRICAO = "descricao"
    }
    override fun onCreate(db: SQLiteDatabase?) { // APP INSTALL
       val sql = "CREATE TABLE IF NOT EXISTS $TABELA(" +
               "$ID_PRODUTO INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
               "$TITULO VARCHAR(100) ,"+
               "$DESCRICAO TEXT"+
               ");"
       try{
           db?.execSQL(sql)
           Log.i("INFO_DB", "Sucesso ao criar o DB ")

       }catch (e: Exception){
           e.printStackTrace()
           Log.i("INFO_DB", "Error ao criar o DB ")
       }
    }

    override fun onUpgrade(db: SQLiteDatabase?, old_version: Int, new_version: Int) { // UPGRADE APP


    }
}