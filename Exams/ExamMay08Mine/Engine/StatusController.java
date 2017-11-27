package ExamMay08Mine.Engine;

import ExamMay08Mine.Benders.Bender;
import ExamMay08Mine.Monuments.Monument;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class StatusController {

    public void statusOfNation(HashMap<String, List<Bender>> benders, HashMap<String, List<Monument>> monuments, String elementOfNation) {
        if (elementOfNation.equalsIgnoreCase("Air")) {
            System.out.println("Air Nation");
            if (benders.get("Air").isEmpty()) {
                System.out.println("Benders: None");
            } else {
                System.out.println("Benders:");
                for (Bender bender : benders.get("Air")) {
                    System.out.println(bender);
                }
            }
        } else if (elementOfNation.equalsIgnoreCase("Earth")) {
            System.out.println("Earth Nation");
            if (benders.get("Earth").isEmpty()) {
                System.out.println("Benders: None");
            } else {
                System.out.println("Benders:");
                for (Bender bender : benders.get("Earth")) {
                    System.out.println(bender);
                }
            }
        } else if (elementOfNation.equalsIgnoreCase("Fire")) {
            System.out.println("Fire Nation");
            if (benders.get("Fire").isEmpty()) {
                System.out.println("Benders: None");
            } else {
                System.out.println("Benders:");
                for (Bender bender : benders.get("Fire")) {
                    System.out.println(bender);
                }
            }
        } else if (elementOfNation.equalsIgnoreCase("Water")) {
            System.out.println("Water Nation");
            if (benders.get("Water").isEmpty()) {
                System.out.println("Benders: None");
            } else {
                System.out.println("Benders:");
                for (Bender bender : benders.get("Water")) {
                    System.out.println(bender);
                }
            }
        }

        if (elementOfNation.equalsIgnoreCase("Air")) {
            if (monuments.get("Air").isEmpty()) {
                System.out.println("Monuments: None");
            } else {
                System.out.println("Monuments:");
                for (Monument monument : monuments.get("Air")) {
                    System.out.println(monument);
                }
            }
        } else if (elementOfNation.equalsIgnoreCase("Earth")) {
            if (monuments.get("Earth").isEmpty()) {
                System.out.println("Monuments: None");
            } else {
                System.out.println("Monuments:");
                for (Monument monument : monuments.get("Earth")) {
                    System.out.println(monument);
                }
            }
        } else if (elementOfNation.equalsIgnoreCase("Fire")) {
            if (monuments.get("Fire").isEmpty()) {
                System.out.println("Monuments: None");
            } else {
                System.out.println("Monuments:");
                for (Monument monument : monuments.get("Fire")) {
                    System.out.println(monument);
                }
            }
        } else if (elementOfNation.equalsIgnoreCase("Water")) {
            if (monuments.get("Water").isEmpty()) {
                System.out.println("Monuments: None");
            } else {
                System.out.println("Monuments:");
                for (Monument monument : monuments.get("Water")) {
                    System.out.println(monument);
                }
            }
        }
    }
}