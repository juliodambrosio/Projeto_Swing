/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import model.entities.Procedimento;

/**
 *
 * @author JD
 */
public class ProcedimentoController {
    
    public boolean cadastrarProcedimento(Procedimento procedimento){
        if(!procedimento.getDescricao().isEmpty() || procedimento.getValor() != null ){
            procedimento.cadastrarProcedimento(procedimento);
            return true;
        }
        else{
            return false;
        }
        
    }
    public boolean alterarProcedimento(Procedimento procedimento){
        if(!procedimento.getDescricao().isEmpty() || procedimento.getValor() != null ){
            procedimento.alterarProcedimento(procedimento);
            return true;
        }
        else{
            return false;
        }
    }
    
}
