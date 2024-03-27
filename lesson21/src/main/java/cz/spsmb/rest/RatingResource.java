package cz.spsmb.rest;

import cz.spsmb.dao.GameRepository;
import cz.spsmb.model.Game;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import cz.spsmb.dto.RatingDTO;
import cz.spsmb.model.Rating;

@Path("/rating")
public class RatingResource {
    @Inject
    GameRepository gameRepository;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("{id}")
    public Response setRating(@PathParam("id") long gameId, RatingDTO ratingDTO){
        if(!isValidInput(ratingDTO) || gameId <= 0){
            return Response.status(400).entity("Shit aint valid unlike you bbg").build();
        }
        Game game = gameRepository.findById(gameId);
        if(!game.toString().isEmpty()){
            Rating rating = new cz.spsmb.model.Rating();
            rating.setRating(ratingDTO.getRating());
            rating.setGame(game);
        }
        return Response.status(404).entity(String.format("Game id not found", gameId)).build();
    }

    private boolean isValidInput(RatingDTO ratingDTO) {
        return (ratingDTO.getRating() > 0 && ratingDTO.getRating() <= 5);
    }

}
