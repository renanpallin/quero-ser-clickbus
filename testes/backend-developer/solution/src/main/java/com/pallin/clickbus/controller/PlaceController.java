package com.pallin.clickbus.controller;

import com.pallin.clickbus.model.Place;
import com.pallin.clickbus.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/place")
public class PlaceController {

    @Autowired
    private PlaceRepository repository;

    /**
     * List all registered places
     * @return all places
     */
    @GetMapping()
    public Iterable<Place> index() {
        return repository.findAll();
    }

    /**
     * List a place by id
     * @param place
     * @return place
     */
    @GetMapping("{place}")
    public ResponseEntity<Place> showById(@PathVariable Place place) {
        if (place == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(place, HttpStatus.OK);
    }

    /**
     * Create a place by JSON payload
     * @param place
     * @return the created Place
     */
    @PostMapping
    public Place create(@RequestBody Place place) {
        return repository.save(place);
    }

    /**
     * Replace the oldPlace with the newPlace based on its id
     * @param oldPlace
     * @param newPlace
     * @return new updated place
     */
    @PutMapping("{oldPlace}")
    public ResponseEntity<Place> update(@PathVariable Place oldPlace, @RequestBody Place newPlace) {
        if (oldPlace == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        newPlace.setId(oldPlace.getId());
        return new ResponseEntity<>(repository.save(newPlace), HttpStatus.OK) ;
    }

    /**
     * Delete a place by id
     * @param place
     * @return the deleted place
     */
    @DeleteMapping("{place}")
    public ResponseEntity<Place> destroy(@PathVariable Place place) {
        if (place == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        repository.delete(place);
        return new ResponseEntity<>(place, HttpStatus.OK);
    }
}
