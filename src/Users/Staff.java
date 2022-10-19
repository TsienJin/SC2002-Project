public class Staff extends User{
    
    private String username;
    private String password;

    public Staff(int id, String name, String email, Role role, String username, String password){
        super(id, name, email, role);
        this.username = username;
        this.password = password;
    }

    public void printInfo(){
        super.printInfo();
        System.out.printf("Username: \t%s\n" +
                            "Password: \t%s\n", this.username, this.password);
    }

    public String getCredentials(){
        return this.username, this.password;
    }
    
    //private csvDriver

    // public enum getRole(){
    //     return 1;
    // }

    public void login(){
        //passes username and password to csvDriver
    }
    public void configure(){
        //wait
    }
}
