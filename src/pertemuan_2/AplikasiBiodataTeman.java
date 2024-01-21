/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan_2;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author HD-PC
 */
public class AplikasiBiodataTeman extends JFrame {
    public AplikasiBiodataTeman() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel labelInput1 = new JLabel("Input Nama : ");
        labelInput1.setBounds(130, 40, 120, 20);
        
        JTextField textField1 = new JTextField();
        textField1.setBounds(130, 70, 120, 30);
        
        JLabel labelInput2 = new JLabel("Input No. Telp : ");
        labelInput2.setBounds(130, 120, 120, 20);
        
        JTextField textField2 = new JTextField();
        textField2.setBounds(130, 150, 120, 30);
        
        JButton button = new JButton("Klik");
        button.setBounds(130, 200, 120, 40);
        
        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(110, 250, 160, 180);
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textField1.getText();
                String telp = textField2.getText();
                txtOutput.append(nama + " = " + telp + "\n");
                textField1.setText("");
                textField2.setText("");
            }
        });
        
        this.add(button);
        this.add(textField1);
        this.add(textField2);
        this.add(labelInput1);
        this.add(labelInput2);
        this.add(txtOutput);
        
        this.setSize(400, 500);
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
