/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan_5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author HD-PC
 */
public class AplikasiBiodataTeman extends JFrame {
    private boolean checkBoxSelected;
    private JTextField textField1;
    private JTextField textField2;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JTextArea txtOutput;
    
    public AplikasiBiodataTeman() {
        this.checkBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel headerLabel = new JLabel("Form Biodata", JLabel.CENTER);
        
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        
        JPanel panel = new JPanel();
        panel.setSize(600, 600);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nama:"),gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        textField1 = new JTextField(6);
        panel.add(textField1, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Nomor HP:"),gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        textField2 = new JTextField(6);
        panel.add(textField2, gbc);        
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(new JLabel("Jenis Kelamin:"),gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        radioButton1 = new JRadioButton("Laki-Laki");
        radioButton2 = new JRadioButton("Perempuan");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        panel.add(radioButton1, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(radioButton2, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        panel.add(checkBox, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        JButton button = new JButton("Simpan");
        panel.add(button, gbc);
        
        gbc.ipady = 60;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.gridheight = 6;
        txtOutput = new JTextArea(5, 10);
        panel.add(new JScrollPane(txtOutput), gbc);
        
        controlPanel.add(panel);
        
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
        
        this.setLayout(new GridLayout(2, 1));
        this.add(headerLabel);
        this.add(controlPanel);
        this.setSize(600, 600);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AplikasiBiodataTeman h = new AplikasiBiodataTeman();
                h.setVisible(true);
            }
        });
    }
}
