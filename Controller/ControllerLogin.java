package Controller;

import java.util.ArrayList;
import com.google.gson.reflect.TypeToken;
import ModelGSON.ModelGSON;
import Node.*;
import View.*;

public class ControllerLogin {
    private ViewAdmin viewAdmin;
    private ViewUser viewUser;

    public ControllerLogin (ViewAdmin viewAdmin, ViewUser viewUser){
        this.viewAdmin = viewAdmin;
        this.viewUser = viewUser;
    }

    public void validasiLogin (String nama, String pass){
        ArrayList<NodeUser> listUser = new ModelGSON<NodeUser>("Database/DatabaseUser.json").readFromFile(new TypeToken<ArrayList<NodeUser>>(){}.getType());
        if (listUser != null) {
            for (NodeUser user : listUser) {
                if (user.getNama().equalsIgnoreCase(nama) && user.getPassword().equalsIgnoreCase(pass)) {
                    viewUser.menuUser(nama);
                    return;
                }
            }            
        }

        ArrayList<NodeAdmin> listAdmin = new ModelGSON<NodeAdmin>("Database/DatabaseAdmin.json").readFromFile(new TypeToken<ArrayList<NodeAdmin>>(){}.getType());
        if (listAdmin != null) {
            for (NodeAdmin admin : listAdmin) {
                if (admin.getNama().equalsIgnoreCase(nama) && admin.getPassword().equalsIgnoreCase(pass)) {
                    viewAdmin.menuAdmin();
                    return;                    
                }
            }            
        }
        System.out.println(" - Username atau Password salah -");
    }
}
