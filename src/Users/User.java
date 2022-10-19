public class User{

    public int id;
    public String name;
    public String email;
    public enum Role {STAFF, CUSTOMER};
    public Role role;

    public User(int id, String name, String email, Role role){
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public Role getRole(){
        return this.role;
    }
}