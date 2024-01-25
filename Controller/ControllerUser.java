package Controller;

import java.util.ArrayList;

import Model.*;
import Node.*;
import Node.NodeStudio.Film;
import Node.NodeUser.Transaksi;

public class ControllerUser {
    private ModelUser modelUser;
    private ModelStudio modelStudio;
    private ControllerStudio controllerStudio;

    public ControllerUser (ModelUser modelUser, ModelStudio modelStudio, ControllerStudio controllerStudio){
        this.modelUser = modelUser;
        this.modelStudio = modelStudio;
        this.controllerStudio = controllerStudio;
    }

    public ArrayList<NodeUser> viewAllUser (){
        return modelUser.getAllUser();
    }

    public NodeUser searchUser (String nama){
        return modelUser.searchUser(nama);
    }

    public void insertUser (String nama, String pass){
        modelUser.addUser(new NodeUser(nama, pass));
    }

    public void updateUser (String nama, String pass){
        NodeUser user = modelUser.searchUser(nama);
        if (user == null){
            System.out.println("!!! Pengguna Tidak Di-Temukan !!!");
        } else {
            user.setPassword(pass);
            modelUser.updateUser(user);
        }
    }

    public void deleteUser (String nama){
        NodeUser user = modelUser.searchUser(nama);
        if (user == null) {
            System.out.println("!!! Penguna tidak Di-Temukan !!!");
        } else {
            modelUser.deleteUser(user);
        }
    }

    public void PesanTiket (String nama, Film film, int idKursi){
        NodeUser user = modelUser.searchUser(nama);
        NodeStudio studio = controllerStudio.searchStudio(film.getNomerStudio());
        ArrayList<Film> listFilm = studio.getAllFilm();
        ArrayList<NodeKursi> listKursi = film.getAllKursi();
        for (NodeKursi kursi : listKursi) {
            if (kursi.getId() == idKursi) {
                kursi.setStatusKursi(true);
            }
        }
        film.setStatusKursi(listKursi);
        listFilm.set(film.getId() - 1, film);
        studio.setFilm(listFilm);
        modelStudio.updateStudio(studio);
        user.addTransaksi(new Transaksi(film.getNamaFilm(), studio.getNomerStudio(), idKursi));
        modelUser.updateUser(user);
    }
}
