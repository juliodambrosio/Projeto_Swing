/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.util.ArrayList;
import java.util.List;
import DAO.ProcedimentosDAO;

/**
 *
 * @author JD
 */
public class Procedimento {
    
    private Integer id;
    private Integer codigo;
    private String descricao;
    private String detalhes;
    private Double valor;
    private Double duracao;
    
    public Procedimento(){
        
    }

    public Procedimento(Integer id, Integer codigo, String descricao, String detalhes, Double valor, Double duracao) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.detalhes = detalhes;
        this.valor = valor;
        this.duracao = duracao;
    }

    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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
    
    
    public void cadastrarProcedimento(Procedimento procedimento){
        
    }
    
    public void alterarProcedimento(Procedimento procedimento){
        
    }
    
    public void excluirProcedimento(int id){
        
    }
    
    public List<Procedimento> pesquisarProcedimentos(){
        List<Procedimento> listaProcedimentos = new ArrayList<>();
        listaProcedimentos = new ProcedimentosDAO().pesquisarProcedimentos();
        return listaProcedimentos;
    }
    
    public Procedimento pesquisarPorId(int id){
        Procedimento p = null;
        return p;
    }
    
}
