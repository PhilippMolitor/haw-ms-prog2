package vl_2020_11_19.fileio;

import java.io.*;
import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String path = "";
        String text = "";
        String descision = "";

        System.out.print("Enter a file path: ");
        path = sc.nextLine();

        System.out.print("Write this to the file: ");
        text = sc.nextLine();

        System.out.print("Show file? (y/j/N): ");
        descision = sc.nextLine();

        File file = new File(path);

        try {
            FileWriter out = new FileWriter(file, true);
            BufferedWriter writer = new BufferedWriter(out);

            writer.append(text);
            writer.newLine();

            // close handles
            writer.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

        if (descision.equalsIgnoreCase("y") || descision.equalsIgnoreCase("j")) {
            try {
                FileReader in = new FileReader(file);
                BufferedReader reader = new BufferedReader(in);
                reader.lines().forEach(s -> System.out.println(s));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
