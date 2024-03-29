package View;

import java.util.Scanner;

import Controller.*;
import Node.*;
import Node.NodeStudio.Film;

public class ViewAdmin {
    private ControllerStudio controllerStudio;
    private ControllerUser controllerUser;

    public ViewAdmin (ControllerStudio controllerStudio, ControllerUser controllerUser){
        this.controllerStudio = controllerStudio;
        this.controllerUser = controllerUser;
    }

    public void menuAdmin (){
        Scanner input = new Scanner(System.in);
        int pilih;
        x: while (true) {
            System.out.println("--------------------------------");
            System.out.println("|\tMenu Admin\t\t");
            System.out.println("--------------------------------");
            System.out.println("|1. Tambah Studio");
            System.out.println("|2. Lihat Studio");
            System.out.println("|3. Cari Film");
            System.out.println("|4. Tambah Film");
            System.out.println("|5. Lihat Film");
            System.out.println("|6. Update Jam Tayang Film");
            System.out.println("|7. Lihat List User");
            System.out.println("|99. Logout");
            System.out.println("--------------------------------");
            System.out.print("Masukkan Pilihan : "); pilih = input.nextInt();
            System.out.println("--------------------------------");
            switch (pilih) {
                case 1:
                    System.out.println(" - Tambah Studio -");
                    System.out.print("Masukkan Jumlah Kursi : "); int jumlahKursi = input.nextInt();
                    controllerStudio.insertStudio(controllerStudio.getLastNomerStudio() + 1, jumlahKursi);
                    break;
                case 2:
                    System.out.println(" - Menampilkan Semua Studio -");
                    for (NodeStudio studio : controllerStudio.viewAllStudio()) {
                        System.out.println("Nomer Studio : " + studio.getNomerStudio());
                        System.out.println("JumlahKursi : " + studio.getJumlahKursi());
                        System.out.println(" - Daftar Film - ");
                        for (Film film : studio.getAllFilm()) {
                            System.out.println(" => " + film.getNamaFilm());
                        }
                        System.out.println("==========================================");
                    }
                    break;
                case 3:
                    input.nextLine();
                    System.out.println(" - Cari Film -");
                    System.out.print("Masukkan Nama Film : "); String namaFilm = input.nextLine();
                    Film filmSearch = controllerStudio.searchFilm(namaFilm);
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
                    } else {
                        System.out.println("Film Tidak Ditemukan!!!");
                    }
                    break;
                case 4:
                    System.out.println(" - Tambah Film -");
                    System.out.print("Masukkan Nomer Studio : "); int nomerStudio = input.nextInt();
                    input.nextLine();
                    if (controllerStudio.searchStudio(nomerStudio) != null) {
                        System.out.print("Masukkan Nama Film : "); namaFilm = input.nextLine();
                        System.out.println(" - Masukkan Jam Tayang -");
                        System.out.print("Jam : "); String jam = input.nextLine();
                        System.out.print("Menit : "); String menit = input.nextLine();
                        System.out.print("Hari : "); String hari = input.nextLine();
                        System.out.print("Bulan : "); String bulan = input.nextLine();
                        System.out.print("Tahun : "); String tahun = input.nextLine();
                        controllerStudio.insertFilm(nomerStudio, jam, menit, hari, bulan, tahun, namaFilm);
                    } else {
                        System.out.println("!!! Studio Tidak Ditemukan !!!");
                    }
                    break;
                case 5:
                    System.out.println(" - Menampilkan Semua Film -");
                    for (Film film : controllerStudio.viewAllFilm()) {
                        System.out.println(" => " + film.getNamaFilm());
                        System.out.println("    " + film.getJamTayang());
                    }
                    break;
                case 6:
                    System.out.println(" - Update jam Tayang Film -");
                    input.nextLine();
                    System.out.print("Masukkan Nama Film : "); namaFilm = input.nextLine();
                    if (controllerStudio.searchFilm(namaFilm) != null) {
                        System.out.println(" - Masukkan Jam Tayang -");
                        System.out.print("Jam : "); String jam = input.nextLine();
                        System.out.print("Menit : "); String menit = input.nextLine();
                        System.out.print("Hari : "); String hari = input.nextLine();
                        System.out.print("Bulan : "); String bulan = input.nextLine();
                        System.out.print("Tahun : "); String tahun = input.nextLine();
                        controllerStudio.updateFilm(namaFilm, jam, menit, hari, bulan, tahun);
                    } else {
                        System.out.println("!!! Film Tidak Ditemukan !!!");
                    }
                    break;
                case 7:
                    System.out.println(" - Menampilkan List User");
                    for (NodeUser user : controllerUser.viewAllUser()) {
                        System.out.println(" => " + user.getNama());
                    }
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
