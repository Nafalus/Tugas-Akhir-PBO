package Controller;

import java.util.ArrayList;

import Model.ModelStudio;
import Node.NodeStudio;

public class ControllerStudio {
    private ModelStudio modelStudio;

    public ControllerStudio (ModelStudio modelStudio){
        this.modelStudio = modelStudio;
    }

    public ArrayList<NodeStudio> viewAllStudio (){
        return modelStudio.getAllStudio();
    }

    public void insertStudio (int nomerStudio, int jumlahKursi) {
        NodeStudio studio = new NodeStudio(nomerStudio, jumlahKursi);
        modelStudio.addStudio(studio);
    }

    // public void updateStudio (int){
    //     NodeStudio studio = modelStudio.searchStudio()
    // }

    public void deleteStudio (int nomerStudio){
        NodeStudio studio = modelStudio.searchStudio(nomerStudio);
        if (studio != null) {
            modelStudio.deleteStudio(studio);
        } else {
            System.out.println("!!! Studio Tidak Di-Temukan !!!");
        }
    }

    public int getLastNomerStudio (){
        return viewAllStudio().size();
    }
}
