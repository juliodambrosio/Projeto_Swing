/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import model.entities.Agendamento;

/**
 *
 * @author JD
 */
public class AgendamentoController {
    
    public boolean cadastrarAgendamento(Agendamento a){
        if (a.getCliente() != null || a.getDataHoraMarcada() != null ){
            a.cadastrarAgendamento(a);
            return true;
            
        }
        return false;
    }
    
    public boolean verificarAgendamento(Integer id){
        return true;
    }
    
}
