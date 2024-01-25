package Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Model.ModelStudio;
import Node.NodeStudio;
import Node.NodeStudio.Film;
import Node.NodeKursi;

public class ControllerStudio {
    private ModelStudio modelStudio;
    private DateTimeFormatter format;

    public ControllerStudio (ModelStudio modelStudio){
        this.modelStudio = modelStudio;
        this.format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    }

    public ArrayList<NodeStudio> viewAllStudio (){
        return modelStudio.getAllStudio();
    }

    public ArrayList<Film> viewAllFilm (){
        return modelStudio.getAllFilm();
    }

    public ArrayList<Film> viewAllFilmTayang (){
        ArrayList<Film> listFilm = new ArrayList<>();
        LocalDateTime waktuSekarang = LocalDateTime.now();
        for (Film film : modelStudio.getAllFilm()) {
            LocalDateTime waktuTayang = LocalDateTime.parse(film.getJamTayang(), format);
            if (waktuSekarang.isAfter(waktuTayang) && waktuSekarang.isBefore(waktuTayang.plusHours(2))) {
                listFilm.add(film);
            }
        }
        return listFilm;
    }

    public NodeStudio searchStudio (int nomerStudio){
        return modelStudio.searchStudio(nomerStudio);
    }

    public Film searchFilm (String namaFilm){
        return modelStudio.searchFilm(namaFilm);
    }

    public Film searchFilmTayang (String namaFilm){
        for (Film film : viewAllFilmTayang()) {
            if (film.getNamaFilm().equalsIgnoreCase(namaFilm)) {
                return film;
            }
        }
        return null;
    }

    public Boolean cekStatusKursi (String namaFilm, int idKursi){
        Film film = searchFilm(namaFilm);
        ArrayList<NodeKursi> listKursi = film.getAllKursi();
        return listKursi.get(idKursi - 1).getStatusKursi();
    }

    public void insertStudio (int nomerStudio, int jumlahKursi) {
        NodeStudio studio = new NodeStudio(nomerStudio, jumlahKursi);
        modelStudio.addStudio(studio);
    }

    public void insertFilm (int nomerStudio, String Jam, String Menit, String Hari, String Bulan, String Tahun, String namaFilm){
        NodeStudio studio = modelStudio.searchStudio(nomerStudio);
        if (Integer.parseInt(Jam) < 10) {
            Jam = "0" + Jam;
        }
        if (Integer.parseInt(Menit) < 10) {
            Menit = "0" + Menit;
        }

        if (Integer.parseInt(Hari) < 10) {
            Hari = "0" + Hari;
        }
        
        if (Integer.parseInt(Bulan) < 10) {
            Bulan = "0" +Bulan;
        }

        String jamTayang = Tahun + "-" + Bulan + "-" + Hari + " " + Jam + ":" + Menit;
        if (studio != null) {
            studio.addFilm(jamTayang, modelStudio.getLastIdFilm(nomerStudio) + 1, namaFilm, 0);
            modelStudio.updateStudio(studio);
        } else {
            System.out.println("!!! Studio Tidak Ditemukan !!!");
        }
    }

    public void updateFilm (String namaFilm, String Jam, String Menit, String Hari, String Bulan, String Tahun){
        Film film = searchFilm(namaFilm);
        if (Integer.parseInt(Jam) < 10) {
            Jam = "0" + Jam;
        }
        if (Integer.parseInt(Menit) < 10) {
            Menit = "0" + Menit;
        }

        if (Integer.parseInt(Hari) < 10) {
            Hari = "0" + Hari;
        }
        
        if (Integer.parseInt(Bulan) < 10) {
            Bulan = "0" +Bulan;
        }

        String jamTayang = Tahun + "-" + Bulan + "-" + Hari + " " + Jam + ":" + Menit;
        if (film != null) {
            film.setJamTayang(jamTayang);
            NodeStudio studio = searchStudio(film.getNomerStudio());
            ArrayList<Film> listFilm = studio.getAllFilm();
            listFilm.set(film.getId() - 1, film);
            studio.setFilm(listFilm);
            modelStudio.updateStudio(studio);
        } else {
            System.out.println("!!! Film Tidak Ditemukan !!!");
        }
    }

    public void deleteStudio (int nomerStudio){
        NodeStudio studio = modelStudio.searchStudio(nomerStudio);
        if (studio != null) {
            modelStudio.deleteStudio(studio);
        } else {
            System.out.println("!!! Studio Tidak Di-Temukan !!!");
        }
    }

    public int getLastNomerStudio (){
        return viewAllStudio().size();
    }
}
