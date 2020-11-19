package vl_2020_11_19.fileio;

import java.io.*;
import java.util.ArrayList;

public class HighscoreManager {
    public static void main(String[] args) {
        // create list of scores
        ArrayList<Score> highscores = new ArrayList<>();

        // read highscores from file
        try {
            FileInputStream fis = new FileInputStream(new File("output_fos.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object input = ois.readObject();
            if (input instanceof ArrayList<?>) {
                highscores = (ArrayList<Score>) input;
            }

            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        // modify score
        highscores.sort(Score::compareTo);
        highscores.get(0).setPoints(1000);

        // list scores
        for (Score s : highscores) {
            System.out.printf("%-10s --> %-4d", s.getName(), s.getPoints());
            System.out.println();
        }

        // create some scores
        /*
        highscores.add(new Score(420, "TeeT"));
        highscores.add(new Score(419, "TooT"));
        highscores.add(new Score(42, "TiiT"));
        highscores.add(new Score(69, "TaaT"));
        highscores.add(new Score(88, "TuuT"));
        */

        // create writer
        try {
            FileOutputStream fos = new FileOutputStream(new File("output_fos.txt"), false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(highscores);
            oos.flush();
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
