
package ebank_new;

public class Account {

    private String username;
    private String password;

    public Account(String username, String password) {    // tí vào phải set lại giá trị
        setUsername(username);
        setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username is not empty!");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password is not empty!");
        }
        this.password = password;
    }
}
