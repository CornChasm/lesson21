package cz.spsmb.view;

import jakarta.inject.Inject;
import cz.spsmb.dao.*;
import cz.spsmb.model.*;

import java.util.List;

public class GameView {
    @Inject
    GameRepository gameRepository;
    List<Game> games;
    public void init(){
        games = gameRepository.listAll();
    }

    public GameRepository getGameRepository() {
        return gameRepository;
    }

    public void setGameRepository(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
