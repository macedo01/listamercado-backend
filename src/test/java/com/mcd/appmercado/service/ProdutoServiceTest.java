package com.mcd.appmercado.service;

import com.mcd.appmercado.model.Produto;
import com.mcd.appmercado.repository.ProdutoRepository;
import com.mcd.appmercado.service.impl.ProdutoServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class ProdutoServiceTest {

    @InjectMocks
    private ProdutoServiceImpl produtoService;
    @Mock
    private ProdutoRepository produtoRepository;

    private Integer existingId = 1;
    private Integer nonExistingId = 100;
    private String keyword = "bolacha";
    private Produto newProduct,p1, p2;
    private Produto createdProduct ;
    private ArrayList<Produto> listaDeVariosProdutos;

    @BeforeEach
    void setup(){

        newProduct = new Produto();
        newProduct.setId(2);

        createdProduct = new Produto();
        createdProduct.setId(1);
        createdProduct.setNome("Biscoito");

        listaDeVariosProdutos = new ArrayList<>();
        p1 = new Produto();
        p1.setId(1);
        p1.setNome("biscoito recheado");
        p2 = new Produto();
        p2.setId(2);
        p2.setNome("biscoito de morango");
        listaDeVariosProdutos.add(p1);
        listaDeVariosProdutos.add(p2);

        Mockito.when(produtoRepository.save(new Produto())).thenReturn(createdProduct);
        Mockito.when(produtoRepository.findById(existingId)).thenReturn(Optional.ofNullable(createdProduct));
        Mockito.when(produtoRepository.findById(nonExistingId)).thenReturn(null);
        Mockito.when(produtoRepository.findAllByNomeContaining("biscoito")).thenReturn(listaDeVariosProdutos);
        Mockito.when(produtoRepository.findAllByNomeContaining(keyword)).thenReturn(new ArrayList<>());
    }

    @Test
    void deveriaCadastrarProduto(){
        Produto result = produtoService.criarNovoProduto(new Produto());;
        assertNotNull(result);
        assertEquals("Biscoito", result.getNome());
        assertEquals(1, result.getId());
    }

    @Test
    void deveriaRetornarPeloId(){
        Optional<Produto> result = produtoService.buscarPorId(existingId);
        assertNotNull(result);
        assertEquals("Biscoito", result.get().getNome());
        assertEquals(1, result.get().getId());
    }

    @Test
    void deveriaNaoEncontrarId(){
        Optional<Produto> result = produtoService.buscarPorId(nonExistingId);
        assertNull(result);
    }

    @Test
    void deveriaRetornarListaComPalavraChave(){
        List<Produto> result = produtoService.buscarPorPalavraChave("biscoito");
        assertNotNull(result);
        assertEquals("biscoito recheado", result.get(0).getNome());
    }

    @Test
    void deveriaRetornarListaVazia(){
        List<Produto> result = produtoService.buscarPorPalavraChave(keyword);
        assertNotNull(result);
        assertEquals(0, result.size());
    }
}