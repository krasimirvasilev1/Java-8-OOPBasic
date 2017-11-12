package FirstExersiceDefiningClasses.CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String,TypeOfCat> allcats = new HashMap<>();
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String input = console.readLine();
            if (input.equals("End")){
                break;
            }
            String [] info = input.split(" ");
            TypeOfCat typeOfCat = new TypeOfCat();
            if (info[0].equals("StreetExtraordinaire")){
                StreetExtraOrdinary streetExtraOrdinary = new StreetExtraOrdinary(info[1],Double.parseDouble(info[2]));
                typeOfCat.setStreetExtraOrdinary(streetExtraOrdinary);
            }
            else if (info[0].equals("Cymric")){
                Cymric cymric = new Cymric(info[1],Double.parseDouble(info[2]));
                typeOfCat.setCymric(cymric);
            }
            else{
                Siamese siamese = new Siamese(info[1],Double.parseDouble(info[2]));
                typeOfCat.setSiamese(siamese);
            }

            allcats.put(info[1],typeOfCat);
        }

        String name = console.readLine();
        TypeOfCat typeOfCat = allcats.get(name);
        if (typeOfCat.getStreetExtraOrdinary() != null){
            System.out.println(typeOfCat.getStreetExtraOrdinary());
        }
        else if (typeOfCat.getCymric() != null){
            System.out.println(typeOfCat.getCymric());
        }
        else if (typeOfCat.getSiamese() != null){
            System.out.println(typeOfCat.getSiamese());
        }
    }
}
