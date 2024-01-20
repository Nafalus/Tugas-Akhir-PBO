package Node;

public class NodeAdmin {
    private String nama;
    private String pass;

    public NodeAdmin (String nama, String pass){
        this.nama = nama;
        this.pass = pass;
    }

    public void setNama (String nama){
        this.nama = nama;
    }

    public String getNama (){
        return this.nama;
    }

    public void setPassword (String pass){
        this.pass = pass;
    }

    public String getPassword(){
        return this.pass;
    }
}