/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Client;
import Model.DAO.AgendamentoDAO;
import static Model.DAO.Banco.agendamento;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;

/**
 *
 * @author wesle
 */
public class AgendaController {
    
        private final Agenda view;
        private final AgendaHelper helper;
        

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
        
    }

    
    
    public void atualizaTabela(){
        //buscar uma lista com os agendamentos com o BD 
            AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
            ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        //exibir esta lista na view
            helper.preencherTabela(agendamentos);
    }
        
    
    public void atualizaCliente(){
        //Buscar clientes do BD
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Client> clientes = clienteDAO.selectAll();
        
        //Exibir clientes no combobox cliente
        helper.preecherClientes(clientes);
    }

    
    public void atualizaServico(){
        //buscar servicos no BD
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        
        //exibir servicos no BD
        helper.preencherServicos(servicos);
    }
   
    public void atualizaValor(){
        //buscar valor dentro do BD
        Servico servico = helper.obterServico();
        helper.setarValor(servico.getValor());
    }
    
    public void agendar(){
        //buscar objeto agendamento da tela
        Agendamento agendamento = helper.obterModelo();
        
        //helper.buscarAgendamento();
        new AgendamentoDAO().insert(agendamento);
        //salva objeto no BD
        atualizaTabela();
        helper.limparTela();
    }
}
