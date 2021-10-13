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
import java.sql.SQLException;
import java.sql.ResultSet;
import model.entities.AgendamentoItem;
import model.entities.Procedimento;

/**
 *
 * @author JD
 */
public class AgendamentoItensDAO {
    
   private Connection conn = null;
   public void cadastrarAgendamentoItemItem(AgendamentoItem item){
       PreparedStatement st = null;
       //    Agendamento
       //    Procedimento
       //    DataLancamentoItem
       //    Valor
       //    ID
       try{
           conn = ConexaoDB.getConnection();
           st = conn.prepareStatement("insert into AgendamentoItens("
                   +"Agendamento" + ","
                   +"Procedimento"         + ","
                   +"DataLancamentoItem"         + ","
                   +"Valor"      + ")" + " "
                   + "values"
                   + "("
                   + "?" + ","
                   + "?" + ","
                   + "?" + ","
                   + "?" + ","
                   + "?" + ","
                   + "?" + ")");
           st.setInt(1, item.getAgendamento().getId());
           st.setInt(2,item.getProcedimento().getid());
           st.setDate(3, item.getDataLancamentoItem());
           st.setDouble(4, item.getProcedimento().getValor());
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
    
    
    
    public List<AgendamentoItem> pesquisarAgendamentoItems(Integer idAgendamento){
        List<AgendamentoItem> listaAgendamentoItems = new ArrayList<>();
        PreparedStatement st =null;
        ResultSet rs = null;
       //    Agendamento
       //    Procedimento
       //    DataLancamentoItem
       //    Valor
       //    ID
        try{
            conn = ConexaoDB.getConnection();
             st = conn.prepareStatement("select a.procedimento as ID" + ","
                                  +"p.Descricao" + ","
                                  +"p.Valor" + " "
                                  +"from Agendamentoitens as a" + " "
                                  +"inner join Procedimentos as p on p.id = a.procedimento" + " "
                                  + "where a.Agendamento = ?");
             st.setInt(1, idAgendamento);
             rs = st.executeQuery();
             
             
             
             while(rs.next()){
                 AgendamentoItem ai = carregarAgendamentoItemGrid(rs);
                 listaAgendamentoItems.add(ai);
             }
             return listaAgendamentoItems;
             
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
    
    
    
    public Double valorTotalDia(String dataInicial, String dataFinal){
        double valorTotalDia = 0.00;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = ConexaoDB.getConnection();
            st = conn.prepareStatement("select sum(ValorTotal) as ValorTotal from AgendamentoItems"  + " "
                    + "where CONVERT(date,DataHoraMarcada,103)" + " "
                    + "between" + " "
                    + "CONVERT(date,'"+dataInicial+"',103) and" + " "
                    + "CONVERT(date,'"+dataFinal+"',103)"  + " "
                    + "and Cancelado is null");
            rs = st.executeQuery();
            if(rs.next()){
              valorTotalDia = rs.getDouble("ValorTotal");
            }
            return valorTotalDia;
            
        }
        catch(SQLException e){
            throw new DBException("Erro ao calcular o total" + e.getMessage());
        }
        
    }
    
    public void excluirAgendamentoItem(Integer id){
        
        PreparedStatement st = null;
        try{
            conn = ConexaoDB.getConnection();
            st = conn.prepareStatement("Delete from AgendamentoItems where id = ?");
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
    
    public AgendamentoItem carregarAgendamentoItemGrid(ResultSet rs){
        Procedimento p = new Procedimento();
        AgendamentoItem ai = new AgendamentoItem();
        
        //Select ID	Descricao	Valor"
        try {
            
            p.setid(rs.getInt("ID"));
            p.setDetalhes(rs.getString("Descricao"));
            p.setValor(rs.getDouble("Valor"));
            
            ai.setProcedimento(p);
            
            return ai;
           
        }
        catch(SQLException e){
            throw new DBException("Erro: " + e.getMessage());
        }
        
        
    }
    
    
}
