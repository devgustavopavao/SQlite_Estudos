package com.devgusta.sqlite_estudos.model

interface IProdutoDAO {

    fun salvar(produto: Produto): Boolean

    fun atualizar(produto: Produto, id: Int): Boolean

    fun remover(id: Int): Boolean

    fun listar() : List<Produto>
}