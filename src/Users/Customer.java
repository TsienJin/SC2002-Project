public class Customer implements User{
    
    private String email;
    private int mobileNumber;
    //private String name;
    private int age;

    public Customer(String name, String email, int mobileNumber, int age, Role role){
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.role = role;
    }

    public Role getRole(){
        return this.role;
    }

    //private csvDriver

    public void createBooking(){
        //passes to csvDriver
    }

}