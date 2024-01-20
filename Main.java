
import java.util.*;
import Model.*;
import Controller.*;
import View.*;

public class Main {
    public static void main(String[] args) {
        ModelAdmin modelAdmin = new ModelAdmin();
        ModelUser modelUser = new ModelUser();
        ControllerAdmin controllerAdmin = new ControllerAdmin(modelAdmin);
        ControllerUser controllerUser = new ControllerUser(modelUser);
        ViewAdmin viewAdmin = new ViewAdmin();
        ViewUser viewUser = new ViewUser();
        ControllerLogin controllerLogin = new ControllerLogin(viewAdmin, viewUser);
        ViewDaftar viewDaftar = new ViewDaftar(controllerUser);
        ViewLogin viewLogin = new ViewLogin(controllerLogin); 

        // ViewTest viewTest = new ViewTest(controllerAdmin);
        // viewTest.Menu();

        Scanner input = new Scanner(System.in);
        int pilih;
        x : while(true){
        System.out.println("1. Daftar");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Masukkan Pilihan : ");
        pilih = input.nextInt();
            switch (pilih) {
                case 1:
                viewDaftar.Daftar();
                    break;
                case 2:
                viewLogin.Login();
                    break;
                case 3:
                    System.out.println("Program Berakhir");
                    break x;
                default:
                    System.out.println("INVALID INPUT!");
                    break;
            }
        }
        input.close();
    }
}
