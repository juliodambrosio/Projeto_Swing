/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.entities.Interno;

/**
 *
 * @author JD
 */
public class InternosDAO {
    
   private Connection conn = null;
   public void cadastrarInterno(Interno interno){
       PreparedStatement st = null;
       try{
           st = conn.prepareStatement("insert into Internos( "
                   +"Codigo"        +","
                   +"Nome"          +","
                   +"CPF"           +","
                   +"Telefone"      +","
                   +"Usuario"       +","
                   +"Senha"         +","
                   +"PerfilUsuario" +","
                   +"Inativo) "
                   + "values"
                   + "("
                   + "?" + ","
                   + "?" + ","
                   + "?" + ","
                   + "?" + ","
                   + "?" + ","
                   + "?" + ","
                   + "?" + ","
                   + "?" 
                   + ")");
           st.
           
                   
                  
       }
       catch(SQLException e){
           throw new DBException("Erro + " + e.getMessage());
       }
       
    }
    
    public void updateInterno(Interno interno){
        
    }
    
    public List<Interno> pesquisarInternos(){
        List<Interno> listaClientes = new ArrayList<>();
        
        return listaClientes;
    }
    
    public Interno pesqusarPorId(Integer id){
        Interno i = new Interno();
        return i;
    }
    public Interno pesquisarPorCodigo(Integer codigo){
        Interno i = new Interno();
        return i;
    }
    
    public void excluirCliente(Integer id){
        
    }
    
    
}
