package com.mcd.appmercado.controller;

import com.mcd.appmercado.model.Lista;
import com.mcd.appmercado.service.impl.ListaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ListaController {

    @Autowired
    ListaServiceImpl service;

    @GetMapping("/listas")
    public ResponseEntity<List<Lista>> recuperarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping("/listas/{id}")
    public ResponseEntity<Lista> buscarPeloId(@PathVariable Integer id){
        Lista res = service.buscarPeloId(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/listas")
    public ResponseEntity<Lista> adicionarNova(@RequestBody Lista nova){
        Lista res = service.criarNovaLista(nova);
        if (res != null) {
            return ResponseEntity.status(201).body(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/listas/{id}")
    public ResponseEntity<Lista> alterarListas(@PathVariable Integer id){
        Lista res = service.fecharLista(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/listas/{id}")
    public ResponseEntity<?> removerLista(@PathVariable Integer id){
        service.removerLista(id);
        return ResponseEntity.ok("ok");
    }

}
