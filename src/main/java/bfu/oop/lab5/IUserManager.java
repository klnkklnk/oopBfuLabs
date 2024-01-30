package bfu.oop.lab5;

public interface IUserManager {
    void signIn(User user);
    void signOut(User user);
    boolean isAuthorized();
}
