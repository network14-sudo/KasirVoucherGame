package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Entity.*;

public class RegisterPembeliGui extends ComponentGui {
    public RegisterPembeliGui(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("Register Pembeli");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setVisible(true);
        
        labelregister.setText("REGISTER PEMBELI");
        labelregister.setBounds(100, 50, 150, 25);
        add(labelregister);
        labelnama.setBounds(35, 95, 40, 25);
        add(labelnama);
        fieldnama.setBounds(130, 95, 130, 25);
        add(fieldnama);
        
        labelIDGame.setBounds(35, 140, 80, 25);
        add(labelIDGame);
        fieldIDGame.setBounds(130, 140, 130, 25);
        add(fieldIDGame);
        
        labelNA.setBounds(35, 185, 80, 25);
        add(labelNA);
        fieldNA.setBounds(130, 185, 130, 25);
        add(fieldNA);
        
        labelnotelp.setBounds(35, 230, 80, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(130, 230, 130, 25);
        add(fieldnotelp);
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
                Menu menu = new Menu();
                menu.setVisible(true);
                dispose();
            }
        });
        
        btnregister.setBounds(80, 350, 140, 25);
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
                String nama = fieldnama.getText();
                String IDGame = fieldIDGame.getText();
                String namaAkun = fieldNA.getText();
                String notelp = fieldnotelp.getText();
                if(nama.length() != 0 && IDGame.length() != 0 && namaAkun.length() != 0 && notelp.length() != 0){
                    PembeliEntity pem = new PembeliEntity();
                    pem.setIDGame(IDGame);
                    pem.setNama(nama);
                    pem.setNamaakun(namaAkun);
                    pem.setNoTelp(notelp);
                    AllObjectController.pembeli.daftar(pem);
                    JOptionPane.showMessageDialog(null, nama + "adalah Pembeli");
                    dispose();
                    new MenuPembeli().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });
    }
}
