package GUI;

import javax.imageio.ImageIO;
import java.awt.image.ColorModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuTransaksi extends ComponentGui {
    String pathicon;
    
    public MenuTransaksi(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("MENU TRANSAKSI");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,350);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.gray.brighter());
        setLayout(null);
        setVisible(true);
        
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
        
        btnLDT.setBounds(90, 100, 200, 25);
        btnLDT.setBackground(Color.blue.brighter());
        btnLDT.setForeground(Color.WHITE);
        btnLDT.setBorder(null);
        add(btnLDT);
        
        btnnotregT.setBounds(90, 50, 200, 25);
        btnnotregT.setBackground(Color.blue.brighter());
        btnnotregT.setForeground(Color.WHITE);
        btnnotregT.setBorder(null);
        add(btnnotregT);
        
        btnnotregProduk.setBounds(90, 150, 200, 25);
        btnnotregProduk.setBackground(Color.blue.brighter());
        btnnotregProduk.setForeground(Color.WHITE);
        btnnotregProduk.setBorder(null);
        add(btnnotregProduk);
        
        bingkaigambar.setBounds(0, 0, 400, 350);
        add(bingkaigambar);
        
        pathicon = "./src/Images/g1.png";
        
        try{
            bufferedImage = ImageIO.read(new File(pathicon));
        } catch (IOException ex) {
            Logger.getLogger(MenuTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        gambarresize = bufferedImage.getScaledInstance(400, 350,    Image.SCALE_SMOOTH);
        bingkaigambar.setIcon(new ImageIcon(gambarresize));
        
        btnnotregT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                btnnotregT.setForeground(Color.black);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnnotregT.setForeground(Color.white);
            }
        });
        btnnotregT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegisterTransaksiGui().setVisible(true);
            }
        });
        
        btnLDT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                btnLDT.setForeground(Color.black);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnLDT.setForeground(Color.white);
            }
        });
        
        btnLDT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                TransaksiGui trx = new TransaksiGui();
                trx.setVisible(true);
            }
        });
        
        btnnotregProduk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                btnnotregProduk.setForeground(Color.black);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnnotregProduk.setForeground(Color.white);
            }
        });
        btnnotregProduk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegisterProdukGui().setVisible(true);
            }
        });
        
    }
}

