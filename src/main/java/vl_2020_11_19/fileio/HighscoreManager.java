package vl_2020_11_19.fileio;

import java.io.*;
import java.util.ArrayList;

public class HighscoreManager {
    public static void main(String[] args) {
        // create list of scores
        ArrayList<Score> highscores = new ArrayList<>();
        highscores.add(new Score(420, "TeeT"));
        highscores.add(new Score(419, "TooT"));
        highscores.add(new Score(42, "TiiT"));
        highscores.add(new Score(69, "TaaT"));
        highscores.add(new Score(88, "TuuT"));

        // create writer
        try {
            FileOutputStream fos = new FileOutputStream(new File("output_fos.txt"), false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Score s : highscores) {
                oos.writeObject(s);
            }
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
