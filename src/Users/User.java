public interface User{

    public String name;
    public enum Role {STAFF, CUSTOMER};
    public Role role;
    public Role getRole();

}