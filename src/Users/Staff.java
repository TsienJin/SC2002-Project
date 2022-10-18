public class Staff implements User{
    
    private int id;
    private String username;
    private String password;
    private String email;

    public Staff(String name, int id, String username, String password, String email, Role role){
        this.name = name;
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Role getRole(){
        return this.role;
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
