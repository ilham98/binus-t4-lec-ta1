public abstract class User {
    protected String name;
    protected String userId;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public void interact() {
        System.out.println("User interacting with the system.");
    }

    public abstract boolean hasPermission(String action);

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }
}
