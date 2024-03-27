package cz.spsmb.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import cz.spsmb.model.*;

import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class RatingRepository implements PanacheRepository<Rating> {
    public List<Rating> listByName(String name){

        return find("name", name).list();
    }

    public Rating listById(Long id){
        return findById(id);
    }
}
