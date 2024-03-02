public class User {
    private String role;
    private  String fullname;
    private int id;


    User(){}

    public User(String role, String fullname, int id, String password) {
        this.role = role;
        this.fullname = fullname;
        this.id = id;
        this.password = password;
    }

    private  String password;

    public String getRole() {
        return role;
    }

    public String getFullname() {
        return fullname;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
