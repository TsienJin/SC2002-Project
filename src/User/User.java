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

    public void printInfo(){
        System.out.printf("ID: \t%d\n" +
                        "Name: \t%s\n" +
                        "Email: \t%s\n" +
                        "Role: \t%s\n"
                        , this.id, this.name, this.email, this.role);
    }

    public void showMenu(Role role){
        if(role == User.Role.CUSTOMER){
            Menu.printCustomerMenu();
        }
        else{
            Menu.printStaffMenu();
        }
    }
}