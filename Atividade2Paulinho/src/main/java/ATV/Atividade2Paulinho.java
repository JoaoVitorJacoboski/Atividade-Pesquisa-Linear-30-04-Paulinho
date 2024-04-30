package ATV;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

public class Atividade2Paulinho {

    public static void main(String[] args) {
        
       ArrayList<Cliente> clientes = new ArrayList<>();

        // Preencher a lista de clientes
        int quantidadeClientes = Integer.parseInt(JOptionPane.showInputDialog("Quantos clientes deseja cadastrar?"));
        
        for (int i = 0; i < quantidadeClientes; i++) {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código do Cliente " + (i + 1) + ":"));
            String nome = JOptionPane.showInputDialog("Nome do Cliente " + (i + 1) + ":");
            String dataNascimento = JOptionPane.showInputDialog("Data de Nascimento do Cliente " + (i + 1) + ":");
            String cpf = JOptionPane.showInputDialog("CPF do Cliente " + (i + 1) + ":");
            
            Cliente cliente = new Cliente(codigo, nome, dataNascimento, cpf);
            clientes.add(cliente);
        }

        // Ordenar os clientes pelo código
        Collections.sort(clientes, Comparator.comparingInt(Cliente::getCodigo));

        // Exibir os clientes ordenados
        StringBuilder message = new StringBuilder("Clientes ordenados pelo código:\n");
        for (Cliente cliente : clientes) {
            message.append(cliente.getCodigo()).append(" - ").append(cliente.getNome()).append("\n");
        }
        JOptionPane.showMessageDialog(null, message.toString());

        // Solicitar código do cliente para pesquisa
        int codigoPesquisa = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do cliente a ser pesquisado:"));

        // Realizar pesquisa linear
        Cliente clienteEncontrado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getCodigo() == codigoPesquisa) {
                clienteEncontrado = cliente;
                break;
            }
        }

        // Exibir resultado da pesquisa
        if (clienteEncontrado != null) {
            JOptionPane.showMessageDialog(null, 
                "Cliente encontrado:\n" +
                "Código: " + clienteEncontrado.getCodigo() + "\n" +
                "Nome: " + clienteEncontrado.getNome() + "\n" +
                "Data de Nascimento: " + clienteEncontrado.getDataNascimento() + "\n" +
                "CPF: " + clienteEncontrado.getCpf());
        } else {
            JOptionPane.showMessageDialog(null, "Cliente com o código informado não encontrado.");
        }
    }
}
