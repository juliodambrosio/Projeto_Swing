/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import DAO.ClientesDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JD
 */
public class Cliente {
    
    private int id;
    private Integer codigo;
    private String nome;
    private String cpf;
    private String ddd;
    private String telefone;
    private String Email;
    private String OBS;
    
    public Cliente(){
        
    }

    public Cliente(int id, Integer codigo, String nome, String cpf, String ddd, String telefone, String Email, String OBS) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.ddd = ddd;
        this.telefone = telefone;
        this.Email = Email;
        this.OBS = OBS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getOBS() {
        return OBS;
    }

    public void setOBS(String OBS) {
        this.OBS = OBS;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    public void cadastrarCliente(Cliente cliente){
        new ClientesDAO().CadastrarCliente(cliente);
    }
    
    public void atualizarCliente(Cliente cliente){
        
    }
    public void excluirCliente(Cliente cliente){
        
    }
    
    public Cliente pesquisarClientePorCodigo(Integer codigo){
        Cliente cliente = new Cliente();
        return cliente;
    }
    
    public List<Cliente> pesquisarClientes(Cliente cliente){
        List<Cliente> listaClientes = new ArrayList<>();
        return listaClientes;
    }
    
}
