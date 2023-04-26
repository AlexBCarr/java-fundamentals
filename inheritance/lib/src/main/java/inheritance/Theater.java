package inheritance;

import java.util.ArrayList;

public class Shop {
    private String name;
    private String movies;
    private ArrayList<Review> reviews; // List of review objects per store

    //Constructor Restaurant
    public Shop(String name, String description, String priceCategory) {
        this.name = name;
        this.movies = movies;
        this.reviews = new ArrayList<>(); // Init list
    }
    //review list getter
    public void addReview(Review review) {
        reviews.add(review);
    }


    // Getter method for name
    @Override
    public String toString() {
        return "Theater{" +
                "name='" + name + '\'' +
                ", movies=" + movies +
                '}';
    }

}


