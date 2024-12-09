package models;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    private List<User> allUsers;

    public UserController() {
        allUsers = new ArrayList<>();
    }

    public List<User> getAllUsers() {
        return allUsers;
    }
    public User createUser(String name, String email, String phno) {
        User user = new User(allUsers.size(), name, email, phno);
        allUsers.add(user);
        return user;
    }

    public void updateUser(int id, String name, String email, String phno) {
        allUsers.get(id).setEmail(email);
        allUsers.get(id).setName(name);
        allUsers.get(id).setPhno(phno);
    }

    public void removeUser(int id) {
        allUsers.remove(id);
    }

    public void showAllBalances() {
        for(User user: allUsers) {
            System.out.print("User " + user.getName() + ": ");
            user.showBalance();
        }
    }
}
