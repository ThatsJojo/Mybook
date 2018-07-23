/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import model.Usuario;

/**
 *
 * @author Mateus
 */
public class ControllerLogin {
    public Usuario login(String login, String senha) throws SenhaIncorretaException, UsuarioInexistenteException{
        Usuario user = desserializarUser(login);
        if(user == null)
            throw new UsuarioInexistenteException();
        else if(!user.getSenha().equals(senha))
            throw new SenhaIncorretaException();
        else return user;
    }
    private Usuario desserializarUser(String login){
        Usuario user;
        try
          {
             FileInputStream fileIn = new FileInputStream("Users/" + login + "/" + login + ".user");
             ObjectInputStream in = new ObjectInputStream(fileIn);
             user = (Usuario) in.readObject();
             in.close();
             fileIn.close();
          }catch(IOException | ClassNotFoundException i)
          {
            return null;
          }
          
          return user;
    }
    public class SenhaIncorretaException extends Exception{
        
    }
    public class UsuarioInexistenteException extends Exception{
        
    }
}
