public class Order {

    private Restaurant restaurant;
    private int quantity;

    public Order(Restaurant restaurant, int quantity) {
        this.restaurant = restaurant;
        this.quantity = quantity;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
