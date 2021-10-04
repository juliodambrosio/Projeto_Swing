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
import model.entities.Agendamento;
import model.entities.Cliente;
import model.entities.Interno;

/**
 *
 * @author JD
 */
public class AgendamentosDAO {
    
   private Connection conn = null;
   public void cadastrarAgendamento(Agendamento agendamento){
       PreparedStatement st = null;
       try{
           conn = ConexaoDB.getConnection();
           st = conn.prepareStatement("insert into Agendamentos("
                   +"DataHoraMarcada" + ","
                   +"Cliente"         + ","
                   +"Interno"         + ","
                   +"ValorTotal"      + ","
                   +"Cancelado"       + ","
                   +"DuracaoTotal"    + ")"
                   + "values"
                   + "("
                   + "?" + ","
                   + "?" + ","
                   + "?" + ","
                   + "?" + ","
                   + "?" + ","
                   + "?" + ")");
           
           st.setDate(1, agendamento.getDataHoraMarcada());
           st.setInt(2, agendamento.getCliente().getId());
           st.setInt(3, agendamento.getInterno().getId());
           st.setDouble(4, agendamento.getValorTotal());   
           st.setString(5, String.valueOf(agendamento.getCancelado()));
           st.setDouble(6, agendamento.getDuracaoTotal());
           
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
    
    public void alterarAgendamento(Agendamento agendamento){
        
        PreparedStatement st = null;
        
        try{
            conn = ConexaoDB.getConnection();
            st = conn.prepareStatement("update Agendamentos set "
                   +"DataHoraMarcada" + "=" +  "?" + ","
                   +"Cliente"         + "=" +  "?" + ","
                   +"Interno"         + "=" +  "?" + ","
                   +"ValorTotal"      + "=" +  "?" + ","
                   +"Cancelado"       + "=" +  "?" + ","
                   +"DuracaoTotal"    + "=" +  "?" + " "
                   +"where id = "     + "?");
            st.setDate(1, agendamento.getDataHoraMarcada());
            st.setInt(2,agendamento.getCliente().getId());
            st.setInt(3,agendamento.getInterno().getId());
            st.setDouble(4, agendamento.getValorTotal());
            st.setString(5, String.valueOf(agendamento.getCancelado()));
            st.setDouble(6, agendamento.getDuracaoTotal());
            st.setInt(7, agendamento.getId());
          
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
    
    public List<Agendamento> pesquisarAgendamentos(){
        List<Agendamento> listaAgendamentos = new ArrayList<>();
        Statement st =null;
        ResultSet rs = null;
         
        try{
            conn = ConexaoDB.getConnection();
             st = conn.createStatement();
             rs = st.executeQuery("Select ID,DataHoraMarcada,Cliente,Interno,ValorTotal,Cancelado,DuracaoTotal from Agendamentos");
             
             while(rs.next()){
                 Agendamento a = carregarAgendamentoGrid(rs);
                 listaAgendamentos.add(a);
             }
             return listaAgendamentos;
             
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
     
    public Agendamento pesqusarPorId(Integer id){
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = ConexaoDB.getConnection();
            st = conn.prepareStatement("Select ID,DataHoraMarcada,Cliente,Interno,ValorTotal,Cancelado,DuracaoTotal"
                    + " from Agendamentos where ID = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            
            Agendamento p = new Agendamento();
            if(rs.next()){
                  p = carregarAgendamentoGrid(rs);
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
    public void excluirAgendamento(Integer id){
        
        PreparedStatement st = null;
        try{
            conn = ConexaoDB.getConnection();
            st = conn.prepareStatement("Delete from Agendamentos where id = ?");
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
    
    public Agendamento carregarAgendamentoGrid(ResultSet rs){
        Agendamento a = new Agendamento();
        
        //Select ID,DataHoraMarcada,Cliente,Interno,ValorTotal,Cancelado,DuracaoTotal"
        try {
            a.setId(rs.getInt("ID"));
            a.setDataHoraMarcada(rs.getDate("DataHoraMarcada"));
            
            Cliente c = new Cliente();
            c.setId(rs.getInt("Cliente"));
            
            Interno i = new Interno();
            i.setId(rs.getInt("Interno"));
            
            a.setCliente(c);
            a.setInterno(i);
            
            a.setValorTotal(rs.getDouble("ValorTotal"));
            a.setCancelado((rs.getString("Cancelado").charAt(0)));
            a.setDuracaoTotal(rs.getDouble("DuracaoTotal"));
            
        }
        catch(SQLException e){
            throw new DBException("Erro: " + e.getMessage());
        }
        
        return a;
    }
    
    
}
