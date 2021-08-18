/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

/**
 *
 * @author JD
 */
public class Procedimento {
    
    private int id;
    private int codigo;
    private String descricao;
    private String detalhes;
    private Double valorTotal;
    private Double duracao;
    
    public Procedimento(){
        
    }

    public Procedimento(int id, int codigo, String descricao, String detalhes, Double valorTotal, Double duracao) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.detalhes = detalhes;
        this.valorTotal = valorTotal;
        this.duracao = duracao;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getcodigo() {
        return codigo;
    }

    public void setcodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getdetalhes() {
        return detalhes;
    }

    public void setdetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Double getvalorTotal() {
        return valorTotal;
    }

    public void setvalorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getDuracao() {
        return duracao;
    }

    public void setDuracao(Double duracao) {
        this.duracao = duracao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Procedimento other = (Procedimento) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
