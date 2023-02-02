package com.mcd.appmercado.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tbl_lista")
@Data
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista")
    private Integer id;
    @Column(name = "data_criacao", nullable = false)
    private LocalDate data;
    @Column(name = "nome_mercado", length = 50, nullable = false)
    private String nomeMercado;
    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;
    @Column(name = "status", nullable = false)
    private Integer status;
    @OneToMany(mappedBy = "lista", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("lista")
    private List<ItemLista> itens;
}
