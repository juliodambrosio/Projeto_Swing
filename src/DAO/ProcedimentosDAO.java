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
import model.entities.Procedimento;

/**
 *
 * @author JD
 */
public class ProcedimentosDAO {
    
   private Connection conn = null;
   public void cadastrarProcedimento(Procedimento procedimento){
       PreparedStatement st = null;
       try{
           conn = ConexaoDB.getConnection();
           st = conn.prepareStatement("insert into Procedimentos("
                   +"Descricao"         +","
                   +"Detalhes"		+","
                   +"Valor"		+","
                   +"duracao"		
                   +")"
                   + "values"
                   + "("
                   + "?" + ","
                   + "?" + ","
                   + "?" + ","
                   + "?" + ")");
           
           st.setString(1, procedimento.getDescricao());
           st.setString(2, procedimento.getDetalhes());
           st.setDouble(3, procedimento.getValor());
           st.setDouble(4, procedimento.getDuracao());   
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
    
    public void alterarProcedimento(Procedimento procedimento){
        
        PreparedStatement st = null;
        
        try{
            conn = ConexaoDB.getConnection();
            st = conn.prepareStatement("update Procedimentos set "
                    +"Descricao = ? " + ","
                    +"Detalhes  = ? " + ","
                    +"Valor     = ? " + ","
                    +"duracao	= ? " + " "  
                    +"where id = ?");
           
            
           st.setString(1, procedimento.getDescricao());
           st.setString(2, procedimento.getDetalhes());
           st.setDouble(3, procedimento.getValor());
           st.setDouble(4, procedimento.getDuracao());
           st.setInt(5, procedimento.getid());
            
            st.executeUpdate();
            
        }
        catch(SQLException e){
            throw new DBException("Erro: "+ e.getMessage());
        }
        finally{
            ConexaoDB.closeConnection();
            ConexaoDB.closeStatement(st);
        }
    }
    
    public List<Procedimento> pesquisarProcedimentos(){
        List<Procedimento> listaProcedimentos = new ArrayList<>();
        Statement st =null;
        ResultSet rs = null;
         
        try{
            conn = ConexaoDB.getConnection();
             st = conn.createStatement();
             rs = st.executeQuery("Select ID,Descricao,Detalhes,Valor,duracao from Procedimentos");
             
             while(rs.next()){
                 Procedimento i = carregarProcedimentoGrid(rs);
                 listaProcedimentos.add(i);
             } 
             return listaProcedimentos;
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
     
    public Procedimento pesqusarPorId(Integer id){
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = ConexaoDB.getConnection();
            st = conn.prepareStatement("Select ID,Descricao,Detalhes,Valor,Duracao from Procedimentos where ID = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            
            Procedimento p = new Procedimento();
            if(rs.next()){
                  p = carregarProcedimentoGrid(rs);
            }
            return p;
        }
        catch(SQLException e){
            throw new DBException("Erro: " + e.getMessage());
        }
        finally{
            ConexaoDB.closeConnection();
            ConexaoDB.closeResultSet(rs);
            ConexaoDB.closeStatement(st);
        }
    }
    public void excluirProcedimento(Integer id){
        
        PreparedStatement st = null;
        try{
            conn = ConexaoDB.getConnection();
            st = conn.prepareStatement("Delete from Procedimentos where id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            
        }
        catch(SQLException e){
            throw new DBException("Erro: " + e.getMessage());
        }
        finally{
            ConexaoDB.closeConnection();
            ConexaoDB.closeStatement(st);
        }
        
    }
    
    public Procedimento carregarProcedimentoGrid(ResultSet rs){
        Procedimento p = new Procedimento();
        
        //Select ID,Descricao,Detalhes,Valor,Duracao from Procedimentos where ID = ?"
        try {
            p.setid(rs.getInt("ID"));
            p.setDescricao(rs.getString("Descricao"));
            p.setDetalhes(rs.getString("Detalhes"));
            p.setValor(rs.getDouble("Valor"));
            p.setDuracao(rs.getDouble("Duracao"));
        }
        catch(SQLException e){
            throw new DBException("Erro: " + e.getMessage());
        }
        
        return p;
    }
    
    
}
