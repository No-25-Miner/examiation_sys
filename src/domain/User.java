package domain;

public class User {
    private String sno;
    private String username;
    private String password;
    private int number_of_times;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumber_of_times() {
        return number_of_times;
    }

    public void setNumber_of_times() {
        this.number_of_times = 0;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
}
