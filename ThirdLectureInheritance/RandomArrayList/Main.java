package ThirdLectureInheritance.RandomArrayList;


public class  Main {
    public static void main(String[] args) {
        RandomArrayList randomArrayList = new RandomArrayList();
        randomArrayList.add(3);
        randomArrayList.add("a");
        randomArrayList.add(3);
        randomArrayList.add("a");
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList);
    }
}
