package com.mcd.appmercado.service.impl;

import com.mcd.appmercado.model.ItemLista;
import com.mcd.appmercado.repository.ItemListaRepository;
import com.mcd.appmercado.service.ItemListaService;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemListaServiceImpl implements ItemListaService {

    @Autowired
    ItemListaRepository itemListaRepository;

    @Override
    public ItemLista inserirItem(ItemLista novo) {
        return itemListaRepository.save(novo);
    }

    @Override
    public ItemLista alterarItem(ItemLista novo) {
        return itemListaRepository.save(novo);
    }

    @Override
    public void removerItem(Integer numSeq) {
        itemListaRepository.deleteById(numSeq);
    }
}
