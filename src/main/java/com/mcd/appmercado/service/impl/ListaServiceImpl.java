package com.mcd.appmercado.service.impl;

import com.mcd.appmercado.model.ItemLista;
import com.mcd.appmercado.model.Lista;
import com.mcd.appmercado.repository.ListaRepository;
import com.mcd.appmercado.service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ListaServiceImpl implements ListaService {

    @Autowired
    ListaRepository listaRepository;

    @Override
    public Lista criarNovaLista(Lista nova) {
        return listaRepository.save(nova);
    }

    @Override
    public void removerLista(Integer id) {
        listaRepository.deleteById(id);
    }

    @Override
    public Lista fecharLista(Integer id) {
        Lista l = listaRepository.findById(id).get();
        double total=0.0;
        for (ItemLista item: l.getItens()) {
            total += l.getValorTotal();
        }
        l.setValorTotal(total);
        l.setStatus(1); // lista concluida;
        return listaRepository.save(l);
    }

    @Override
    public Lista buscarPeloId(Integer id) {
        return listaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Lista> buscarTodas() {
        return (List<Lista>) listaRepository.findAll();
    }
}
