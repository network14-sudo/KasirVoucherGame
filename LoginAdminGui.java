package GUI;

import javax.imageio.ImageIO;
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

public class LoginAdminGui extends ComponentGui {
    String pathicon;
    public LoginAdminGui(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("Login Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelid.setBounds(35, 250, 40, 25);
        add(labelid);
        fieldid.setBounds(130, 250, 130, 25);
        add(fieldid);
        
        labelpassword.setBounds(35, 290, 80, 25);
        add(labelpassword);
        fieldpassword.setBounds(130, 290, 130, 25);
        add(fieldpassword);
        
        btnlogin.setBounds(110, 350, 100, 25);
        btnlogin.setBackground(Color.black);
        btnlogin.setForeground(Color.white);
        btnlogin.setBorder(null);
        add(btnlogin);
        
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
        
        bingkaigambar.setBounds(80, 70, 150, 150);
        add(bingkaigambar);
        
        pathicon = ".\src\\Images\\admin.png";
        
        try{
            bufferedImage = ImageIO.read(new File(pathicon));
        } catch (IOException ex) {
            Logger.getLogger(LoginAdminGui.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        gambarresize = bufferedImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        bingkaigambar.setIcon(new ImageIcon(gambarresize));
        
        btnlogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnlogin.setForeground(Color.black);
                btnlogin.setBackground(Color.green);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnlogin.setForeground(Color.white);
                btnlogin.setBackground(Color.black);
            }
        });
        
        btnlogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String id = fieldid.getText();
                String password = fieldpassword.getText();
                AllObjectController.admin.login(id, password);
                    dispose();
                    MenuAdmin menuA = new MenuAdmin();
                    menuA.setVisible(true);
            }
        });
    }
} 