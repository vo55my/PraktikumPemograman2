/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan_6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author HD-PC
 */
public class HelloMessageDialog extends JFrame {
    public HelloMessageDialog() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        JButton button = new JButton("Klik");
        button.setBounds(130, 100, 100, 40);
        
        JButton error = new JButton("Error");
        error.setBounds(130, 100, 100, 40);
        
        JButton info = new JButton("Information");
        info.setBounds(130, 100, 100, 40);
        
        JButton warning = new JButton("Warning");
        info.setBounds(130, 100, 100, 40);
        
        JButton question = new JButton("Question");
        info.setBounds(130, 100, 100, 40);
        
        JButton plain = new JButton("Plain");
        info.setBounds(330, 300, 100, 40);
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HelloMessageDialog.this, "Halo, Selamat Datang di Praktikum Pemograman II.");
            }
        });
        
        error.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HelloMessageDialog.this, "Error Message", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        info.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HelloMessageDialog.this, "Information Message", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        warning.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HelloMessageDialog.this, "Warning Message", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
        
        question.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HelloMessageDialog.this, "Question Message", "Question", JOptionPane.QUESTION_MESSAGE);
            }
        });
        
        plain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HelloMessageDialog.this, "Plain Message", "Plain", JOptionPane.PLAIN_MESSAGE);
            }
        });
        
        this.add(button);
        this.add(error);
        this.add(info);
        this.add(warning);
        this.add(question);
        this.add(plain);
        
        this.setSize(200, 200);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloMessageDialog h = new HelloMessageDialog();
                h.setVisible(true);
            }
        });
    }
}
