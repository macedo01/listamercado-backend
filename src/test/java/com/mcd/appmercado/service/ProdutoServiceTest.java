package com.mcd.appmercado.service;

import com.mcd.appmercado.model.Produto;
import com.mcd.appmercado.repository.ProdutoRepository;
import com.mcd.appmercado.service.impl.ProdutoServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProdutoServiceTest {
    @Mock
    private ProdutoServiceImpl produtoService;
    private Produto produto;

    @BeforeAll
    void setupClass(){
        produto = new Produto();
        produto.setNome("Biscoito");
        produto.setId(1);
        when(produtoService.criarNovoProduto(new Produto())).thenReturn(produto);
    }

    @Test
    void shouldStoreProduct(){
        Produto expected = new Produto();
        expected.setNome("Biscoito");
        expected.setId(1);
        Produto result = produtoService.criarNovoProduto(new Produto());
        assertNotNull(result);
        System.out.println(result);
        System.out.println(expected);
        assertEquals(expected, result);
    }

}