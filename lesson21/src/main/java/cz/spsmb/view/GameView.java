package cz.spsmb.view;

import cz.spsmb.dto.GameDTO;
import cz.spsmb.rest.GameResource;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import cz.spsmb.dao.*;
import cz.spsmb.model.*;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import java.util.List;

@Named
@RequestScoped
public class GameView {
    @Inject
    GameRepository gameRepository;
    @Inject
    RatingRepository ratingRepository;
    @Inject
    CategoryRepository categoryRepository;

    List<Game> games;
    List<Category> categories;
    GameDTO newGame;

    @PostConstruct
    public void init(){
        System.out.println(categoryRepository.listAll());
        newGame = new GameDTO();
    }
    @Transactional
    public void saveGame(){
        GameResource gameResource = new GameResource();
        Game game = new Game();
        game.setName(newGame.getName());
        game.setAuthor(newGame.getAuthor());
        game.setPlayerAmount(newGame.getPlayerAmount());
        String categoryString = newGame.getCategory();
        List<Category> categoryList = categoryRepository.listByName(categoryString);
        if(categoryRepository.listByName(categoryString).isEmpty()){
            Category category = new Category();
            category.setName(categoryString);
            game.setCategory(category);
            categoryRepository.persist(category);
        } else{
            game.setCategory(categoryList.getFirst());
        }
        gameRepository.persist(game);
        init();
    }

    public GameRepository getGameRepository() {
        return gameRepository;
    }

    public void setGameRepository(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public RatingRepository getRatingRepository() {
        return ratingRepository;
    }

    public void setRatingRepository(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public GameDTO getNewGame() {
        return newGame;
    }

    public void setNewGame(GameDTO newGame) {
        this.newGame = newGame;
    }
}
