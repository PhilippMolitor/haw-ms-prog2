package vl_2020_11_12;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class AverageCalculator {
    Scanner sc;
    ArrayList<Double> inputValues;

    public static void main(String[] args) {
        AverageCalculator mw = new AverageCalculator();
        mw.runInputSequence();
        mw.printAverage();
    }

    public AverageCalculator() {
        sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        inputValues = new ArrayList();
    }

    void runInputSequence() {
        while (!sc.hasNext("quit")) {
            System.out.print("Add a new value: ");
            System.out.flush();

            try {
                if(sc.hasNextDouble()) {
                    inputValues.add(sc.nextDouble());
                } else if (sc.hasNext()) {
                    System.out.println("Unknown input type.");
                    sc.next();
                }
            } catch (Exception ex) {
                System.out.println("Error: The supplied value as was of type double!");
            }
        }
        sc.close();
    }

    void printAverage() {
        double sum = 0;
        for (double d: inputValues) {
            sum += d;
        }
        double avg = sum / inputValues.size();

        System.out.println("Average: " + avg);
    }
}
