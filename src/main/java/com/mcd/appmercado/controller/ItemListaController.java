package com.mcd.appmercado.controller;

import com.mcd.appmercado.model.ItemLista;
import com.mcd.appmercado.service.impl.ItemListaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class ItemListaController {

    @Autowired
    ItemListaServiceImpl service;

    @PostMapping("/itemlista")
    public ResponseEntity<ItemLista> inserir(@RequestBody ItemLista novo){
        System.out.println(novo);
        ItemLista res = service.inserirItem(novo);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/itemlista/{numSeq}")
    public ResponseEntity<ItemLista> alterar(@RequestBody ItemLista item, @PathVariable Integer numSeq){
        item.setNumSeq(numSeq);
        ItemLista res = service.alterarItem(item);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }


    @DeleteMapping("/itemlista/{numSeq}")
    public ResponseEntity<?> apagar(@PathVariable Integer numSeq){
        service.removerItem(numSeq);
        return ResponseEntity.ok("ok");
    }
}
