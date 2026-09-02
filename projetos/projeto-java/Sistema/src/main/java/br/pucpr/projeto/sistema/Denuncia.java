package br.pucpr.projeto.sistema;

import java.io.Serializable;

public class Denuncia implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idPromocao;
    private int idCliente;
    private String descricao;
    private boolean estado;
    private String dataDenuncia;

    public Denuncia(int idPromocao,int idCliente, String descricao, boolean estado, String dataDenuncia) {
        this.idPromocao = idPromocao;
        this.idCliente = idCliente;
        this.descricao = descricao;
        this.estado = estado;
        this.dataDenuncia = dataDenuncia;
    }

    public String getDataDenuncia() {
        return dataDenuncia;
    }

    public void setDataDenuncia(String dataDenuncia) {
        this.dataDenuncia = dataDenuncia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPromocao() {
        return idPromocao;
    }

    public void setIdPromocao(int idPromocao) {
        this.idPromocao = idPromocao;
    }
}
