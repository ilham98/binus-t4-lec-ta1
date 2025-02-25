public class Admin extends User {

    public Admin(String name, String userId) {
        super(name, userId);
    }

    @Override
    public void interact() {
        System.out.println("Admin managing the library system.");
    }

}
