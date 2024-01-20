package View;

import java.util.Scanner;

import Controller.ControllerUser;

public class ViewDaftar {
    private ControllerUser controllerUser;

    public ViewDaftar (ControllerUser controllerUser){
        this.controllerUser = controllerUser;
    }

    public void Daftar (){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Nama Baru : "); String nama = input.nextLine();
        System.out.print("Masukkan Password Baru : "); String pass = input.nextLine();
        controllerUser.insertUser(nama, pass);
    }
}
