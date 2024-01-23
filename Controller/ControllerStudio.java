package Controller;

import java.util.ArrayList;

import Model.ModelStudio;
import Node.NodeStudio;
import Node.NodeStudio.Film;
import Node.NodeKursi;

public class ControllerStudio {
    private ModelStudio modelStudio;

    public ControllerStudio (ModelStudio modelStudio){
        this.modelStudio = modelStudio;
    }

    public ArrayList<NodeStudio> viewAllStudio (){
        return modelStudio.getAllStudio();
    }

    public ArrayList<Film> viewAllFilm (){
        return modelStudio.getAllFilm();
    }

    public NodeStudio searchStudio (int nomerStudio){
        return modelStudio.searchStudio(nomerStudio);
    }

    public Film searchFilm (String namaFilm){
        return modelStudio.searchFilm(namaFilm);
    }

    public void insertStudio (int nomerStudio, int jumlahKursi) {
        NodeStudio studio = new NodeStudio(nomerStudio, jumlahKursi);
        modelStudio.addStudio(studio);
    }

    public void insertFilm (int nomerStudio, String jamTayang, String namaFilm){
        NodeStudio studio = modelStudio.searchStudio(nomerStudio);
        if (studio != null) {
            studio.addFilm(jamTayang, modelStudio.getLastIdFilm(nomerStudio) + 1, namaFilm, 0);
            modelStudio.updateStudio(studio);
        } else {
            System.out.println("!!! Studio Tidak Ditemukan !!!");
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
