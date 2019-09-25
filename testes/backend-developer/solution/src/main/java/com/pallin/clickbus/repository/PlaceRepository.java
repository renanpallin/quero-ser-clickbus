package com.pallin.clickbus.repository;

import com.pallin.clickbus.model.Place;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PlaceRepository extends CrudRepository<Place, Long> {

    @Query("FROM Place p WHERE p.name LIKE %:query%")
    public Iterable<Place> getByName(@Param("query") String query);
}
