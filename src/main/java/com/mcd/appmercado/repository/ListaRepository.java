package com.mcd.appmercado.repository;

import com.mcd.appmercado.model.Lista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaRepository  extends CrudRepository<Lista, Integer> {
}
