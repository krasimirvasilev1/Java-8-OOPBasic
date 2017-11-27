package ExamMay08Mine.Engine;

import ExamMay08Mine.Benders.Bender;
import ExamMay08Mine.Monuments.Monument;

import java.util.*;
public class CommandControler {
    HashMap<String, List<Bender>> benders;
    HashMap<String, List<Monument>> monuments;
    List<String> wars;

    public CommandControler() {
        fillTheBenders();
        fillTheMonuments();
        this.wars = new ArrayList<>();
    }

    public void commands(String[] input) {
        String typeOfCommand = input[0];
        if (typeOfCommand.equalsIgnoreCase("Bender")) {
            BenderController benderController = new BenderController();
            Bender bender = benderController.benderCreate(input);
            String elementOfBender = input[1];
            if (elementOfBender.equalsIgnoreCase("Air")) {
                this.benders.get("Air").add(bender);
            } else if (elementOfBender.equalsIgnoreCase("Water")) {
                this.benders.get("Water").add(bender);
            } else if (elementOfBender.equalsIgnoreCase("Earth")) {
                this.benders.get("Earth").add(bender);
            } else if (elementOfBender.equalsIgnoreCase("Fire")) {
                this.benders.get("Fire").add(bender);
            }
        } else if (typeOfCommand.equalsIgnoreCase("Monument")) {
            MonumentController monumentController = new MonumentController();
            Monument monument = monumentController.monumentCreate(input);
            String elementOfBender = input[1];
            if (elementOfBender.equalsIgnoreCase("Air")) {
                this.monuments.get("Air").add(monument);
            } else if (elementOfBender.equalsIgnoreCase("Water")) {
                this.monuments.get("Water").add(monument);
            } else if (elementOfBender.equalsIgnoreCase("Earth")) {
                this.monuments.get("Earth").add(monument);
            } else if (elementOfBender.equalsIgnoreCase("Fire")) {
                this.monuments.get("Fire").add(monument);
            }
        } else if (typeOfCommand.equalsIgnoreCase("Status")) {
            String elementOfBender = input[1];
            StatusController statusController = new StatusController();
            statusController.statusOfNation(this.benders, this.monuments, elementOfBender);
        } else if (typeOfCommand.equalsIgnoreCase("War")) {
            String elementOfNation = input[1];
            int warsCount = this.wars.size();
            wars.add(String.format("War %d issued by %s", warsCount + 1, elementOfNation));
            double currMaxTotalPower = Integer.MIN_VALUE;
            String nameOfNation = "";
            for (String s : this.benders.keySet()) {
                Double totalPower = ((this.benders.get(s).stream().mapToDouble(Bender::totalPower).sum() * this.monuments.get(s).stream().mapToDouble(Monument::getAffinity).sum()) / 100) + this.benders.get(s).stream().mapToDouble(Bender::totalPower).sum();
                if (currMaxTotalPower < totalPower) {
                    currMaxTotalPower = totalPower;
                    nameOfNation = s;
                }
            }
            for (String s : this.benders.keySet()) {
                if (!s.equalsIgnoreCase(nameOfNation)) {
                    this.benders.get(s).clear();
                }
            }
            for (String s : this.monuments.keySet()) {
                if (!s.equalsIgnoreCase(nameOfNation)) {
                    this.monuments.get(s).clear();
                }
            }
        }
        else if (typeOfCommand.equalsIgnoreCase("Quit")){
            for (String war : this.wars) {
                System.out.println(war);
            }
        }
    }

    private void fillTheBenders() {
        this.benders = new HashMap<String,List<Bender>>();
        this.benders.put("Air", new ArrayList<>());
        this.benders.put("Water", new ArrayList<>());
        this.benders.put("Earth", new ArrayList<>());
        this.benders.put("Fire", new ArrayList<>());
    }

    private void fillTheMonuments() {
        this.monuments = new HashMap<String,List<Monument>>();
        this.monuments.put("Air", new ArrayList<>());
        this.monuments.put("Water", new ArrayList<>());
        this.monuments.put("Earth", new ArrayList<>());
        this.monuments.put("Fire", new ArrayList<>());
    }
}