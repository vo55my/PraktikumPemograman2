/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan_7;

import pertemuan_6.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

/**
 *
 * @author HD-PC
 */
class BiodataTableModel extends AbstractTableModel {
    private String[] columnNames = {"Nama", "No. HP", "Jenis Kelamin", "Alamat"};
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public int getRowCount() {
        return data.size();
    }
    
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public Object getValueAt(int row, int col) {
        List<String> rowItem = data.get(row);
        return rowItem.get(col);
    }
    
    public boolean isCellEditable(int row, int col) {
        return true;
    }
    
    public void add(ArrayList<String> value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public void removeRow(int selectedRow) {
        if (selectedRow >= 0 && selectedRow < data.size()) {
            data.remove(selectedRow);
            fireTableRowsDeleted(selectedRow, selectedRow);
        }
    }
}