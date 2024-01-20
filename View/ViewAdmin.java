package View;

import java.util.Scanner;

import Controller.*;
import Node.*;

public class ViewAdmin {
    private ControllerStudio controllerStudio;

    public ViewAdmin (ControllerStudio controllerStudio){
        this.controllerStudio = controllerStudio;
    }

    public void menuAdmin (){
        Scanner input = new Scanner(System.in);
        int pilih;
        x: while (true) {
            System.out.println("--------------------------------");
            System.out.println("|\tMenu Admin\t\t");
            System.out.println("--------------------------------");
            System.out.println("|1. Tambah Studio\t\t\t");
            System.out.println("|2. Lihat Studio\t\t\t");
            System.out.println("|3. Update Studio\t\t\t");
            System.out.println("|4. Delete Studio\t\t\t");
            System.out.println("|5. Tambah Film\t\t");
            System.out.println("|6. Lihat Film\t\t");
            System.out.println("|7. Update Film\t\t");
            System.out.println("|8. Delete Film\t\t");
            System.out.println("|9. Lihat List User\t");
            System.out.println("|99. Logout\t\t\t");
            System.out.println("--------------------------------");
            System.out.print("Masukkan Pilihan : "); pilih = input.nextInt();
            System.out.println("--------------------------------");
            switch (pilih) {
                case 1:
                    System.out.println(" - Tambah Studio -");
                    System.out.print("Masukkan Jumlah Kursi : "); int jumlahKursi = input.nextInt();
                    controllerStudio.insertStudio(controllerStudio.getLastNomerStudio() + 1, jumlahKursi);
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
