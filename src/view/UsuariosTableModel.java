/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Usuarios;

public class UsuariosTableModel extends AbstractTableModel {
    private List lista;
  
    public List getLita() {
        return lista;
    }
    public void setLista(List litas) {
        this.lista = litas;
    }    

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
       return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuarios usuarios = (Usuarios) lista.get(rowIndex);
        if(columnIndex==0)
          return usuarios.getMpvidUsuarios();
        if(columnIndex==1)
          return usuarios.getMpvNome();
        if(columnIndex==2)
          return usuarios.getMpvCpf();
        else
            return "";
    }
    
}
