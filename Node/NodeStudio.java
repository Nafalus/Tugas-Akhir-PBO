package Node;

import java.util.ArrayList;

public class NodeStudio {
    private int nomerStudio;
    private int jumlahKursi;
    private ArrayList<Film> films;

    public NodeStudio (int nomerStudio, int jumlahKursi){
        this.nomerStudio = nomerStudio;
        this.jumlahKursi = jumlahKursi;
        this.films = new ArrayList<>();
    }

    public void setNomerStudio (int nomerStudio){
        this.nomerStudio = nomerStudio;
    }

    public int getNomerStudio (){
        return this.nomerStudio;
    }

    public void setJumlahKursi (int jumlahKursi){
        this.jumlahKursi = jumlahKursi;
    }

    public int getJumlahKursi (){
        return this.jumlahKursi;
    }

    public void addFilm (String jamTayang, int id, String namaFilm, int jumlahBookingKursi){
        this.films.add(new Film(this.nomerStudio, jamTayang, id, namaFilm, jumlahBookingKursi, this.jumlahKursi));
    }
    
    public void setFilm (ArrayList<Film> films){
        this.films = films;
    }

    public ArrayList<Film> getAllFilm (){
        return this.films;
    }

    public static class Film {
        private int nomerStudio;
        private String jamTayang;
        private int id;
        private String namaFilm;
        private int jumlahBookingKursi;
        private ArrayList<NodeKursi> listKursi;
    
        public Film (int nomerStudio, String jamTayang, int id, String namaFilm, int jumlahBookingKursi, int jumlahKursi){
            this.nomerStudio = nomerStudio;
            this.jamTayang = jamTayang;
            this.id = id;
            this.namaFilm = namaFilm;
            this.jumlahBookingKursi = jumlahBookingKursi;
            this.listKursi = new ArrayList<NodeKursi>();
            for (int i = 1; i <= jumlahKursi; i++) {
                this.listKursi.add(new NodeKursi(i));
            }
        }

        public int getNomerStudio (){
            return this.nomerStudio;
        }

        public void setJamTayang (String jamTayang){
            this.jamTayang = jamTayang;
        }

        public String getJamTayang (){
            return this.jamTayang;
        }
        
        public void setId (int id){
            this.id = id;
        }

        public int getId (){
            return this.id;
        }

        public void setNamaFilm (String namaFilm){
            this.namaFilm = namaFilm;
        }

        public String getNamaFilm (){
            return this.namaFilm;
        }

        public void setJumlahBookingKursi (int jumlahBookingKursi){
            this.jumlahBookingKursi = jumlahBookingKursi;
        }

        public int getJumlagBookingKursi (){
            return this.jumlahBookingKursi;
        }

        public void setStatusKursi (ArrayList<NodeKursi> kursi){
            this.listKursi = kursi;
        }
    
        public ArrayList<NodeKursi> getAllKursi (){
            return this.listKursi;
        }
    }
}
