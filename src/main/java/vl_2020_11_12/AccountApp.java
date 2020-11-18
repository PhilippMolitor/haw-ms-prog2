package vl_2020_11_12;

import java.util.HashSet;
import java.util.Scanner;

public class AccountApp {
    Scanner sc;
    HashSet<Account> accounts;

    public static void main(String[] args) {
        AccountApp app = new AccountApp();

        app.addAccount(new Account("phil", "+4940123456"));
        app.addAccount(new Account("johanna", "+4940654321"));
        app.addAccount(new Account("benni", "+4940135246"));
        app.addAccount(new Account("tobi", "+4940246135"));

        app.inputLoop();
    }

    public AccountApp() {
        sc = new Scanner(System.in);
        accounts = new HashSet<>();
    }

    public void addAccount(Account a) {
        accounts.add(a);
    }

    public void inputLoop() {
        System.out.println("Create new vl_2020_11_12.Account, enter 'exit' to quit any time.");

        while(!sc.hasNext("exit")) {
            String name = "";
            String phone = "";

            System.out.print("vl_2020_11_12.Account name: ");
            System.out.flush();
            name = sc.next();

            System.out.print("vl_2020_11_12.Account phone: ");
            System.out.flush();
            phone = sc.next();

            // check whether account name or phone is already in the hashmap
            boolean taken = false;

            for (Account a: accounts) {
                if (a.getUsername().equals(name) || a.getPhone().equals(phone)) {
                    System.out.println("Error: username or phone number already taken.");
                    taken = true;
                }
            }

            if (!taken) accounts.add(new Account(name, phone));
        }
    }
}
