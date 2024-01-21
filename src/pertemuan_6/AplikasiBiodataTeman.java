/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan_6;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

/**
 *
 * @author HD-PC
 */
public class AplikasiBiodataTeman extends JFrame {
    private boolean checkBoxSelected;
    
    public AplikasiBiodataTeman() {
        this.checkBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel labelInput1 = new JLabel("Nama : ");
        labelInput1.setBounds(15,40,350,10);
        
        JTextField textField1 = new JTextField();
        textField1.setBounds(15, 60, 350, 30);
        
        JLabel labelInput2 = new JLabel("Nomor HP : ");
        labelInput2.setBounds(15,100,350,10);
        
        JTextField textField2 = new JTextField();
        textField2.setBounds(15, 120, 350, 30);
        
        JLabel labelInput3 = new JLabel("Jenis Kelamin : ");
        labelInput3.setBounds(15,160,350,10);
        
        JRadioButton radioButton1 = new JRadioButton("Laki-laki", true);
        radioButton1.setBounds(15, 170, 350, 30);
        
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15, 190, 350, 30);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15, 220, 350, 30);
        
        JButton button = new JButton("Simpan");
        button.setBounds(15, 260, 100, 40);
        
        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 310, 350, 130);
        
        BiodataTableModel tableModel = new BiodataTableModel();
        table.setModel(tableModel);
        
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange()==1;
            }
        });
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textField1.getText();
                String hp = textField2.getText();
                String jenisKelamin = "";
                textField1.setText("");
                textField2.setText("");
                
                if(radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText();
                }
                if (radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText();
                }
                
                if (checkBoxSelected) {
                   tableModel.add(new ArrayList<>(Arrays.asList(nama, hp, jenisKelamin, "Ya")));
                } else {
                   tableModel.add(new ArrayList<>(Arrays.asList(nama, hp, jenisKelamin, "Bukan")));
                }
            }
        });
        
        this.add(button);
        this.add(textField1);
        this.add(textField2);
        this.add(checkBox);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(labelInput1);
        this.add(labelInput2);
        this.add(labelInput3);
        this.add(scrollableTable);
        
        this.setSize(400,500);
        this.setLayout(null);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AplikasiBiodataTeman a = new AplikasiBiodataTeman();
                a.setVisible(true);
            }
        });
    }
}
