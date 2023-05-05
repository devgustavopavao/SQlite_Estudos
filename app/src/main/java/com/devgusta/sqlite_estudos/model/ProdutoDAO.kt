package com.devgusta.sqlite_estudos.model

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.devgusta.sqlite_estudos.database.DataBaseHelper
import java.lang.Exception

class ProdutoDAO(context: Context) : IProdutoDAO {

    private val escrever = DataBaseHelper(context).writableDatabase
    private val ler = DataBaseHelper(context).readableDatabase


    override fun salvar(produto: Produto): Boolean {
        val titulo = produto.titulo

        val sql = "INSERT INTO produtos VALUES (null,'$titulo','Descrição longa..');"
            try {
                escrever.execSQL(sql);

            } catch (e: Exception) {
                e.printStackTrace()
                return false
            }
        return true

    }

    override fun atualizar(produto: Produto, id: Int): Boolean {
        val titulo = produto.titulo
        val sql = "UPDATE produtos SET titulo = '$titulo' WHERE id_produto = $id"

        try {
            escrever.execSQL(sql)

        } catch (e: Exception) {
            e.printStackTrace()
          return false
        }
        return true
    }

    override fun remover(id: Int): Boolean {
        val sql = "DELETE FROM produtos" +
                " WHERE id_produto = $id;"

        try {
            escrever.execSQL(sql)
        }catch (e: Exception){
            e.printStackTrace()
            return false
        }
        return true
    }

    override fun listar(): List<Produto> {
        val listaProdutos = mutableListOf<Produto>()
        val sql = "SELECT * FROM ${DataBaseHelper.TABELA};"
        val cursor = ler.rawQuery(sql, null)
        while (cursor.moveToNext()) { // enquanto for TRUE ou TIVER itens na tabela será true else stop
            val idProduto = cursor.getInt(0)
            val titulo = cursor.getString(1)
            listaProdutos.add( Produto(
                idProduto,titulo,"descriçao longa..."
            ))

            //Log.i("INFO_DB", "id = $idProduto  Produto= $titulo ")
        }
        return listaProdutos
    }


}