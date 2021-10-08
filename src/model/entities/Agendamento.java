/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import DAO.AgendamentosDAO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JD
 */
public class Agendamento {

    private int id;
    private Date DataHoraMarcada;
    private Cliente cliente;
    private Interno interno;
    private Double valorTotal;
    private Double duracaoTotal;
    private char Cancelado;

    public Agendamento() {

    }

    public Agendamento(int id, Date DataHoraMarcada, Cliente cliente, Interno interno, Double valorTotal, Double duracaoTotal, char cancelado) {
        this.id = id;
        this.DataHoraMarcada = DataHoraMarcada;
        this.cliente = cliente;
        this.interno = interno;
        this.valorTotal = valorTotal;
        this.duracaoTotal = duracaoTotal;
        this.Cancelado = cancelado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHoraMarcada() {
        return DataHoraMarcada;
    }

    public void setDataHoraMarcada(Date DataHoraMarcada) {
        this.DataHoraMarcada = DataHoraMarcada;
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

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getDuracaoTotal() {
        return duracaoTotal;
    }

    public void setDuracaoTotal(Double duracaoTotal) {
        this.duracaoTotal = duracaoTotal;
    }
    

    public char getCancelado() {
        return Cancelado;
    }

    public void setCancelado(char Cancelado) {
        this.Cancelado = Cancelado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
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

    public void cadastrarAgendamento(Agendamento agendamento){
        new AgendamentosDAO().cadastrarAgendamento(agendamento);
    }
    
    public void alterarAgendamento(Agendamento agendamento){
        new AgendamentosDAO().alterarAgendamento(agendamento);
    }
    
    public void excluirAgendamento(int id){
        new AgendamentosDAO().excluirAgendamento(id);
    }
    
    public List<Agendamento> pesquisarAgendamentos(){
        List<Agendamento> listaAgendamentos = new ArrayList<>();
        listaAgendamentos = new AgendamentosDAO().pesquisarAgendamentos();
        return listaAgendamentos;
    }
    
    public Agendamento pesquisarAgendamentoPorID(int id){
        return new AgendamentosDAO().pesqusarPorId(id);
    }
    
    public Double valorTotalDia(String dataInicial, String dataFinal){
        return  new AgendamentosDAO().valorTotalDia(dataInicial, dataFinal);   
    }
}
