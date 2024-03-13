package cz.spsmb.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "game")
public class Game implements Serializable {
    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    String author;
    long playerAmount;
    @OneToMany(mappedBy = "rating")
    List<Rating> ratingList = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "category_id", nullable = false)
    Category category;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getPlayerAmount() {
        return playerAmount;
    }

    public void setPlayerAmount(long playerAmount) {
        this.playerAmount = playerAmount;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", playerAmount=" + playerAmount +
                ", ratingList=" + ratingList +
                ", category=" + category +
                '}';
    }
}
