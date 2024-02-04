package bfu.oop.lab5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class UserManager implements IUserManager {
    private User currentUser;
    private IUserRepository userRepository;
    private FileCurrentUserRepository currentUserRepository;

    public UserManager(IUserRepository userRepository, FileCurrentUserRepository currentUserRepository) {
        this.currentUserRepository = currentUserRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUserRepository.getUser();
    }

    @Override
    public void signIn(User user) {
        userRepository.add(user);
        currentUser = user;
        currentUserRepository.add(user);
    }

    @Override
    public void signOut(User user) {
        if (currentUser != null && currentUser.getId() == user.getId()) {
            userRepository.remove(user);
            currentUser = null;
            currentUserRepository.remove(user);
        }
    }
    
    @Override
    public void loadCurrentUser() {
        currentUser = currentUserRepository.getUser();
    }
    
    @Override
    public boolean isAuthorized() {
        return currentUser != null;
    }
}
