package Model;

import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;

import Node.NodeStudio;
import ModelGSON.ModelGSON;

public class ModelStudio {
    private ArrayList<NodeStudio> listStudio;
    private ModelGSON<NodeStudio> modelGSONStudio;

    public ModelStudio (){
        listStudio = new ArrayList<>();
        modelGSONStudio = new ModelGSON<NodeStudio>("Database/DatabaseStudio.json");
        loadData();
    }

    public void addStudio (NodeStudio Studio){
        listStudio.add(Studio);
        Commit();
    }

    public NodeStudio searchStudio (int nomerStudio){
        for (NodeStudio Studio : listStudio) {
            if (Studio.getNomerStudio() == nomerStudio) {
                return Studio;
            }
        }
        return null;
    }

    public ArrayList<NodeStudio> getAllStudio(){
        return this.listStudio;
    }

    public void updateStudio (NodeStudio studio){
        listStudio.contains(studio);
        Commit();
    }

    public void deleteStudio (NodeStudio studio){
        listStudio.remove(studio);
        Commit();
    }

    private void loadData (){
        listStudio = modelGSONStudio.readFromFile(new TypeToken<ArrayList<NodeStudio>>() {}.getType());
    }

    private void Commit (){
        modelGSONStudio.WriteToFile(listStudio);
    }
}
