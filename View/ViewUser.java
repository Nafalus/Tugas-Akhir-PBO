package View;

import java.util.Scanner;

import Controller.*;

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
            System.out.println("|2. Cari Film");
            System.out.println("|3. ");
            System.out.println("|4. ");
            System.out.println("|5. ");
            System.out.println("|6. ");
            System.out.println("|99. Logout\t\t\t");
        }
    }
}
