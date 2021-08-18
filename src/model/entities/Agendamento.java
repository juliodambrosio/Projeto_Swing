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
 */
public class Agendamento {
        
    private int id;
    private Date dataHoraMarcada;
    private Cliente cliente;
    private Interno interno;
    private Double valorTotal;
    private char cancelado;
    
    
    public Agendamento(){
        
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public Date getdataHoraMarcada() {
        return dataHoraMarcada;
    }

    public void setdataHoraMarcada(Date dataHoraMarcada) {
        this.dataHoraMarcada = dataHoraMarcada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Interno getInterno() {
        return interno;
    }

    public void setInterno(Interno interno) {
        this.interno = interno;
    }

    public Double getvalorTotal() {
        return valorTotal;
    }

    public void setvalorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public char getcancelado() {
        return cancelado;
    }

    public void setcancelado(char cancelado) {
        this.cancelado = cancelado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Agendamento other = (Agendamento) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
