package vl_2020_11_12;

import java.util.Objects;

public class Account {
    private String username;
    private String phone;

    public Account(String username, String phone) {
        this.username = username;
        this.phone = phone;
    }

    /*
     * Getters and Setters
     */

    // username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /*
     * equals & hasCode generators
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return o.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, phone);
    }
}
