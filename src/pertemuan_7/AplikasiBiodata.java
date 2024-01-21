/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan_7;

import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AplikasiBiodata extends JFrame {
    private boolean checkBoxSelected;

    public AplikasiBiodata() {
        this.checkBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirmResult = JOptionPane.showConfirmDialog(AplikasiBiodata.this, "Anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirmResult == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

        JLabel labelInput1 = new JLabel("Nama : ");
        labelInput1.setBounds(15, 40, 350, 10);

        JTextField textField1 = new JTextField();
        textField1.setBounds(15, 60, 350, 30);

        JLabel labelInput2 = new JLabel("Nomor HP : ");
        labelInput2.setBounds(15, 100, 350, 10);

        JTextField textField2 = new JTextField();
        textField2.setBounds(15, 120, 350, 30);

        JLabel labelInput3 = new JLabel("Jenis Kelamin : ");
        labelInput3.setBounds(15, 160, 350, 10);

        JRadioButton radioButton1 = new JRadioButton("Laki-laki", true);
        radioButton1.setBounds(15, 170, 350, 30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15, 190, 350, 30);

        JLabel labelInput4 = new JLabel("Alamat : ");
        labelInput4.setBounds(15, 220, 350, 10);

        JTextArea txtInput = new JTextArea("");
        txtInput.setBounds(15, 240, 350, 100);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        JButton simpan = new JButton("Simpan");
        simpan.setBounds(15, 350, 100, 40);

        JButton edit = new JButton("Edit");
        edit.setBounds(120, 350, 100, 40);

        JButton hapus = new JButton("Hapus");
        hapus.setBounds(225, 350, 100, 40);

        JButton save = new JButton("Simpan Ke File");
        save.setBounds(330, 350, 120, 40);

        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 400, 550, 130);

        BiodataTableModel tableModel = new BiodataTableModel();
        table.setModel(tableModel);

        simpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textField1.getText();
                String hp = textField2.getText();
                String jenisKelamin = "";
                textField1.setText("");
                textField2.setText("");

                if (radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText();
                }
                if (radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText();
                }

                String alamat = txtInput.getText();
                txtInput.setText("");

                if (nama.isEmpty() || hp.isEmpty() || jenisKelamin.isEmpty()) {
                    JOptionPane.showMessageDialog(AplikasiBiodata.this, "Harap isi semua inputan!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    int confirmResult = JOptionPane.showConfirmDialog(AplikasiBiodata.this, "Apakah data yang diisi sudah benar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                    if (confirmResult == JOptionPane.YES_OPTION) {
                        tableModel.add(new ArrayList<>(Arrays.asList(nama, hp, jenisKelamin, alamat)));
                    }
                }
            }
        });

        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String nama = textField1.getText();
                    String hp = textField2.getText();
                    String jenisKelamin = "";
                    String alamat = txtInput.getText();

                    if (nama.isEmpty() || hp.isEmpty()) {
                        JOptionPane.showMessageDialog(AplikasiBiodata.this, "Harap isi Nama dan Nomor HP!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    if (radioButton1.isSelected()) {
                        jenisKelamin = radioButton1.getText();
                    }
                    if (radioButton2.isSelected()) {
                        jenisKelamin = radioButton2.getText();
                    }

                    if (jenisKelamin.isEmpty()) {
                        // Add a check to see if no radio button is selected
                        JOptionPane.showMessageDialog(AplikasiBiodata.this, "Harap pilih jenis kelamin!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    // Update the selected row in the table with the edited data
                    tableModel.setValueAt(nama, selectedRow, 0);
                    tableModel.setValueAt(hp, selectedRow, 1);
                    tableModel.setValueAt(jenisKelamin, selectedRow, 2);
                    tableModel.setValueAt(alamat, selectedRow, 3);

                    // Clear the input fields
                    textField1.setText("");
                    textField2.setText("");
                    txtInput.setText("");
                    radioButton1.setSelected(true); // Reset the radio button to the default
                } else {
                    JOptionPane.showMessageDialog(AplikasiBiodata.this, "Pilih baris untuk mengedit data!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
            }
        });



        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(AplikasiBiodata.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        File file = fileChooser.getSelectedFile();
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                        for (int i = 0; i < tableModel.getRowCount(); i++) {
                            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                                writer.write(tableModel.getValueAt(i, j).toString());
                                writer.write("\t");
                            }
                            writer.newLine();
                        }
                        writer.close();
                        JOptionPane.showMessageDialog(AplikasiBiodata.this, "Data berhasil disimpan ke file.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(AplikasiBiodata.this, "Gagal menyimpan data ke file.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        this.add(simpan);
        this.add(edit);
        this.add(hapus);
        this.add(save);
        this.add(textField1);
        this.add(textField2);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(labelInput1);
        this.add(labelInput2);
        this.add(labelInput3);
        this.add(labelInput4);
        this.add(txtInput);
        this.add(scrollableTable);

        this.setSize(600, 600);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AplikasiBiodata a = new AplikasiBiodata();
                a.setVisible(true);
            }
        });
    }
}