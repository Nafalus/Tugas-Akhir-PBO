package Model;

import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;

import ModelGSON.ModelGSON;
import Node.NodeUser;

public class ModelUser {
    private ArrayList<NodeUser> listUser;
    private ModelGSON<NodeUser> modelGSONUser;

    public ModelUser (){
        this.listUser = new ArrayList<NodeUser>();
        modelGSONUser = new ModelGSON<NodeUser>("Database/DatabaseUser.json");
        loadData();
    }

    public void addUser (NodeUser User){
        this.listUser.add(User);
        Commit();
    }

    public NodeUser searchUser (String nama){
        NodeUser user = null;
        for (NodeUser akun : listUser) {
            if (akun.getNama().equalsIgnoreCase(nama)) {
                return akun;                
            }
        }
        return user;
    }

    public ArrayList<NodeUser> getAllUser (){
        return this.listUser;
    }

    public void updateUser (NodeUser user){
        this.listUser.remove(user);
        Commit();
    }

    private void loadData (){
        this.listUser = modelGSONUser.readFromFile(new TypeToken<ArrayList<NodeUser>>(){}.getType());
    }

    private void Commit (){
        modelGSONUser.WriteToFile(listUser);
    }
}
