package com.mcd.appmercado.service;

import com.mcd.appmercado.model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProdutoService {
        public Produto criarNovoProduto(Produto produto);
        public List<Produto> listarTodos();
        public List<Produto> buscarPorPalavraChave(String chave);
        public Optional<Produto> buscarPorId(Integer id);
}
