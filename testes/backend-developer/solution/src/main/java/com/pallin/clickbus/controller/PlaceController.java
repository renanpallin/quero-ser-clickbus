package com.pallin.clickbus.controller;

import com.pallin.clickbus.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/place")
public class PlaceController {

    @Autowired
    private PlaceRepository repository;

    @GetMapping()
    public String index() {
        return "Bora ser clickbuser";
    }

}
