package com.devgusta.sqlite_estudos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.devgusta.sqlite_estudos.database.DataBaseHelper
import com.devgusta.sqlite_estudos.databinding.ActivityMainBinding
import com.devgusta.sqlite_estudos.model.Produto
import com.devgusta.sqlite_estudos.model.ProdutoDAO
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            btnSalvar.setOnClickListener {
                salvar()
            }
            btnListar.setOnClickListener {
                listar()
            }
            btnAtualizar.setOnClickListener {
                atualizar()
            }
            btnRemover.setOnClickListener {
                excluir()
            }
        }

    }

    private fun atualizar() {
        val titulo = binding.editProduto.text.toString()
        val produtoDAO = ProdutoDAO(this)
        val produto = Produto(
            -1,titulo,
            "Descrição longa"
        )
        produtoDAO.atualizar(produto,2)
    }

    private fun excluir() {
        val produtoDAO = ProdutoDAO(this)
        produtoDAO.remover(2)
    }

    private fun salvar() {
        val produtoDigitado = binding.editProduto.text.toString()
        val produtoDAO = ProdutoDAO(this)
        val produto = Produto(
            -1, produtoDigitado,
            "Descrição longa.."
        )
        produtoDAO.salvar(produto)
    }

    private fun listar() {
      val produtoDAO = ProdutoDAO(this)
        val listaProdutos = produtoDAO.listar()

        if( listaProdutos.isNotEmpty()){
           listaProdutos.forEach { produto ->
               Log.i("INFO_DB", "id: ${produto.id_produto} - Produto: ${produto.titulo}")
           }
        }
    }
}