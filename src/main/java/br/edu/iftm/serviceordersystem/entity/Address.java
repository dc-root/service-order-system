package br.edu.iftm.serviceordersystem.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address {
    @EqualsAndHashCode.Include
    private long cep;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
//    private AddressType addressType;
}