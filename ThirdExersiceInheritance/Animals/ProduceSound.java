package ThirdExersiceInheritance.Animals;

public class ProduceSound {

    public String produceSound (String typeOfAnimal){
        switch (typeOfAnimal){
            case "Cat":
                return "MiauMiau";
            case "Dog":
                return "BauBau";
            case "Frog":
                return "Frogggg";
            case "Kitten":
                return "Miau";
            case "Tomcat":
                return "Give me one million b***h";
            case "Animal":
                return "Not implemented!";
        }
        return "";
    }
}
