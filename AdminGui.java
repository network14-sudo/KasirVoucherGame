package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Entity.*;

public class AdminGui extends ComponentGui {
    String Id, nama, pass, noTelp, path;
    
    public AdminGui(){
        initComponent();
    }
    
    void initComponent(){
        try{
            String inputidg = JOptionPane.showInputDialog("Masukkan ID Admin");
            fieldid.setText(inputidg);
            String id = fieldid.getText();
            if(inputidg.length() > 0){
            for(AdminEntity admin : AllObjectController.admin.showDataAdminEntity(id)) {
                this.Id       = admin.getId();
                this.nama     = admin.getNama();
                this.pass      = admin.getPassword();
                this.noTelp   = admin.getNoTelp();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Data Kosong");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Cancelled");
        }
        
        setTitle("DATA ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelid.setBounds(25, 50, 120, 25);
        add(labelid);
        fieldid.setBounds(150, 50, 120, 25);
        fieldid.setText(Id);
        fieldid.setEditable(false);
        add(fieldid);
        
        labelnama.setBounds(25, 90, 120, 25);
        add(labelnama);
        fieldnama.setBounds(150, 90, 120, 25);
        fieldnama.setText(nama);
        fieldnama.setEditable(false);
        add(fieldnama);
        
        labelpassword.setBounds(25, 135, 120, 25);
        add(labelpassword);
        fieldpass.setBounds(150, 135, 120, 25);
        fieldpass.setText(pass);
        fieldpass.setEditable(false);
        add(fieldpass);
        
        labelnotelp.setBounds(25, 180, 120, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(150, 180, 120, 25);
        fieldnotelp.setText(noTelp);
        fieldnotelp.setEditable(false);
        add(fieldnotelp);
        
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
                MenuAdmin menuA = new MenuAdmin();
                menuA.setVisible(true);
                dispose();
            }
        });
                
    } 
}
