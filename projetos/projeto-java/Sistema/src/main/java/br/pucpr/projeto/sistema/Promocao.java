package br.pucpr.projeto.sistema;

import java.io.Serializable;

public class Promocao implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int proximoId = 1;

    private int id;
    private String nomeProduto;
    private int idLoja;
    private double precoInicial;
    private double precoPromocional;
    private int quantidade;
    private String tipo;

    public Promocao(String nomeProduto, int idLoja, double precoInicial, double precoPromocional, int quantidade, String tipo) {
        this.id = proximoId++;
        this.nomeProduto = nomeProduto;
        this.idLoja = idLoja;
        this.precoInicial = precoInicial;
        this.precoPromocional = precoPromocional;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoInicial() {
        return precoInicial;
    }

    public void setPrecoInicial(double precoInicial) {
        this.precoInicial = precoInicial;
    }

    public double getPrecoPromocional() {
        return precoPromocional;
    }

    public void setPrecoPromocional(double precoPromocional) {
        this.precoPromocional = precoPromocional;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }
}
