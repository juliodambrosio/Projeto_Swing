/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.sql.Date;

/**
 *
 * @author JD
 * 
 */
public class ItensAgendamento {
    
    private int id;
    private Agendamento agendamento;
    private Procedimento procedimento;
    private Date dataLancamentoItem;
    private Double valor;

    
    public ItensAgendamento(){
        
    }
    
    public ItensAgendamento(int id, Agendamento agendamento, Procedimento procedimento, Date dataLancamentoItem, Double valor) {
        this.id = id;
        this.agendamento = agendamento;
        this.procedimento = procedimento;
        this.dataLancamentoItem = dataLancamentoItem;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public Date getDataLancamentoItem() {
        return dataLancamentoItem;
    }

    public void setDataLancamentoItem(Date dataLancamentoItem) {
        this.dataLancamentoItem = dataLancamentoItem;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.id;
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
        final ItensAgendamento other = (ItensAgendamento) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
 
    
}
