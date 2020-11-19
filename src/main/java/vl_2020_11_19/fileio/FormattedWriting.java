package vl_2020_11_19.fileio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public class FormattedWriting {
    public static void main(String[] args) {
        Attendee[] attendees = {
                new Attendee("Phil", "At home", Calendar.getInstance()),
                new Attendee("Tobi", "New home", Calendar.getInstance()),
                new Attendee("Ben", "Springfield", Calendar.getInstance()),
                new Attendee("Benni", "Nashville", Calendar.getInstance()),
                new Attendee("Johanna", "Chernobyl", Calendar.getInstance())
        };

        try {
            PrintWriter pw = new PrintWriter(new FileWriter("output_fwriting.txt", true));

            // write out each attendee
            for (Attendee a : attendees) {
                pw.format("%-20s %-20s %-20s %-20s", a.getName(), a.getAddress(), a.getFormattedDate(), a.getFormattedTime());
                pw.println();
            }

            // flush to file and close
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
