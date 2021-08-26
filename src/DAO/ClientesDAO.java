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
    
    private Connection conn = null;
    
    public void CadastrarCliente(Cliente cliente){
        
         PreparedStatement st = null;
         try{
             conn = ConexaoDB.getConnection();
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
             conn = null;
             ConexaoDB.closeStatement(st);
             
         }
     
        
    }
    
    public void alterarCliente(Cliente cliente){
        Connection conn = null;
        PreparedStatement st = null;
        
        try{
            conn = ConexaoDB.getConnection();
            st = conn.prepareStatement("update Clientes set"
                    +"Codigo"   + "=" + "?" + ","
                    +"Nome"     + "=" + "?" + ","
                    +"CPF"      + "=" + "?" + ","
                    +"Telefone" + "=" + "?" + ","
                    +"Email"    + "=" + "?" + ","
                    +"OBS"      + "=" + "?" 
                    +"where id =" + "?");
            if(cliente.getCodigo() == null){
                st.setNull(1, 0);
            }
            else{
                st.setInt(1, cliente.getCodigo());
            }
        }
        catch(SQLException e){
            throw new DBException("Erro" + e.getMessage());
        }
    }
    
}