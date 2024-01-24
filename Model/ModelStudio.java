package Model;

import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;

import Node.NodeStudio;
import Node.NodeStudio.Film;
import ModelGSON.ModelGSON;

public class ModelStudio {
    private ArrayList<NodeStudio> listStudio;
    private ArrayList<Film> listFilm;
    private ModelGSON<NodeStudio> modelGSONStudio;

    public ModelStudio (){
        listStudio = new ArrayList<>();
        listFilm = new ArrayList<>();
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

    public Film searchFilm (String namaFilm){
        loadData();
        for (Film film : listFilm) {
            if (film.getNamaFilm().equalsIgnoreCase(namaFilm)) {
                return film;                
            }
        }
        return null;
    }

    public int getLastIdFilm (int idStudio){
        NodeStudio studio = searchStudio(idStudio);
        if (studio.getAllFilm() != null) {
            int lasId = 0;
            for (Film film : studio.getAllFilm()) {
                lasId = film.getId();
            }
            return lasId;            
        } else {
            return 0;
        }
    }

    public ArrayList<NodeStudio> getAllStudio (){
        return this.listStudio;
    }

    public ArrayList<Film> getAllFilm (){
        loadData();
        return this.listFilm;
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
        this.listStudio = modelGSONStudio.readFromFile(new TypeToken<ArrayList<NodeStudio>>() {}.getType());
        this.listFilm = new ArrayList<>();
        for (NodeStudio studio : listStudio) {
            this.listFilm.addAll(studio.getAllFilm());
        }
    }

    private void Commit (){
        modelGSONStudio.WriteToFile(listStudio);
    }
}
