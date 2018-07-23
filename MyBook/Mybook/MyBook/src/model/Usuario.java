/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javafx.scene.image.Image;

/**
 *
 * @author Mateus
 */
public class Usuario implements Serializable{
    private String nome;
    private String login;
    private String telefone;
    private String senha;

    public Usuario(String nome, String login, String telefone, String senha) {
        this.nome = nome;
        this.login = login;
        this.telefone = telefone;
        this.senha = senha;
    }
    
    public String getUrl(){
        return "Users/" + login + "/"; 
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String setFotoPerfil(String foto){
        return "Users/" + login + "/" + foto;
    }
}
