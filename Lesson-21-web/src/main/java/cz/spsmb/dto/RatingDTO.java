package cz.spsmb.dto;

public class RatingDTO {
    int id;
    int rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "RatingDTO{" +
                "id=" + id +
                ", rating=" + rating +
                '}';
    }
}
