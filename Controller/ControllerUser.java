package Controller;

import java.util.ArrayList;

import Model.ModelUser;
import Node.NodeUser;

public class ControllerUser {
    private ModelUser modelUser;

    public ControllerUser (ModelUser modelUser){
        this.modelUser = modelUser;
    }

    public ArrayList<NodeUser> viewAllUser (){
        return modelUser.getAllUser();
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
}
