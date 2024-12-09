import java.util.ArrayList;
import java.util.List;

public class UserController {

    List<User> userList;

    public UserController() {
        userList = new ArrayList<>();
    }

    public User addUser(String name, String gender, String phoneNumber, String pinCode) {
        User user = new User(name, gender, phoneNumber, pinCode);
        userList.add(user);
        return user;
    }

    public User getUserFromPhoneNumber(String phoneNumber) {
        for(User user: userList) {
            if (user.getPhoneNumber().equals(phoneNumber)) {
                return user;
            }
        }
        return null;
    }
}
