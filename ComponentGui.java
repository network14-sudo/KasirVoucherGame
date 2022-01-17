package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ComponentGui extends JFrame {
    protected JButton btnregister = new JButton("OK");
    protected JButton btnnotregProduk = new JButton("REGISTRASI PRODUK");
    protected JButton btnnotregA = new JButton("REGISTRASI ADMIN");
    protected JButton btnnotregP = new JButton("REGISTRASI PEMBELI");
    protected JButton btnnotregT = new JButton("REGISTRASI TRANSAKSI");
    protected JButton btnlogin = new JButton("LOG IN");
    protected JButton btndelete = new JButton("DELETE TRANSAKSI");
    protected JButton btnmenu = new JButton("MENU");
    protected JButton btnAdmin = new JButton("ADMIN");
    protected JButton btnPembeli = new JButton("PEMBELI");
    protected JButton btnLDP = new JButton("LIHAT DATA PEMBELI");
    protected JButton btnLDA = new JButton("LIHAT DATA ADMIN");
    protected JButton btnLDT = new JButton("LIHAT DATA TRANSAKSI");
    protected JButton btnTrx = new JButton("TRANSAKSI");
    protected JButton btnback = new JButton("<< KEMBALI");
    
    protected JLabel labelregister = new JLabel("REGISTER");
    protected JLabel labellogin = new JLabel("LOGIN");
    protected JLabel labelid = new JLabel("ID");
    protected JLabel labelnama = new JLabel("NAMA");
    protected JLabel labelNA = new JLabel("NAMA AKUN");
    protected JLabel labelNP = new JLabel("NAMA PRODUK");
    protected JLabel labelIDGame = new JLabel("ID GAME");
    protected JLabel labelpassword = new JLabel("PASSWORD");
    protected JLabel labelnominal = new JLabel("NOMINAL");
    protected JLabel labelharga = new JLabel("HARGA");
    protected JLabel labelstatus = new JLabel("STATUS");
    protected JLabel labelnomortrx = new JLabel("NOMOR TRX");
    protected JLabel labelnotelp = new JLabel("NO TELEPON");
    protected JLabel bingkaigambar = new JLabel();
    
    protected JTextField fieldid = new JTextField();
    protected JTextField fieldIDGame = new JTextField();
    protected JTextField fieldnama = new JTextField();
    protected JTextField fieldNA = new JTextField();
    protected JTextField fieldNP = new JTextField();
    protected JTextField fieldNT = new JTextField();
    protected JPasswordField fieldpassword = new JPasswordField();
    protected JTextField fieldpass = new JTextField();
    protected JTextField fieldnominal = new JTextField();
    protected JTextField fieldharga = new JTextField();
    protected JTextField fieldstatus = new JTextField();
    protected JTextField fieldnomortrx = new JTextField();
    protected JTextField fieldnotelp = new JTextField();
    
    protected JButton btnubahNA = new JButton("Ubah");
    
    BufferedImage bufferedImage = null;
    Image gambarresize;
    
    void kosong(){
        fieldnama.setText(null);
        fieldNA.setText(null);
        fieldNP.setText(null);
        fieldNT.setText(null);
        fieldpassword.setText(null);
        fieldnominal.setText(null);
        fieldharga.setText(null);
        fieldstatus.setText(null);
        fieldnomortrx.setText(null);
        fieldnotelp.setText(null);
    }
}