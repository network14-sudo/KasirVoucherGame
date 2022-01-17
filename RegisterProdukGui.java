package GUI;

import Controller.ObjectModelController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Entity.*;

public class RegisterProdukGui extends ComponentGui {
    public RegisterProdukGui(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("Tambah Produk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);
        setVisible(true);
        
        labelregister.setText("TAMBAH PRODUK");
        labelregister.setBounds(100, 50, 150, 25);
        add(labelregister);
        labelNP.setBounds(35, 95, 100, 25);
        add(labelNP);
        fieldNP.setBounds(130, 95, 130, 25);
        add(fieldNP);
        
        labelnominal.setBounds(35, 140, 80, 25);
        add(labelnominal);
        fieldnominal.setBounds(130, 140, 130, 25);
        add(fieldnominal);
        
        labelharga.setBounds(35, 190, 80, 25);
        add(labelharga);
        fieldharga.setBounds(130, 190, 130, 25);
        add(fieldharga);
        
        btnback.setBounds(10, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        btnback.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnback.setForeground(Color.yellow);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnback.setForeground(Color.black);
            }
        });
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                MenuTransaksi menuT = new MenuTransaksi();
                menuT.setVisible(true);
                dispose();
            }
        });
        
        btnregister.setBounds(80, 220, 140, 25);
        btnregister.setBorder(null);
        btnregister.setBackground(Color.black);
        btnregister.setForeground(Color.white);
        btnregister.setFocusPainted(false);
        add(btnregister);
        
        btnregister.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnregister.setForeground(Color.black);
                btnregister.setBackground(Color.green);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnregister.setForeground(Color.white);
                btnregister.setBackground(Color.black);
            }
        });
        
        btnregister.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String NP = fieldNP.getText();
                String nominal = fieldnominal.getText();
                String harga = fieldharga.getText();
                if(NP.length() != 0 && nominal.length() != 0 && harga.length() != 0){
                    ProdukEntity produk = new ProdukEntity();
                    produk.setNamaproduk(NP);
                    produk.setNominal(nominal);
                    produk.setHarga(harga);
                    ObjectModelController.transaksi.insertProduk(produk);
                    JOptionPane.showMessageDialog(null, NP + "Berhasil ditambahkan");
                    dispose();
                    new MenuTransaksi().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });
    }
}
