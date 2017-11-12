package FirstExersiceDefiningClasses.BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Objects {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, HashMap<Integer, Double>> personsAccounts = new HashMap<>();
        String[] namesAndAccounts = console.readLine().split(" ");

        while (!namesAndAccounts[0].equals("END")) {
            String name = namesAndAccounts[0];
            int bankId = Integer.parseInt(namesAndAccounts[1]);
            double accountBalance = Double.parseDouble(namesAndAccounts[2]);

            if (personsAccounts.containsKey(name)) {
                if (personsAccounts.get(name).containsKey(bankId)) {
                    personsAccounts.get(name).put(bankId, personsAccounts.get(name).get(bankId) + accountBalance);
                } else {
                    personsAccounts.get(name).put(bankId, accountBalance);
                }
            } else {
                personsAccounts.put(name, new HashMap<>());
                personsAccounts.get(name).put(bankId, accountBalance);
            }

            namesAndAccounts = console.readLine().split(" ");
        }

        for (Map.Entry<String, HashMap<Integer, Double>> stringHashMapEntry : personsAccounts.entrySet()) {
            BankAccountsForPerson bankAccountsForPerson = new BankAccountsForPerson(stringHashMapEntry.getValue());
            double resultPerPerson = bankAccountsForPerson.sumOfAllAccounts(bankAccountsForPerson.getAccounts());
            System.out.println(stringHashMapEntry.getKey() + " == " + resultPerPerson);
        }
    }
}



