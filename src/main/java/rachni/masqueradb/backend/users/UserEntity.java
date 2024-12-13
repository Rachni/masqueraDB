package rachni.masqueradb.backend.users;

public class UserEntity {
    private int ID;
    private String username;
    private String password;
    private String email;

    public UserEntity(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                //pass hidden
                ", email='" + email + '\'' +
                '}';
    }
}
