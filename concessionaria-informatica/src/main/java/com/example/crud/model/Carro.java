package com.example.crud.model;

public class Carro {
    private Integer id;
    private String modelo;
    private Integer ano;
    private String faixaPreco;

    public Carro() {}

    public Carro(Integer id, String modelo, Integer ano, String faixaPreco) {
        this.id = id;
        this.modelo = modelo;
        this.ano = ano;
        this.faixaPreco = faixaPreco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getFaixaPreco() {
        return faixaPreco;
    }

    public void setFaixaPreco(String faixaPreco) {
        this.faixaPreco = faixaPreco;
    }
}
