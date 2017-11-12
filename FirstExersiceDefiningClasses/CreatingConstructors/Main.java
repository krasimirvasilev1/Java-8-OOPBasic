package FirstExersiceDefiningClasses.CreatingConstructors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, InstantiationException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Class personClass = Person.class;
        Constructor emptyCtor = personClass.getDeclaredConstructor();
        Constructor ageCtor = personClass.getDeclaredConstructor(int.class);
        Constructor nameAgeCtor = personClass
                .getDeclaredConstructor(String.class, int.class);

        String name = console.readLine();
        int age = Integer.parseInt(console.readLine());

        Person emptyConstructor = (Person) emptyCtor.newInstance();
        Person onlyAge = (Person) ageCtor.newInstance(age);
        Person all = (Person) nameAgeCtor.newInstance(name,age);

        System.out.printf("%s %d%n",emptyConstructor.getName(),emptyConstructor.getAge());
        System.out.printf("%s %d%n",onlyAge.getName(),onlyAge.getAge());
        System.out.printf("%s %d%n",all.getName(),all.getAge());
    }
}
