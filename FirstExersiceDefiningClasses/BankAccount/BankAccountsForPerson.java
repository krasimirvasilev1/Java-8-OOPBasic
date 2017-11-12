package FirstExersiceDefiningClasses.BankAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BankAccountsForPerson {
    private HashMap<Integer,Double> accounts;

    public HashMap<Integer, Double> getAccounts() {
        return accounts;
    }

    public void setAccounts(HashMap<Integer, Double> accounts) {
        this.accounts = accounts;
    }

    public BankAccountsForPerson(HashMap<Integer, Double> accounts) {
        this.accounts = accounts;
    }

    public double sumOfAllAccounts (HashMap<Integer,Double> bankAccounts){
        double sum = 0;
            for (Double aDouble : bankAccounts.values()) {
                sum += aDouble;
            }
           return sum;
    }
}
