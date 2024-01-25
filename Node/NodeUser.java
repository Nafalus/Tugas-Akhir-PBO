package Node;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class NodeUser extends NodeAdmin {
    ArrayList<Transaksi> listTransaksi;

    public NodeUser (String nama, String pass){
        super(nama, pass);
        this.listTransaksi = new ArrayList<>();
    }

    public void addTransaksi (Transaksi transaksi){
        this.listTransaksi.add(transaksi);
    }

    public ArrayList<Transaksi> getAllTransaksi (){
        return this.listTransaksi;
    }

    public static class Transaksi {
        private String Tanggal;
        private String namaFilm;
        private int idStudio;
        private int idKursi;

        public Transaksi (String namaFilm, int idStudio, int idKursi){
            this.Tanggal = setTanggal();
            this.namaFilm = namaFilm;
            this.idStudio = idStudio;
            this.idKursi = idKursi;
        }

        private String setTanggal () {
            LocalDateTime currentDatetime = LocalDateTime.now();
            DateTimeFormatter Format = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
            return currentDatetime.format(Format);
        }

        public String getTanggal (){
            return this.Tanggal;
        }

        public String getNamaFilm (){
            return this.namaFilm;
        }

        public int getIdStudio (){
            return this.idStudio;
        }

        public int getIdKursi (){
            return this.idKursi;
        }
    }
}
