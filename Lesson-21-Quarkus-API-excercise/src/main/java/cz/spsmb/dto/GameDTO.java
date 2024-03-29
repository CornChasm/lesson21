package cz.spsmb.dto;

import cz.spsmb.model.Category;

public class GameDTO {
    String name;
    String author;
    String category;
    long playerAmount;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getPlayerAmount() {
        return playerAmount;
    }

    public void setPlayerAmount(long playerAmount) {
        this.playerAmount = playerAmount;
    }

    @Override
    public String toString() {
        return "GameDTO{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
