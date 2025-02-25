public class Member extends User {

    public Member(String name, String userId) {
        super(name, userId);
    }

    @Override
    public void interact() {
        System.out.println("Member borrowing or returning books.");
    }

}
