/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.DBException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.entities.Cliente;
import ConexaoDB.*;
import java.util.ArrayList;
import java.util.List;


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
             throw new DBException("Erro ao Cadastrar Cliente "+ ex.getMessage());
         }
         
         finally{
             ConexaoDB.closeConnection();
             conn = null;
             ConexaoDB.closeStatement(st);
             
         }
     
        
    }
    
    public void alterarCliente(Cliente cliente){
        PreparedStatement st=null;
        try{
            conn = ConexaoDB.getConnection();
            st = conn.prepareStatement("update Clientes set "
                    +"Codigo"   + "=" + "?" + ","
                    +"Nome"     + "=" + "?" + ","
                    +"CPF"      + "=" + "?" + ","
                    +"Telefone" + "=" + "?" + ","
                    +"Email"    + "=" + "?" + ","
                    +"OBS"      + "=" + "?" + " "
                    +"where id ="     + "?");
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
            st.setInt(7, cliente.getId());
            
            st.executeUpdate();
            
        }
        catch(SQLException e){
            throw new DBException("Erro" + e.getMessage() + st);
        }
        finally {
            ConexaoDB.closeConnection();
            ConexaoDB.closeStatement(st);

        }
    }
    
    public void apagarCliente(Cliente cliente){
       PreparedStatement st = null;
        try{
            conn = ConexaoDB.getConnection();
            st = conn.prepareStatement("delete from Clientes where id = ? ");
            st.setInt(1, cliente.getId());
            st.executeUpdate();
        }
        catch(SQLException e){
            throw new DBException("Erro ao Deletar: " + e.getMessage());
        }
        finally{
            ConexaoDB.closeConnection();
            ConexaoDB.closeStatement(st);
        }
    }
    
    
    public List<Cliente> pesquisarClientes(){
        conn = ConexaoDB.getConnection();
        Statement st = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();
        
        try{
            
            st = conn.createStatement();
            rs = st.executeQuery("Select ID,Codigo,Nome,CPF,Telefone,Email from Clientes order by Nome");
            
            while(rs.next()){
                Cliente c = criarCliente(rs);
                clientes.add(c);                
            }
            
            return clientes;
        }
        catch(SQLException e){
            throw new DBException("Erro ao Pesquisar Cliente: " + e.getMessage());
        }
        finally {
            ConexaoDB.closeConnection();
            ConexaoDB.closeStatement(st);
            ConexaoDB.closeResultSet(rs);

        }
        
        
    }
    
    public Cliente pesquisarPorId(Integer id){
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn =  ConexaoDB.getConnection();
            st =  conn.prepareStatement("Select ID,Codigo,Nome,CPF,Telefone,Email,OBS from Clientes "
                    + "where id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            
            Cliente c = new Cliente();
            if(rs.next()){
               c = criarClienteComOBS(rs);         
            }
            return c;  
           
        }
        catch(SQLException e){
            throw new DBException("Erro ao Procurar Cliente: " + e.getMessage());
        }
    }
    
     public Cliente pesquisarPorCodigo(Integer codigo){
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn =  ConexaoDB.getConnection();
            st =  conn.prepareStatement("Select ID,Codigo,Nome,CPF,Telefone,Email from Clientes "
                    + "where Codigo = ?");
            st.setInt(1, codigo);
            rs = st.executeQuery();
            
            Cliente c = criarCliente(rs);
            return c;
        }
        catch(SQLException e){
            throw new DBException("Erro ao Procurar Cliente: " + e.getMessage());
        }
    }
    
    
    public Cliente criarCliente(ResultSet rs){
        try{
            //ID,Codigo,Nome,CPF,Telefone,Email
            Cliente c = new Cliente();
            c.setId(rs.getInt("ID"));   
            c.setCodigo(rs.getInt("Codigo"));
            c.setNome(rs.getString("Nome"));
            c.setCpf(rs.getString("CPF"));
            c.setTelefone(rs.getString("Telefone"));
            //c.setDdd(rs.getString("Telefone").substring(0, 1));
            //c.setTelefone(rs.getString("Telefone").substring(1, rs.getString("Telefone").length() - 2));
            c.setEmail(rs.getString("Email"));
            return c;
        }
        catch(SQLException e){
            throw new DBException("Erro ao Criar Cliente ResultSET" + e.getMessage());
        }
             
    }
    
    
       public Cliente criarClienteComOBS(ResultSet rs){
        try{
            //ID,Codigo,Nome,CPF,Telefone,Email
            Cliente c = new Cliente();
            c.setId(rs.getInt("ID"));
            c.setCodigo(rs.getInt("Codigo"));
            c.setNome(rs.getString("Nome"));
            c.setCpf(rs.getString("CPF"));
            c.setTelefone(rs.getString("Telefone"));
            //c.setDdd(rs.getString("Telefone").substring(0, 1));
            //c.setTelefone(rs.getString("Telefone").substring(1, rs.getString("Telefone").length() - 2));
            c.setEmail(rs.getString("Email"));
            c.setOBS(rs.getString("OBS"));
            return c;
        }
        catch(SQLException e){
            throw new DBException("Erro ao Criar Cliente ResultSET: " + e.getMessage());
        }
             
    }
}
