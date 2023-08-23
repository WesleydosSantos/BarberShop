/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.Login;
import View.MenuPrincipal;

/**
 *
 * @author wesle
 */
public class LoginController {

    private final Login view;
    private LoginHelper helper;
    
    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void entrarNoSistema(){
        
        //pegar um usuárop da view
        Usuario usuario = helper.obterModelo();
        
        //pesquisar usuario no banco
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado =  usuarioDAO.selectPorNomeESenha(usuario);
        
        //se usuario da view tiver o mesmo dado do usuario do banco redirecionar para menu principal
        //senao, mostrar uma mensagem ao usuario "Usuario ou senha invalido"
        if (usuarioAutenticado != null){
            //navegar para menu principal
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
        } else {
            view.exibeMensagem("Usuário ou senha inválidos");

        }
    }
    
    
    public void fizTarefa(){
            System.out.println("Busquei algo no BD");
            view.exibeMensagem("Executei a tarefa");
    }


    
}
