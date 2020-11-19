package vl_2020_11_19.fileio;

import java.io.Serializable;

public class Score implements Comparable<Score>, Serializable {
    private int points;
    private String name;

    public Score(int points, String name) {
        this.points = points;
        this.name = name;
    }

    @Override
    public int compareTo(Score score) {
        return score.getPoints() - points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
