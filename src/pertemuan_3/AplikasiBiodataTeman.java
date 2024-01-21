/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan_3;

import java.awt.event.*;
import javax.swing.*;

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
        
        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 320, 350, 120);
        
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
                txtOutput.append("Nama : " + nama + "\n");
                txtOutput.append("Nomor HP : " + hp + "\n");
                textField1.setText("");
                textField2.setText("");
                
                if(radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText();
                }
                if (radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText();
                }
                
                txtOutput.append("Jenis Kelamin : " + jenisKelamin + "\n");
                
                if (checkBoxSelected) {
                    txtOutput.append("WNA : Ya");
                } else {
                    txtOutput.append("WNA : Bukan");
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
        this.add(txtOutput);
        
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
