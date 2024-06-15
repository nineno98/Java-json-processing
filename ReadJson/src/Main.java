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

    }

    private static void beolvasas() {
        try {
            Object obj = new JSONParser().parse(new FileReader("dolgozok.json"));
            JSONArray jsonArray = (JSONArray) obj;

            for(int i = 0; i<jsonArray.size(); i++){
                JSONObject item = (JSONObject) jsonArray.get(i);
                System.out.println(item.get("name"));
                Dolgozo dolgozo = new Dolgozo((Integer) item.get("id"), (String) item.get("name"), (Integer) item.get("salary"));
                dolgozok.add(dolgozo);
            }
        }catch (IOException | ParseException e){
            System.out.println("beolvasas: "+e.getMessage());
        }

    }
}