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

    public void updateUser (){

    }
}
