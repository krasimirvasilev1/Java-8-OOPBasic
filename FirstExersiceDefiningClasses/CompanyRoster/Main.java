package FirstExersiceDefiningClasses.CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(console.readLine());
        HashMap<String, Department> companyInfo = new HashMap<>();
        for (int i = 0; i < number; i++) {
            String[] input = console.readLine().split(" ");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            Employee employee = new Employee(name, salary, position, department);
            switch (input.length) {
                case 5:
                    if (input[4].contains("@")) {
                        employee.setEmail(input[4]);
                    } else {
                        employee.setAge(Integer.parseInt(input[4]));
                    }
                    break;
                case 6:
                    String email = input[4];
                    int age = Integer.parseInt(input[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
            }
            if (companyInfo.containsKey(department)) {
                companyInfo.get(department).department.add(employee);
            } else {
                List<Employee> newList = new ArrayList<>();
                newList.add(employee);
                Department department1 = new Department(newList);
                companyInfo.put(department, department1);

            }
        }
        Stream<Map.Entry<String, Department>> sortedDepartment = companyInfo.entrySet().stream().sorted((x, y) ->
                Double.compare(y.getValue().department.stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                        x.getValue().department.stream().mapToDouble(Employee::getSalary).average().getAsDouble())).limit(1);

        sortedDepartment.forEach(x -> {
            System.out.println("Highest Average Salary: " + x.getKey());
            x.getValue().department.stream().sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                    .forEach(z -> System.out.println(z));
        });
    }
}
