package vl_2020_11_19.fileio;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Attendee {
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
    private String name;
    private String address;
    private Calendar calendar;

    // constructor
    public Attendee(String name, String address, Calendar calendar) {
        this.name = name;
        this.address = address;
        this.calendar = calendar;
    }

    /*
     * Formatted getters
     */
    public String getFormattedDate() {
        return dateFormatter.format(Date.from(getCalendar().toInstant()));
    }

    public String getFormattedTime() {
        return timeFormatter.format(Date.from(getCalendar().toInstant()));
    }


    /*
     * Getters & Setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
