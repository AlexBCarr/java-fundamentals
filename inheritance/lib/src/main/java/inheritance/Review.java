package inheritance;

public class Review {
    private String body;
    private String author;
    private double stars;
    //constructor to instantiate review object
    public Review(String body, String author, double stars) {
        this.body = body;
        this.author = author;
        this.stars = stars;
    }
    //getting stars
    public double getStars() {
        return stars;
    }
    //to string method
    @Override
    public String toString() {
        return "Review{" +
                "body='" + body + '\'' +
                ", author='" + author + '\'' +
                ", stars=" + stars +
                '}';
    }
}