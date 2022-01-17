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

public class PembeliGui extends ComponentGui {
    String Idgame, nama, namaAkun, noTelp, path;
    String filemove = "./src/Images/";
    
    File file;
    public PembeliGui(){
        initComponent();
    }
    
    void initComponent(){
        try{
            String inputidg = JOptionPane.showInputDialog("Masukkan ID Game");
            fieldIDGame.setText(inputidg);
            String id = fieldIDGame.getText();
            if(inputidg.length() > 0){
            for(PembeliEntity pem : AllObjectController.pembeli.pembeliEntity(id)) {
                this.Idgame       = pem.getIDGame();
                this.nama     = pem.getNama();
                this.namaAkun      = pem.getNamaakun();
                this.noTelp   = pem.getNoTelp();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Data Kosong");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Cancelled");
        }
        
        setTitle("PROGRAM DATA PEMBELI");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,380);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        btnback.setBounds(10, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        labelIDGame.setBounds(25, 50, 120, 25);
        add(labelIDGame);
        fieldIDGame.setBounds(150, 50, 120, 25);
        fieldIDGame.setEditable(false);
        add(fieldIDGame);
        
        labelnama.setBounds(25, 90, 120, 25);
        add(labelnama);
        fieldnama.setBounds(150, 90, 120, 25);
        fieldnama.setText(nama);
        fieldnama.setEditable(false);
        add(fieldnama);
        
        labelNA.setBounds(25, 135, 120, 25);
        add(labelNA);
        fieldNA.setBounds(150, 135, 120, 25);
        fieldNA.setText(namaAkun);
        fieldNA.setEditable(false);
        add(fieldNA);
        
        labelnotelp.setBounds(25, 180, 120, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(150, 180, 120, 25);
        fieldnotelp.setText(noTelp);
        fieldnotelp.setEditable(false);
        add(fieldnotelp);
        
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
                MenuPembeli menuPem = new MenuPembeli();
                menuPem.setVisible(true);
                dispose();
            }
        });
        
    }
}
