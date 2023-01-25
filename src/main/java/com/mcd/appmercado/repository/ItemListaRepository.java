package com.mcd.appmercado.repository;

import com.mcd.appmercado.model.ItemLista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemListaRepository extends CrudRepository<ItemLista, Integer> {
}
