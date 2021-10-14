/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;


import DAO.AgendamentoItensDAO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author JD
 */
public class AgendamentoItem {

//    Agendamento
//    Procedimento
//    DataLancamentoItem
//    Valor
//    ID
    
    
    private Integer id;
    private Agendamento agendamento;
    private Procedimento procedimento;
    private Date dataLancamentoItem;
    private Double valor;


    public AgendamentoItem() {

    }

    public AgendamentoItem(Integer id, Agendamento agendamento, Procedimento procedimento, Date dataLancamentoItem, Double valor) {
        this.id = id;
        this.agendamento = agendamento;
        this.procedimento = procedimento;
        this.dataLancamentoItem = dataLancamentoItem;
        this.valor = valor;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void adicionarAgentamentoItem(AgendamentoItem item){
        
    }   
    
    public void excluirAgendamentoItem(AgendamentoItem item){
        
    }
    
      public List<String> puxarAtendimentos(){
        List<String> listaProcedimentos = new ArrayList<>();
        listaProcedimentos = new AgendamentoItensDAO().puxarProcedimentos();
        return listaProcedimentos;
    }
}
