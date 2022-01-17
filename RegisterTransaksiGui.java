package GUI;

import Controller.ObjectModelController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Entity.*;

public class RegisterTransaksiGui extends ComponentGui {
    public RegisterTransaksiGui(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("Register Transaksi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);
        setVisible(true);
        
        labelregister.setText("REGISTER TRANSAKSI");
        labelregister.setBounds(100, 50, 150, 25);
        add(labelregister);
        
        labelnomortrx.setBounds(35, 100, 120, 25);
        add(labelnomortrx);
        fieldnomortrx.setBounds(130, 100, 130, 25);
        add(fieldnomortrx);
        
        labelnama.setBounds(35, 140, 40, 25);
        add(labelnama);
        fieldnama.setBounds(130, 140, 130, 25);
        add(fieldnama);
        
        labelIDGame.setBounds(35, 180, 80, 25);
        add(labelIDGame);
        fieldIDGame.setBounds(130, 180, 130, 25);
        add(fieldIDGame);
        
        labelNA.setBounds(35, 220, 80, 25);
        add(labelNA);
        fieldNA.setBounds(130, 220, 130, 25);
        add(fieldNA);
        
        labelnotelp.setBounds(35, 260, 80, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(130, 260, 130, 25);
        add(fieldnotelp);
        
        labelNP.setBounds(35, 300, 110, 25);
        add(labelNP);
        fieldNP.setBounds(130, 300, 130, 25);
        add(fieldNP);
        
        labelnominal.setBounds(35, 340, 80, 25);
        add(labelnominal);
        fieldnominal.setBounds(130, 340, 130, 25);
        add(fieldnominal);
        
        labelharga.setBounds(35, 380, 80, 25);
        add(labelharga);
        fieldharga.setBounds(130, 380, 130, 25);
        add(fieldharga);
        
        labelstatus.setBounds(35, 420, 80, 25);
        add(labelstatus);
        fieldstatus.setBounds(130, 420, 130, 25);
        add(fieldstatus);
        
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
        
        btnregister.setBounds(80, 450, 140, 25);
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
                String nomor = fieldnomortrx.getText();;
                String nama = fieldnama.getText();
                String IDGame = fieldIDGame.getText();
                String namaAkun = fieldNA.getText();
                String notelp = fieldnotelp.getText();
                String NP = fieldNP.getText();
                String nominal = fieldnominal.getText();
                String harga = fieldharga.getText();
                String sts = fieldstatus.getText();
                if(nomor.length() != 0 && nama.length() != 0 && IDGame.length() != 0 && namaAkun.length() != 0 && notelp.length() != 0 && NP.length() != 0  && nominal.length() != 0 && harga.length() != 0){
                    int nomortrx = Integer.parseInt(nomor);
                    boolean status = Boolean.parseBoolean(sts);
                    PembeliEntity pem = new PembeliEntity();
                    ProdukEntity pro = new ProdukEntity();
                    pem.setIDGame(IDGame);
                    pem.setNama(nama);
                    pem.setNamaakun(namaAkun);
                    pem.setNoTelp(notelp);
                    AllObjectController.pembeli.daftar(pem);
                    pro.setHarga(harga);
                    pro.setNamaproduk(NP);
                    pro.setNominal(nominal);
                    TransaksiEntity trans = new TransaksiEntity();
                    trans.setNomortrx(nomortrx);
                    trans.setStatustrx(status);
                    AllObjectController.trx.insertDataPembeli(nomortrx, pem, pro, status);
                    JOptionPane.showMessageDialog(null, nama + "Berhasil Ditambahkan");
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
