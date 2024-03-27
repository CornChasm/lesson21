package cz.spsmb.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import cz.spsmb.model.*;


import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class CategoryRepository implements PanacheRepository<Category> {
    public List<Category> listByName(String name){

        return find("name", name).list();
    }

    public Category listById(Long id){
        return findById(id);
    }
}
