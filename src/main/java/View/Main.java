/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Agendamento;
import Model.Client;
import Model.Pessoa;
import Model.Servico;
import Model.Usuario;

/**
 *
 * @author wesle
 */
public class Main {
    
    
    public static void main(String[] args){
            Client cliente = new Client(1, "Juca", "Rua Urbano", "59225-000");
            System.out.println(cliente.getNome());
            
            Usuario usuario = new Usuario(1, "Tigre", "123");
            System.out.println(usuario.getNome());
            
            Servico servico = new Servico(1, "Limpeza", 30);
            
            Agendamento agendamento = new Agendamento(1, cliente, servico, 30,"20/08/2023  09:00"  );
            
            System.out.println(agendamento.getCliente().getNome());
            
    }   
    
}