/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import model.Usuario;

/**
 *
 * @author Mateus
 */
public class ControllerRegistro {
    public void registrarUsuario(String nome, String login, String telefone, 
            String senha, String confirmarSenha) throws SenhaMalConfirmadaException{
        Usuario user;
        if(senha.equals(confirmarSenha)){
            user = new Usuario(nome, login, telefone, senha);
            serializarUsuario(user);
        }
        else{
            throw new SenhaMalConfirmadaException();
        }
    }
    public void serializarUsuario(Usuario user){
        try{
            File dir = new File("Users/" + user.getLogin());
            dir.mkdir();
            FileOutputStream arquivar = new FileOutputStream(dir.getPath() + "/" + user.getLogin() + ".user");
            ObjectOutputStream objArquivado = new ObjectOutputStream(arquivar);
            objArquivado.writeObject((Usuario)user);
            objArquivado.flush();
            objArquivado.close();
            arquivar.close();
        }catch(FileNotFoundException e){
        }catch(IOException e){
        }
    }
    public class SenhaMalConfirmadaException extends Exception{
        
    }
}
