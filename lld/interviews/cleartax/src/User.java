import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {

    private final String userId;
    private String name;
    private Gender gender;
    private String phoneNumber;
    private String pinCode;
    List<Order> orderList;

    public User(String name, String genderString, String phoneNumber, String pinCode) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.gender = ("M".equals(genderString))?Gender.Male:Gender.Female;
        this.phoneNumber = phoneNumber;
        this.pinCode = pinCode;
        orderList = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void showAllOrders() {
        System.out.println("All orders for user " + this.name);
        for(Order order: orderList) {
            System.out.println(order.getRestaurant().getRestaurantName() + " " + order.getQuantity());
        }
    }
}
