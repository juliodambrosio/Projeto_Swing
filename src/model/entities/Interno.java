/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import model.enums.PerfilUsuario;

/**
 *
 * @author JD
 */
public class Interno {
    
    private int id;
    private int codigo;
    private String nome;
    private char cpf;
    private char ddd;
    private char telefone;
    private String usuario;
    private String senha;
    private PerfilUsuario perfilUsuario;
    private char inativo;
    
    
    public Interno(){
        
    }

    public Interno(int id, int codigo, String nome, char cpf, char ddd, char telefone, String usuario, String senha, PerfilUsuario perfilUsuario, char inativo) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.ddd = ddd;
        this.telefone = telefone;
        this.usuario = usuario;
        this.senha = senha;
        this.perfilUsuario = perfilUsuario;
        this.inativo = inativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getCpf() {
        return cpf;
    }

    public void setCpf(char cpf) {
        this.cpf = cpf;
    }

    public char getDdd() {
        return ddd;
    }

    public void setDdd(char ddd) {
        this.ddd = ddd;
    }

    public char getTelefone() {
        return telefone;
    }

    public void setTelefone(char telefone) {
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
        int hash = 5;
        hash = 47 * hash + this.id;
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
    
    
    
}
