package com.yocollection.core;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class GameController {
    private GameRepository repository;

    public GameController (GameRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/games")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Game> games() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

}
