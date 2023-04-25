package inheritance;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private double stars;
    private String priceCategory;
    private ArrayList<Review> reviews; // List of review objects per store

    //Constructor Restaurant
    public Restaurant(String name, double stars, String priceCategory) {
        this.name = name;
        this.stars = stars;
        this.priceCategory = priceCategory;
        this.reviews = new ArrayList<>(); // Init list
    }
    //review list getter
    public void addReview(Review review) {
        reviews.add(review);
        updateStars();//deposit you stars.
    }

    //update stars based on current reviews
    private void updateStars() {
        int totalStars = 0;
        for (Review review : reviews) {
            totalStars += review.getStars();
        }
        this.stars = totalStars / reviews.size();
    }

    // Getter method for name
    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", stars=" + stars +
                ", priceCategory='" + priceCategory + '\'' +
                '}';
    }

    // Getter method for star rating update
    public double getStars() {
        return stars;
    }
}
