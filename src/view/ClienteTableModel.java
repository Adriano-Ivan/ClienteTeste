/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Cliente;

/**
 *
 * @author superior
 */
public class ClienteTableModel extends AbstractTableModel{

    public static final int COL_CODIGO = 0;
    public static final int COL_NOME = 1;
    public static final int COL_EMAIL = 2;
    public static final int COL_IDADE = 3;
    public static final int COL_CPF = 4;
    public static final int COL_TELEFONE = 5;
    public static final int COL_CARTAO_EXCLUSIVO = 6;
    
    public ArrayList<Cliente> listaClientes;
    
    public ClienteTableModel(ArrayList<Cliente> alClientes){
        listaClientes = new ArrayList<Cliente>(alClientes);
    }
    
    @Override
    public int getRowCount() {
        return this.listaClientes.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int linhas, int colunas) {
        Cliente cliente = listaClientes.get(linhas);
        if(colunas == COL_CODIGO){return cliente.getCodigo();}
        if(colunas == COL_NOME){return cliente.getNome();}
        if(colunas == COL_EMAIL){return cliente.getEmail();}
        if(colunas == COL_CPF){return cliente.getCPF();}
        if(colunas == COL_TELEFONE){return cliente.getTelefone();}
        if(colunas == COL_IDADE){return cliente.getIdade();}
        if(colunas == COL_CARTAO_EXCLUSIVO){return cliente.getCartaoExclusivo();}
        return "";
    }
    public String getColumnName(int colunas){
        if(colunas == COL_CODIGO){return "Código";}
        if(colunas == COL_NOME){return "Nome";}
        if(colunas == COL_EMAIL){return "Email";}
        if(colunas == COL_CPF){return "CPF";}
        if(colunas == COL_IDADE){return "Idade";}
        if(colunas == COL_TELEFONE){return "Telefone";}
        if(colunas == COL_CARTAO_EXCLUSIVO){return "Cartão Exclusivo";}
        return "";
    }
}
