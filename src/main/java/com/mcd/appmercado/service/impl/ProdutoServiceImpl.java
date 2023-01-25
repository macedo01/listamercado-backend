package com.mcd.appmercado.service.impl;

import com.mcd.appmercado.model.Produto;
import com.mcd.appmercado.repository.ProdutoRepository;
import com.mcd.appmercado.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto criarNovoProduto(Produto produto) {
        return produtoRepository.save(produto);
    }
    @Override
    public List<Produto> listarTodos() {
        return (List<Produto>) produtoRepository.findAll();
    }

    @Override
    public List<Produto> buscarPorPalavraChave(String chave) {
        return produtoRepository.findAllByNomeContaining(chave);
    }

    @Override
    public Optional<Produto> buscarPorId(Integer id) {
        return produtoRepository.findById(id);
    }
}
