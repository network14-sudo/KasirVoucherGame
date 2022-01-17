package GUI;

import Entity.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransaksiGui extends ComponentGui {
    int Nomortrx; boolean status;
    String Idgame, nama, namaAkun, noTelp, namaProduk, nominal, harga, path;
    String filemove = "./src/Images/";
    
    File file;
    public TransaksiGui(){
        initComponent();
    }
    
    void initComponent(){
        try{
            String inputidg = JOptionPane.showInputDialog("Masukkan Nomortrx");
            fieldnomortrx.setText(inputidg);
            int id = Integer.parseInt(fieldnomortrx.getText());
            if(inputidg.length() > 0){
            for(TransaksiEntity trx : AllObjectController.trx.showData(id)) {
                
                this.Nomortrx       = trx.getNomortrx();
                this.Idgame       = trx.pembeli.getIDGame();
                this.nama     = trx.pembeli.getNama();
                this.namaAkun      = trx.pembeli.getNamaakun();
                this.noTelp   = trx.pembeli.getNoTelp();
                this.namaProduk   = trx.produk.getNamaproduk();
                this.nominal   = trx.produk.getNominal();
                this.harga   = trx.produk.getHarga();
                this.status   = trx.isStatustrx();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Data Kosong");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Cancelled");
        }
        
        setTitle("PROGRAM MENU TRANSAKSI");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,450);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        btnback.setBounds(10, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        labelnomortrx.setBounds(25, 50, 120, 25);
        add(labelnomortrx);
        fieldnomortrx.setBounds(150, 50, 120, 25);
        fieldnomortrx.setEditable(false);
        add(fieldnomortrx);
        
        labelIDGame.setBounds(25, 90, 120, 25);
        add(labelIDGame);
        fieldIDGame.setBounds(150, 90, 120, 25);
        fieldIDGame.setText(Idgame);
        fieldIDGame.setEditable(false);
        add(fieldIDGame);
        
        labelnama.setBounds(25, 130, 120, 25);
        add(labelnama);
        fieldnama.setBounds(150, 130, 120, 25);
        fieldnama.setText(nama);
        fieldnama.setEditable(false);
        add(fieldnama);
        
        labelNA.setBounds(25, 170, 120, 25);
        add(labelNA);
        fieldNA.setBounds(150, 170, 120, 25);
        fieldNA.setText(namaAkun);
        fieldNA.setEditable(false);
        add(fieldNA);
        
        labelnotelp.setBounds(25, 210, 120, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(150, 210, 120, 25);
        fieldnotelp.setText(noTelp);
        fieldnotelp.setEditable(false);
        add(fieldnotelp);
        
        labelNP.setBounds(25, 250, 120, 25);
        add(labelNP);
        fieldNP.setBounds(150, 250, 120, 25);
        fieldNP.setText(namaProduk);
        fieldNP.setEditable(false);
        add(fieldNP);
        
        labelnominal.setBounds(25, 290, 120, 25);
        add(labelnominal);
        fieldnominal.setBounds(150, 290, 120, 25);
        fieldnominal.setText(nominal);
        fieldnominal.setEditable(false);
        add(fieldnominal);
        
        labelharga.setBounds(25, 330, 120, 25);
        add(labelharga);
        fieldharga.setBounds(150, 330, 120, 25);
        fieldharga.setText(harga);
        fieldharga.setEditable(false);
        add(fieldharga);
        
        labelstatus.setBounds(25, 370, 120, 25);
        add(labelstatus);
        fieldstatus.setBounds(150, 370, 120, 25);
        String sts=String.valueOf(status);
        fieldstatus.setText(sts);
        fieldstatus.setEditable(false);
        add(fieldstatus);
        
        bingkaigambar.setBounds(50, 225, 150, 200);
        add(bingkaigambar);
        
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
                Menu menu = new Menu();
                menu.setVisible(true);
                dispose();
            }
        });
        
    }
}
