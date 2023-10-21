package br.edu.iftm.serviceordersystem.entity;

import lombok.Data;

@Data
public abstract class Address {
    private long cep;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
}