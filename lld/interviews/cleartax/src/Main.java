import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ClearFood clearFood = new ClearFood();
        clearFood.register_user("Mahfooz", "M", "8011990817", "ABC");
        clearFood.register_user("Shubham", "M", "8011990821", "HCP");
        clearFood.loginUser("8011990817");

        List<String> pincodes = new ArrayList<>();
        pincodes.add("ABC");
        clearFood.register_restaurant("Rest1", pincodes, "food1", 120, 2);
        pincodes.add("HCP");
        clearFood.register_restaurant("Rest2", pincodes, "food2", 150, 5);

        clearFood.showRestaurant();

        clearFood.place_order("Rest1", 1);

        clearFood.createReview("Rest1", 1, "Very bad food");

    }
}
