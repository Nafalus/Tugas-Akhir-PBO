package Controller;

import Model.ModelAdmin;
import Node.NodeAdmin;

public class ControllerAdmin {
    private ModelAdmin modelAdmin;

    public ControllerAdmin (ModelAdmin modelAdmin){
        this.modelAdmin = modelAdmin;
    }

    public void insertAdmin (String nama, String password){
        modelAdmin.addAdmin(new NodeAdmin(nama, password));
    }
}
