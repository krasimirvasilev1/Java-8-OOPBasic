package ExamMay08Mine.Engine;

import ExamMay08Mine.Monuments.*;

public class MonumentController {

    public Monument monumentCreate(String[] benderInput) {
        String elementOfBender = benderInput[1];
        if (elementOfBender.equalsIgnoreCase("Air")) {
            AirMonument airMonument = new AirMonument(benderInput[2], Integer.parseInt(benderInput[3]));
            return airMonument;
        } else if (elementOfBender.equalsIgnoreCase("Water")) {
            WaterMonument waterMonument = new WaterMonument(benderInput[2], Integer.parseInt(benderInput[3]));
            return waterMonument;
        } else if (elementOfBender.equalsIgnoreCase("Fire")) {
            FireMonument fireMonument = new FireMonument(benderInput[2], Integer.parseInt(benderInput[3]));
            return fireMonument;
        } else {
            EarthMonument earthMonument = new EarthMonument(benderInput[2], Integer.parseInt(benderInput[3]));
            return earthMonument;
        }
    }
}
