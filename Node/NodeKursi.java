package Node;

public class NodeKursi {
    private int id;
    private boolean statusKursi;
        
    public NodeKursi (int id){
        this.id = id;
        this.statusKursi = false;
    }

    public void setId (int id){
        this.id = id;
    }

    public int getId (){
        return this.id;
    }

    public void setStatusKursi (boolean statusKursi){
        this.statusKursi = statusKursi;
    }

    public boolean getStatusKursi (){
        return this.statusKursi;
    }
}
