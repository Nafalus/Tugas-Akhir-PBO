package Node;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class NodeUser extends NodeAdmin {
    
    public NodeUser (String email, String password){
        super(email, password);
    }

    public static class Transaksi {
        private String Tanggal;
        private String namaUser;
        private String namaFilm;
        private int idStudio;

        public Transaksi (String namaUser, String namaFilm, int idStudio){
            this.Tanggal = setTanggal();
            this.namaUser = namaUser;
            this.namaFilm = namaFilm;
            this.idStudio = idStudio;
        }

        private String setTanggal () {
            LocalDateTime currentDatetime = LocalDateTime.now();
            DateTimeFormatter Format = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
            return currentDatetime.format(Format);
        }

        public String getTanggal (){
            return this.Tanggal;
        }

        public String getNamaUser (){
            return this.namaUser;
        }

        public String getNamaFilm (){
            return this.namaFilm;
        }

        public int getIdStudio (){
            return this.idStudio;
        }
    }
}
