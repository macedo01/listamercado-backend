package com.mcd.appmercado.service;

import com.mcd.appmercado.model.ItemLista;
import org.springframework.stereotype.Service;

@Service
public interface ItemListaService {
    public ItemLista inserirItem(ItemLista novo);
    public ItemLista alterarItem(ItemLista novo);
    public void removerItem(Integer numSeq);
}
