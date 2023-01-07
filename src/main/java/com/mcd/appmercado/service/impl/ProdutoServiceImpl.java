package com.mcd.appmercado.service.impl;

import com.mcd.appmercado.model.Produto;
import com.mcd.appmercado.repository.ProdutoRepository;
import com.mcd.appmercado.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto criarNovoProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Produto alterarProduto(Produto produto) {
        return null;
    }

    @Override
    public List<Produto> listarTodos() {
        return null;
    }

    @Override
    public List<Produto> buscarPorPalavraChave(String chave) {
        return null;
    }

    @Override
    public Produto buscarPorId(Integer id) {
        return null;
    }
}
