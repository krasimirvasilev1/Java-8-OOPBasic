package ExamMay08Mine.Engine;

import ExamMay08Mine.Benders.*;

public class BenderController {

    public Bender benderCreate(String[] benderInput) {
        String elementOfBender = benderInput[1];
        if (elementOfBender.equalsIgnoreCase("Air")) {
            AirBender airBender = new AirBender(benderInput[2], Integer.parseInt(benderInput[3]), Double.parseDouble(benderInput[4]));
            return airBender;
        } else if (elementOfBender.equalsIgnoreCase("Water")) {
            WaterBender waterBender = new WaterBender(benderInput[2], Integer.parseInt(benderInput[3]), Double.parseDouble(benderInput[4]));
            return waterBender;
        } else if (elementOfBender.equalsIgnoreCase("Fire")) {
            FireBender fireBender = new FireBender(benderInput[2], Integer.parseInt(benderInput[3]), Double.parseDouble(benderInput[4]));
            return fireBender;
        } else {
            EarthBender earthBender = new EarthBender(benderInput[2], Integer.parseInt(benderInput[3]), Double.parseDouble(benderInput[4]));
            return earthBender;
        }
    }
}
