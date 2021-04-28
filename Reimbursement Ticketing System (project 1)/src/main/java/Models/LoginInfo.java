package Models;

public class LoginInfo {
    String username;
    String password;

    public LoginInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginInfo() {
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

    @Override
    public String toString() {
        return "LoginInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
