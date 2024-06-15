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
            Object obj = new JSONParser().parse(new FileReader("megrendelesek.json"));
            JSONArray jsonArray = (JSONArray) obj;
            System.out.println(jsonArray.get(0));

        }catch (IOException | ParseException e){
            System.out.println("beolvasas: "+e.getMessage());
        }

    }
}