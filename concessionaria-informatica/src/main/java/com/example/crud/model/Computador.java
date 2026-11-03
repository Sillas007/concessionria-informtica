package com.example.crud.model;

public class Computador {
    private Integer id;
    private String processador;
    private String ram;
    private String armazenamento;

    public Computador() {}

    public Computador(Integer id, String processador, String ram, String armazenamento) {
        this.id = id;
        this.processador = processador;
        this.ram = ram;
        this.armazenamento = armazenamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(String armazenamento) {
        this.armazenamento = armazenamento;
    }
}
