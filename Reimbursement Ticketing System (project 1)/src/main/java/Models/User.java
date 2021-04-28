package Models;

public class User {
    private int userID;
    private String username;
    private String firstname;
    private String role;

    public User() {
    }

    public User(int userID, String username, String firstname, String role) {
        this.userID= userID;
        this.username = username;
        this.firstname = firstname;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getRole() {
        return role;
    }

    public int getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
