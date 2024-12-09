package models;

public class User {

    private int id;
    private String name;
    private String email;
    private String phno;

    private UserDashboard userDashboard;
    User(int id, String name, String email, String phno) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phno = phno;
        userDashboard = new UserDashboard();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public UserDashboard getUserDashboard() {
        return userDashboard;
    }

    public void showBalance() {
        System.out.println(this.getUserDashboard().getTotalBalance());
    }
}
