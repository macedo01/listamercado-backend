package com.mcd.appmercado.repository;

import com.mcd.appmercado.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
    public List<Produto> findAllByNomeContaining(String palavraChave);
}
