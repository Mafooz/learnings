import java.util.List;

public class ClearFood {

    RestaurantController restaurantController;
    UserController userController;
    User currentUser;

    public ClearFood() {
        restaurantController = new RestaurantController();
        userController = new UserController();
        currentUser = null;
    }

    public User register_user(String name, String genderString, String phoneNumber, String pinCode) {
        return userController.addUser(name, genderString, phoneNumber, pinCode);
    }

    public void loginUser(String phoneNumber) {
        currentUser = userController.getUserFromPhoneNumber(phoneNumber);
    }

    public void register_restaurant(String name, List<String> pinCodes, String foodName, int price, int quantity) {
        restaurantController.registerRestaurant(name, pinCodes, foodName, price, quantity);
    }

    public void showRestaurant() {
        restaurantController.showRestaurant("Price");
    }

    public void place_order(String restaurantName, int quantity) {
        if (!restaurantController.placeOrder(currentUser, restaurantName, quantity)) {
            System.out.println("Failed due to low quantity!!!");
        }
        else {
            System.out.println("Placed order!!");
        }
    }
    public void createReview(String restaurantName, int rating, String comment) {
        restaurantController.createReview(currentUser, restaurantName, rating, comment);
    }

    public void showAllOrder() {
        currentUser.showAllOrders();
    }
}
