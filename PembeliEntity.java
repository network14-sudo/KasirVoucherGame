package Entity;

public class PembeliEntity extends ManusiaEntity{
    private String namaakun, IDGame;

    public PembeliEntity() {}

    public String getIDGame() {
        return IDGame;
    }

    public void setIDGame(String IDGame) {
        this.IDGame = IDGame;
    }

    public String getNamaakun() {
        return namaakun;
    }

    public void setNamaakun(String namaakun) {
        this.namaakun = namaakun;
    }

    @Override
    public String getNama() {
        return nama;
    }

    @Override
    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String getNoTelp() {
        return noTelp;
    }

    @Override
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
        
}
