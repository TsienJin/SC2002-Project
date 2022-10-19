public class Customer extends User{
    
    private int mobileNumber;
    private int age;

    public Customer(int id, String name, String email, Role role, int mobileNumber, int age){
        super(id, name, email, role);
        this.mobileNumber = mobileNumber;
        this.age = age;
    }

    public void printInfo(){
        super.printInfo();
        System.out.printf("Mobile No.: \t%d\n" +
                            "Age: \t%d\n", this.mobileNumber, this.age);
    }
    //private csvDriver

    //public void createBooking(){
        //passes to csvDriver
    //}

}