import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.io.FileReader;



public class Main {
    public static List<Dolgozo> dolgozok = new ArrayList<>();
    public static void main(String[] args) {

        beolvasas();
        kiiras();

    }

    private static void kiiras() {
        for(Dolgozo item : dolgozok){
            System.out.println(item);
        }
    }

    private static void beolvasas() {
        try {
            Object obj = new JSONParser().parse(new FileReader("dolgozok.json"));
            JSONArray jsonArray = (JSONArray) obj;

            for(int i = 0; i<jsonArray.size(); i++){
                JSONObject item = (JSONObject) jsonArray.get(i);

                Dolgozo dolgozo = new Dolgozo( Integer.parseInt(item.get("index").toString()) ,  item.get("name").toString(), Integer.parseInt(item.get("salary").toString()));
                dolgozok.add(dolgozo);
            }
        }catch (IOException | ParseException e){
            System.out.println("beolvasas: "+e.getMessage());
        }

    }
}