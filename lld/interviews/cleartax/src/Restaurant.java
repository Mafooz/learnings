import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant  implements Comparable{
    private String restaurantName;
    private List<String> servicablePinCodes;
    private Map<FoodItem, Integer> foodItems;

    List<Review> reviews;

    public Restaurant(String restaurantName, List<String> servicablePinCodes, String foodItemName, int foodItemPrice, int quantity) {
        this.restaurantName = restaurantName;
        this.servicablePinCodes = servicablePinCodes;
        foodItems = new HashMap<>();
        foodItems.put(new FoodItem(foodItemName, foodItemPrice), quantity);
        reviews = new ArrayList<>();
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public List<String> getservicablePinCodes() {
        return servicablePinCodes;
    }

    public void setservicablePinCodes(List<String> servicablePinCodes) {
        this.servicablePinCodes = servicablePinCodes;
    }

    public Map<FoodItem, Integer> getFoodItems() {
        return foodItems;
    }

    public void setQuantity(int quantity) {
        for(FoodItem foodItem: foodItems.keySet()) {
            foodItems.put(foodItem, quantity);
        }
    }

    public double getAvgRating() {
        int val=0;
        int count=0;
        for(Review review: reviews) {
            val = val+review.getRating();
            count++;
        }
        return (double)val/count;
    }

    @Override
    public int compareTo(Object o) {
        int currObjectPrice=0;
        int otherObjectPrice=0;
        Restaurant otherRestaurant = (Restaurant) o;
        for(FoodItem foodItem: this.getFoodItems().keySet()) {
            currObjectPrice = foodItem.getPrice();
            break;
        }
        for(FoodItem foodItem: otherRestaurant.getFoodItems().keySet()) {
            otherObjectPrice = foodItem.getPrice();
            break;
        }
        if (currObjectPrice < otherObjectPrice) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
