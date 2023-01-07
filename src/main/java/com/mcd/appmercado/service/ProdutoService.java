package com.mcd.appmercado.service;

import com.mcd.appmercado.model.Produto;

import java.util.List;

public interface ProdutoService {
        public Produto criarNovoProduto(Produto produto);
        public Produto alterarProduto(Produto produto);
        public List<Produto> listarTodos();
        public List<Produto> buscarPorPalavraChave(String chave);
        public Produto buscarPorId(Integer id);
}
