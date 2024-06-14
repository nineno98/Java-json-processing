public class Dolgozo {

    private int _id;
    private String _nev;
    private int _fizetes;

    public Dolgozo(int id, String nev, int fizetes){
        _id = id;
        _nev = nev;
        _fizetes = fizetes;
    }

    public int getId(){
        return _id;
    }
    public void setId(int arg){
        _id = arg;
    }
    public String getNev(){
        return _nev;
    }
    public void setNev(String arg){
        _nev = arg;
    }
    public int getFizetes(){
        return _fizetes;
    }
    public void setFiizetes(int arg){
        _fizetes = arg;
    }

}
