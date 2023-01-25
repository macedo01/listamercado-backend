package com.mcd.appmercado.service;

import com.mcd.appmercado.model.Lista;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ListaService {
    public Lista criarNovaLista(Lista nova);

    public void removerLista(Integer id);

    public Lista fecharLista(Integer id);

    public Lista buscarPeloId(Integer id);

    public List<Lista> buscarTodas();
}
