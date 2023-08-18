package com.pizzaria.pizzaria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "rua")
    private String rua;

    @Column(name = "numero")
    private int numero;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Endereco(){

    }


}