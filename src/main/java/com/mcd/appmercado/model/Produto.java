package com.mcd.appmercado.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_produto")
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer id;
    @Column(name = "nome_produto", length = 70, nullable = false)
    private String nome;
}
