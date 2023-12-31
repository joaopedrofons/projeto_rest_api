package com.projet.projetojava.controller;

import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.service.AirlineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/airlines")
public class AirlineController {

    private final AirlineService airlineService;
    private static final Logger logger = LoggerFactory.getLogger(AirlineController.class);

    @Autowired
    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @PostMapping
    public Airline createAirLine(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        logger.info("createAirLine called with name: " + name);
        return airlineService.createAirLine(name);
    }

    @GetMapping
    public List<Airline> getAllAirlines() {
        logger.info("getAllAirlines called");
        return airlineService.getAllAirlines();
    }
}
