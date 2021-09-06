/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import DAO.InternosDAO;
import java.util.ArrayList;
import java.util.List;
import model.enums.PerfilUsuario;

/**
 *
 * @author JD
 */
public class Interno {
    
    private Integer id;
    private Integer codigo;
    private String nome;
    private String cpf;
    private String ddd;
    private String telefone;
    private String usuario;
    private String senha; 
    private PerfilUsuario perfilUsuario;
    private char inativo;
    
    public Interno(){
        
    }

    public Interno(Integer id, Integer codigo, String nome, String cpf, String ddd, String telefone, String usuario, String senha, PerfilUsuario perfilUsuario) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.ddd = ddd;
        this.telefone = telefone;
        this.usuario = usuario;
        this.senha = senha;
        this.perfilUsuario = perfilUsuario;
        this.inativo = 'N';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PerfilUsuario getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

    public char getInativo() {
        return inativo;
    }

    public void setInativo(char inativo) {
        this.inativo = inativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
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
        final Interno other = (Interno) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    public void cadastrarInterno(Interno interno){
        new InternosDAO().cadastrarInterno(interno);
    }
    
    public void alterarInterno(Interno interno){
        new InternosDAO().alterarInterno(interno);
    }
    
    public List<Interno> pesquisarInternos(){
        List<Interno> listaClientes = new ArrayList<>();
        listaClientes = new InternosDAO().pesquisarInternos();
        return listaClientes;
    }
    
    public Interno pesqusarPorId(Integer id){
        Interno i = new Interno();
        new InternosDAO().pesqusarPorId(id);
        return i;
    }
    public Interno pesquisarPorCodigo(Integer codigo){
        Interno i = new Interno();
        new InternosDAO().pesquisarPorCodigo(codigo);
        return i;
    }
    
    public void excluirCliente(Integer id){
        new InternosDAO().excluirCliente(id);
    }
}
