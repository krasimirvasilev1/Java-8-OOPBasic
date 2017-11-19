package ThirdExersiceInheritance.MordorsCrueltyPlan;

public class CalcGandalfMood {

    public int CalcGandalfHappiness (String[] foods){
        int happiness = 0;
        for (String food : foods) {
            switch(food){
                case "CRAM":
                    happiness+=2;
                    break;
                case "LEMBAS":
                    happiness+=3;
                    break;
                case "APPLE":
                    happiness+=1;
                    break;
                case "MELON":
                    happiness+=1;
                    break;
                case "HONEYCAKE":
                    happiness+=5;
                    break;
                case "MUSHROOMS":
                    happiness-=10;
                    break;
                    default:
                        happiness-=1;
                        break;
            }
        }
        return happiness;
    }

    public String calcGandalfMood (int gandalfHappiness){
        if (gandalfHappiness < -5){
            return "Angry";
        }
        else if(gandalfHappiness <= 0){
            return "Sad";
        }
        else if(gandalfHappiness <= 15){
            return "Happy";
        }
        else{
            return "JavaScript";
        }
    }
}
