package vl_2020_11_19.fileio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String path = "";
        String text = "";

        System.out.print("Enter a file path: ");
        path = sc.nextLine();

        System.out.print("Write this to the file: ");
        text = sc.nextLine();

        try {
            File file = new File(path);
            FileWriter out = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(out);

            writer.write(text);
            writer.newLine();

            // close handles
            writer.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
