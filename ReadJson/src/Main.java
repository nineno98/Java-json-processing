import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.io.FileReader;


public class Main {
    public static List<Dolgozo> dolgozok = new ArrayList<>();
    public static void main(String[] args) {

        beolvasas();
        kiiras();
        //Dolgozo ujDolgozo = addDolgozo();
        //dolgozok.add(ujDolgozo);

        //dolgozó törlése
        deleteDolgozo(2);
        //writeJsonFile();



    }

    private static void deleteDolgozo(int id) {
        Optional<Dolgozo> dolgozoRemove = dolgozok.stream().filter(c -> c.getId() == id).findFirst();
        System.out.println(dolgozoRemove);

    }

    private static Dolgozo addDolgozo() {

        System.out.println("Adja meg a dolgzó nevét:");
        String nev = bekeres();
        System.out.println("Adja meg a dolgozó fizetését:");
        int salary;
        while (true){
            try{
                salary = Integer.parseInt(bekeres());
                break;
            }catch (Exception e){
                System.out.println("Számot adj meg! "+e.getMessage());
            }
        }
        Dolgozo Maxid = dolgozok.stream().max(Comparator.comparing(c -> c.getId())).get();
        return new Dolgozo(Maxid.getId()+1, nev, salary);

    }

    private static String bekeres() {
        Scanner scan = new Scanner(System.in);
        String res = "";
        while (true){
            res = scan.nextLine();
            if(!res.equals("")){

                return res;
            }
            else {
                System.out.println("Nem lehet a bemenet üres.");
            }
        }
    }

    private static void writeJsonFile() {
        JSONArray arr = new JSONArray();
        try {
            for (int i = 0; i <dolgozok.size() ; i++) {
                arr.add(dolgozok.get(i).parseToJsonObj());
            }

            FileWriter writer = new FileWriter("dolgozok.json", false);
            writer.write(arr.toJSONString());
            writer.close();

        } catch (IOException e) {
            System.out.println("writeJsonFile: "+e.getMessage());
        }
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