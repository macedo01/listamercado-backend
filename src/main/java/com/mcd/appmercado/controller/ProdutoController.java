package com.mcd.appmercado.controller;

import com.mcd.appmercado.model.Produto;
import com.mcd.appmercado.service.impl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoServiceImpl produtoService;

    @PostMapping("/produtos")
    public ResponseEntity<Produto> cadastrarNovo(@RequestBody Produto novo){
        Produto produto = produtoService.criarNovoProduto(novo);
        if(produto != null){
            return ResponseEntity.status(201).body(produto);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/produtos/search")
    public ResponseEntity<List<Produto>> recuperarPorPalavraChave(@RequestParam(name = "k") String keyword){
        return ResponseEntity.ok(produtoService.buscarPorPalavraChave(keyword));
    }
    @GetMapping("/produtos/{id}")
    public ResponseEntity <Optional<Produto>> recuperarPorId(@PathVariable Integer id){
        Optional<Produto> produto = produtoService.buscarPorId(id);
            return ResponseEntity.ok(produto);
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> recuperarTodos(){
        return ResponseEntity.ok(produtoService.listarTodos());
    }
}
