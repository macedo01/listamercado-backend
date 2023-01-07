package com.mcd.appmercado.repository;

import com.mcd.appmercado.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}
