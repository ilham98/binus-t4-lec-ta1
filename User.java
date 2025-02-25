public class User {
    protected String name;
    protected String userId;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public void interact() {
        System.out.println("User interacting with the system.");
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }
}
