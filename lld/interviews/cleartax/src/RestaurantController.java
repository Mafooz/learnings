import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestaurantController {

    List<Restaurant> restaurantList;

    public RestaurantController() {
        restaurantList = new ArrayList<>();
    }
    public Restaurant registerRestaurant(String name, List<String> pinCodes, String foodItemName, int price, int quantity) {
        Restaurant restaurant = new Restaurant(name, pinCodes, foodItemName, price, quantity);
        restaurantList.add(restaurant);
        return restaurant;
    }

    public Restaurant updateRestaurant(String restaurantName, List<String> pinCodes) {
        for(Restaurant restaurant: restaurantList) {
            if (restaurant.getRestaurantName().equals(restaurantName)) {
                restaurant.setservicablePinCodes(pinCodes);
                return restaurant;
            }
        }
        return null;
    }

    public void showRestaurant(String type) {
        List<Restaurant> restaurants = getServicableRestaurants();
        Collections.sort(restaurants);
        for(Restaurant restaurant: restaurants) {
            System.out.println("For restaurant name " + restaurant.getRestaurantName() + " food items are");
            for(FoodItem foodItem: restaurant.getFoodItems().keySet()) {
                System.out.println(foodItem.getName() + " " + foodItem.getPrice());
            }
        }

    }

    public void createReview(User user, String restaurantName, int rating, String comment) {
        for(Restaurant restaurant: restaurantList) {
            if (restaurant.getRestaurantName().equals(restaurantName)) {
                restaurant.addReview(new Review(user, comment, rating));
                return;
            }
        }
    }
    public List<Restaurant> getServicableRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        for(Restaurant restaurant: restaurantList) {
            for(FoodItem foodItem: restaurant.getFoodItems().keySet()) {
                if (restaurant.getFoodItems().get(foodItem)>0) {
                    restaurants.add(restaurant);
                    break;
                }
            }
        }
        return restaurants;
    }

    public boolean placeOrder(User user, String restaurantName, int quantity) {
        for(Restaurant restaurant: restaurantList) {
            if (restaurant.getRestaurantName().equals(restaurantName)) {
                for(FoodItem foodItem: restaurant.getFoodItems().keySet()) {
                    if (restaurant.getFoodItems().get(foodItem)>quantity) {
                        Order order = new Order(restaurant, quantity);
                        user.addOrder(order);
                        restaurant.setQuantity(restaurant.getFoodItems().get(foodItem)-quantity);
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
