package inheritance;

import java.util.ArrayList;

public class Theater {
    private String name;
    private String movies;
    private ArrayList<Review> reviews; // List of review objects per store

    //Constructor For Theater
    public Theater(String name, String movies) {
        this.name = name;
        this.movies = movies;
        this.reviews = new ArrayList<>(); // Init list
    }

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies;
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


