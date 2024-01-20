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

    public void addFilm (Film film){
        this.films.add(film);
    }
    
    public void setFilm (ArrayList<Film> films){
        this.films = films;
    }

    public ArrayList<Film> getAllFilm (){
        return this.films;
    }

    public static class Film {
        private boolean statusTayang;
        private int id;
        private String namaFilm;
        private int jumlahBookingKursi;
    
        public Film (int id, String namaFilm, int jumlahBookingKursi){
            this.statusTayang = false;
            this.id = id;
            this.namaFilm = namaFilm;
            this.jumlahBookingKursi = jumlahBookingKursi;
        }

        public void setStatusTayang (boolean statusTayang){
            this.statusTayang = statusTayang;
        }

        public boolean getStatusTayang (){
            return this.statusTayang;
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

    }
}
