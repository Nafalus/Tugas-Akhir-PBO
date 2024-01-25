package View;

import java.util.Scanner;

import Controller.*;
import Node.NodeKursi;
import Node.NodeStudio.Film;

public class ViewUser {
    private ControllerUser controllerUser;
    private ControllerStudio controllerStudio;

    public ViewUser (ControllerUser controllerUser, ControllerStudio controllerStudio){
        this.controllerUser = controllerUser;
        this.controllerStudio = controllerStudio;
    }

    public void menuUser (String nama){
        Scanner input = new Scanner(System.in);
        int pilih;
        x: while (true) {
            System.out.println("--------------------------------");
            System.out.println("|\tMenu User\t\t");
            System.out.println("--------------------------------");
            System.out.println("|1. Lihat Film");
            System.out.println("|2. Pesan Tiket");
            System.out.println("|3. Histori Transaksi");
            System.out.println("|4. ");
            System.out.println("|5. ");
            System.out.println("|6. ");
            System.out.println("|99. Logout\t\t\t");
            System.out.println("--------------------------------");
            System.out.print("Masukkan Pilihan : "); pilih = input.nextInt();
            System.out.println("--------------------------------");
            switch (pilih) {
                case 1:
                    System.out.println(" - Lihat Semua Film -");
                    if (controllerStudio.viewAllFilmTayang() != null) {
                        for (Film film : controllerStudio.viewAllFilmTayang()) {
                            System.out.println(" => " + film.getNamaFilm());
                        }
                    } else {
                        System.out.println("!!!Tidak ada Film yang sedang tayang!!!");
                    }
                    break;
                case 2:
                    input.nextLine();
                    System.out.println(" - Cari Film -");
                    System.out.print("Masukkan Nama Film : "); String namaFilm = input.nextLine();
                    Film filmSearch = controllerStudio.searchFilmTayang(namaFilm);
                    if (filmSearch != null) {
                        System.out.println("Nama Film : " + filmSearch.getNamaFilm());
                        System.out.println("Jam Tayang : " + filmSearch.getJamTayang());
                        System.out.println("----------------------");
                        for (NodeKursi kursi : filmSearch.getAllKursi()) {
                            System.out.println("Nomer Kursi : " + kursi.getId());
                            if (kursi.getStatusKursi()) {
                                System.out.println("Kursi Telah Di Pesan!!!");
                            } else {
                                System.out.println("Kursi Masih Kosong!!!");
                            }
                            System.out.println("----------------------");
                        }
                        System.out.print("Pilih Kursi yang ingin DiPesan : "); int pilihKursi = input.nextInt();
                        if (controllerStudio.cekStatusKursi(namaFilm, pilihKursi) == false) {
                            controllerUser.PesanTiket(nama, filmSearch, pilihKursi);
                        } else {
                            System.out.println("!!! Kursi Telah Dipesan !!!");
                        }
                    } else {
                        System.out.println("Film Tidak Ditemukan!!!");
                    }
                    break;
                case 3:
                    System.out.println("!!! Ini Histori Transaksi !!!");
                    break;
                case 99:
                    System.out.println(" - Anda Telah Logout -");
                    break x;
                default:
                System.out.println("!!! INVALID INPUT !!!");
                    break;
            }
        }
    }
}