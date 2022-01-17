package GUI;

import Entity.*;
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

public class MenuAdmin extends ComponentGui {
    String pathicon;
    
    public MenuAdmin(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("MENU");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,350);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.gray.brighter());
        setLayout(null);
        setVisible(true);
        
        btnback.setBounds(25, 20, 80, 25);
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
                LoginAdminGui loginAdminGui = new LoginAdminGui();
                loginAdminGui.setVisible(true);
                dispose();
            }
        });
        
        btnLDA.setBounds(80, 100, 200, 25);
        btnLDA.setBackground(Color.blue.brighter());
        btnLDA.setForeground(Color.WHITE);
        btnLDA.setBorder(null);
        add(btnLDA);
        
        btnnotregA.setText("REGISTRASI ADMIN");
        btnnotregA.setBounds(80, 50, 200, 25);
        btnnotregA.setFocusPainted(false);
        btnnotregA.setBorder(null);
        btnnotregA.setBackground(Color.blue.brighter());
        btnnotregA.setForeground(Color.white);
        add(btnnotregA);
        
        btndelete.setBounds(80, 150, 200, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.blue.brighter());
        btndelete.setForeground(Color.white);
        add(btndelete);
        
        btndelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                btndelete.setForeground(Color.black);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btndelete.setForeground(Color.white);
            }
        });
        
        bingkaigambar.setBounds(0, 0, 400, 350);
        add(bingkaigambar);
        
        pathicon = "./src/Images/g1.png";
        
        try{
            bufferedImage = ImageIO.read(new File(pathicon));
        } catch (IOException ex) {
            Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        gambarresize = bufferedImage.getScaledInstance(400, 350,    Image.SCALE_SMOOTH);
        bingkaigambar.setIcon(new ImageIcon(gambarresize));
        
        btnnotregA.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                btnnotregA.setForeground(Color.black);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnnotregA.setForeground(Color.white);
            }
        });
        btnnotregA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegisterAdminGui().setVisible(true);
            }
        });
        
        btnLDA.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                btnLDA.setForeground(Color.black);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnLDA.setForeground(Color.white);
            }
        });
        
        btnLDA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AdminGui admin = new AdminGui();
                admin.setVisible(true);
            }
        });
        
        btndelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputNomortrx = JOptionPane.showInputDialog("Masukkan Nomortrx yang ingin dihapus ");
                    int Nomortrx = Integer.parseInt(inputNomortrx);
                    if(inputNomortrx.length() > 0){
                        AllObjectController.admin.delete(Nomortrx);
                        JOptionPane.showMessageDialog(null, "Berhasil Menghapus Data Transaksi");
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahNA.setText("UBAH NAMA AKUN");
        btnubahNA.setBounds(80, 200, 200, 25);
        btnubahNA.setFocusPainted(false);
        btnubahNA.setBorder(null);
        btnubahNA.setBackground(Color.blue.brighter());
        btnubahNA.setForeground(Color.white);
        add(btnubahNA);
        
        btnubahNA.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                btnubahNA.setForeground(Color.black);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnubahNA.setForeground(Color.white);
            }
        });
        
        btnubahNA.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputID = JOptionPane.showInputDialog("Masukkan Nomortrx yang akan diupdate");
                    int ID = Integer.parseInt(inputID);
                    String inputNA = JOptionPane.showInputDialog("Masukkan Nama Akun Baru");
                    if(inputNA.length() > 0){
                        TransaksiEntity Transaksi = new TransaksiEntity();
                        PembeliEntity pembeli = new PembeliEntity();
                        pembeli.setNamaakun(inputNA);
                        Transaksi.setPembeli(pembeli);
                        AllObjectController.trx.updateNA(ID, Transaksi);
                        JOptionPane.showMessageDialog(null, "Berhasil Ubah Nama Akun");
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });

    }
}

