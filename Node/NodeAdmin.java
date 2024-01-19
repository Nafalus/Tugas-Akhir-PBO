package Node;

public class NodeAdmin {
    private String nama;
    private String password;

    public NodeAdmin (String nama, String password){
        this.nama = nama;
        this.password = password;
    }

    public void setNama (String nama){
        this.nama = nama;
    }

    public String getNama (){
        return this.nama;
    }

    public void setPassword (String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
}