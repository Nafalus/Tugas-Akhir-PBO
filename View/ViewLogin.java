package View;

import java.util.Scanner;

import Controller.ControllerLogin;

public class ViewLogin {
    private ControllerLogin controllerLogin;

    public ViewLogin (ControllerLogin controllerLogin){
        this.controllerLogin = controllerLogin;
    }

    public void Login (){
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan Nama : ");
        String nama = input.nextLine();
        System.out.println("Masukkan Password : ");
        String pass = input.nextLine();
        controllerLogin.validasiLogin(nama, pass);
    }
}
