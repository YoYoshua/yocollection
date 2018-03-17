package com.yocollection.core;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@EnableWebMvc
@CrossOrigin(origins = "http://localhost:4200")
public class GameController {
    private GameRepository repository;

    public GameController (GameRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/games")
    public Collection<Game> games() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/games/search/{name}")
    public Collection<Game> matchingGames(@PathVariable String name) {
        return repository.findByName(name).stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/games/sortBy={sort}&{order}")
    public Collection<Game> sortBy(@PathVariable String sort, @PathVariable String order) {
        Collection<Game> result;

        switch(sort) {
            case "Name":
                result = repository.findAll().stream()
                        .collect(Collectors.toList());
                break;
            case "Platform":
                result = repository.orderByPlatformAsc().stream()
                        .collect(Collectors.toList());
                System.out.println("You chose sorting by platform!");
                break;
            case "Rating":
                result = repository.orderByRatingAsc().stream()
                        .collect(Collectors.toList());
                System.out.println("You chose sorting by rating!");
                break;
            default:
                result = repository.findAll().stream()
                        .collect(Collectors.toList());
                System.out.println("You chose wrong sorting!");
                break;
        }
        return result;
    }
}
