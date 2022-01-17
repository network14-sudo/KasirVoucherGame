package Controller;
import Entity.*;
import java.util.ArrayList;

public class AdminController {

    public AdminController() {}
    
    public void insertData(String nama, String id, String password, String noTelp){
        AdminEntity admin = new AdminEntity();
        admin.setId(id);
        admin.setNama(nama);
        admin.setPassword(password);
        admin.setNoTelp(noTelp);
        ObjectModelController.admin.insertData(admin);
    }
    public void login(String id, String password){
        ObjectModelController.admin.cekData(id, password);
    }
    public void adminEntity(AdminEntity admin){
        ObjectModelController.admin.insertData(admin);
    }
    public ArrayList <AdminEntity>  showDataAdminEntity(String id){
        return ObjectModelController.admin.showDataAdminEntity(id);
    }
    public void updatetrx(int index, TransaksiEntity Transaksi){
        ObjectModelController.transaksi.updatetrx(index, Transaksi);
    }
    public void delete(int index){
        ObjectModelController.transaksi.deleteData(index);
    }
}
