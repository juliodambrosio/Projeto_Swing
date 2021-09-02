/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.DBException;
import ConexaoDB.ConexaoDB;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.entities.Interno;
import model.enums.PerfilUsuario;

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
            if(interno.getCodigo() == null){
                 st.setNull(1, 0);
             }
             else{
                 st.setInt(1, interno.getCodigo());
             }
            st.setString(2, interno.getNome());
            st.setString(3, interno.getCpf());
            st.setString(4, interno.getTelefone());
            st.setString(5, interno.getUsuario());
            st.setString(6, interno.getSenha());
            st.setString(7, interno.getPerfilUsuario().toString());
            st.setString(8, String.valueOf(interno.getInativo()));
            
            st.execute();
                  
                  
       }
       catch(SQLException e){
           throw new DBException("Erro + " + e.getMessage());
       }
       finally{
            
           ConexaoDB.closeConnection();
           ConexaoDB.closeStatement(st);
       }
       
    }
    
    public void alterarInterno(Interno interno){
        
        PreparedStatement st = null;
        
        try{
            st = conn.prepareStatement("update Internos "
                    + "set codigo = ?"        + ","
                    + "set Nome = ?"          + ","
                    + "set CPF = ?"           + ","
                    + "set Telefone = ?"      + ","
                    + "set Usuario  = ?"      + ","
                    + "set Senha  = ?"        + ","
                    + "set PerfilUsuario = ?" + ","            
                    + "set Inativo = ?");
            
            if (interno.getCodigo() == null) {
                st.setNull(1, 0);
            } 
            else {
                st.setInt(1, interno.getCodigo());
            }
            
            st.setString(2, interno.getNome());
            st.setString(3, interno.getCpf());
            st.setString(4, interno.getTelefone());
            st.setString(5, interno.getUsuario());
            st.setString(6, interno.getSenha());
            st.setString(7, interno.getPerfilUsuario().toString());
            st.setString(8, String.valueOf(interno.getInativo()));
            st.setInt(9, interno.getId());
            
        }
        catch(SQLException e){
            throw new DBException("Erro: "+ e.getMessage());
        }
        finally{
            ConexaoDB.closeConnection();
            ConexaoDB.closeStatement(st);
        }
    }
    
    public List<Interno> pesquisarInternos(){
        List<Interno> listaInternos = new ArrayList<>();
        Statement st =null;
        ResultSet rs = null;
         
        try{
             st = conn.createStatement();
             rs = st.executeQuery("Select ID,Nome,PerfilUsuario from Internos");
             
             while(rs.next()){
                 Interno i = carregarCliente(rs);
                 listaInternos.add(i);
             } 
             return listaInternos;
        }
        catch(SQLException e){
            throw new DBException("Erro: "+ e.getMessage());
        }
        finally{
            ConexaoDB.closeConnection();
            ConexaoDB.closeResultSet(rs);
            ConexaoDB.closeStatement(st);
        }
        
        
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
    
    public Interno carregarCliente(ResultSet rs){
        Interno i = new Interno();
        try {
           
            i.setId(rs.getInt("ID"));
            i.setNome(rs.getString("Nome"));
            i.setPerfilUsuario((PerfilUsuario.valueOf(rs.getString("PerfilUsuario"))));
            
        }
        catch(SQLException e){
            throw new DBException("Erro: " + e.getMessage());
        }

        
        return i;
    }
}
