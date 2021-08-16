/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

/**
 *
 * @author JD
 */
public class Cliente {
    
    private int codigo;
    private String nome;
    private String email;
    private char ddd;
    private char contato;
    
    public Cliente(){
        
    }

    public Cliente(int codigo, String nome, String email, char ddd, char contato) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.ddd = ddd;
        this.contato = contato;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getDdd() {
        return ddd;
    }

    public void setDdd(char ddd) {
        this.ddd = ddd;
    }

    public char getContato() {
        return contato;
    }

    public void setContato(char contato) {
        this.contato = contato;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.codigo;
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
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
    
    
    
}
