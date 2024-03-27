package cz.spsmb.rest;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import cz.spsmb.dao.*;
import cz.spsmb.dto.GameDTO;
import cz.spsmb.model.*;

import java.util.List;

@Path("/game")
public class GameResource {
    @Inject
    GameRepository gameRepository;
    @Inject
    CategoryRepository categoryRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response list() {
        List<Game> game = gameRepository.listAll();
        return Response.ok().entity(game).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getById(@PathParam("id") Long id) {
        Game game = gameRepository.findById(id);
        return Response.ok().entity(game).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteById(@PathParam("id") long id) {
        gameRepository.deleteById(id);
        return Response.ok().entity("ok").build();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response save(GameDTO gameDTO) {
        Game game = new Game();
        game.setName(gameDTO.getName());
        game.setAuthor(gameDTO.getAuthor());
        game.setPlayerAmount(gameDTO.getPlayerAmount());
        String categoryString = gameDTO.getCategory();
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
        if(gameDTO.getName().isEmpty() || gameDTO.getAuthor().isEmpty()){
            return Response.status(400).entity("Invalid Input").build();
        }
        return Response.ok(game).build();

    }
}
