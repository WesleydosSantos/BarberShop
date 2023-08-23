/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Usuario;
import View.Login;

/**
 *
 * @author wesle
 */
public class LoginHelper {
    
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public Usuario obterModelo(){
        String nome = view.getUsuario().getText();
        String senha = view.getSenha().getText();
        Usuario modelo = new Usuario(0, nome, senha);
        
        return modelo;      
    }
    
    public void setarModelo(Usuario modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha();
        
        view.getUsuario().setText(nome);
        view.getUsuario().setText(senha);
    }
        
    
    public void limparTela(){
        view.getUsuario().setText("");
        view.getSenha().setText("");
    }
}
