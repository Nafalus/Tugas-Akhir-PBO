package View;

import java.util.*;
import Controller.ControllerAdmin;

public class ViewTest {
    private ControllerAdmin controllerAdmin;

    public ViewTest (ControllerAdmin controllerAdmin){
        this.controllerAdmin = controllerAdmin;
    }

    public void Menu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan Nama Admin : "); String nama = input.nextLine();
        System.out.println("Masukkan Password Admin : "); String pass = input.nextLine();
        controllerAdmin.insertAdmin(nama, pass);
    }
}
