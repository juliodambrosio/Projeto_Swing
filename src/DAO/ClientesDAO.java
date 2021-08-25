/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.DBException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.entities.Cliente;
import ConexaoDB.*;


/**
 *
 * @author JD
 */
public class ClientesDAO {
    
    public void CadastrarCliente(Cliente cliente){
         Connection conn =  ConexaoDB.getConnection();
         PreparedStatement st = null;
         try{
             st = conn.prepareStatement("Insert into Clientes("
                     + "Codigo"   + ","
                     + "Nome"     + ","
                     + "CPF"      + ","
                     + "Telefone" + ","
                     + "Email"    + ","
                     + "OBS) "
                     + "values "
                     + "("
                     + "?" + ","
                     + "?" + ","
                     + "?" + ","
                     + "?" + ","
                     + "?" + ","
                     + "?" 
                     + ")");
             
             if(cliente.getCodigo() == null){
                 st.setNull(1, 0);
             }
             else{
                 st.setInt(1, cliente.getCodigo());
             }
             st.setString(2, cliente.getNome());
             st.setString(3, cliente.getCpf());
             st.setString(4, cliente.getDdd() + cliente.getTelefone());
             st.setString(5, cliente.getEmail());
             st.setString(6, cliente.getOBS());
             
             st.executeUpdate();
         }
         catch(SQLException ex){
             throw new DBException("Erro: "+ ex.getMessage());
         }
         
         finally{
             ConexaoDB.closeConnection();
             ConexaoDB.closeStatement(st);
         }
     
        
    }
    
    
}
