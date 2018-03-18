package com.yocollection.core;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Iterator;
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

    @GetMapping("/games/sortBy={sort}&{order}|filter={filterParams}")
    public Collection<Game> getAll(@PathVariable String sort, @PathVariable String order,
                                   @PathVariable String filterParams) {

        Collection<Game> result, sorted, filtered;

        sorted = sortBy(sort, order);
        filtered = filter(filterParams);
        result = intersection(sorted, filtered);

        return result;
    }

    //Here lies my attempt to request proper PUT or POST method and do a data validation. Forever in my memories...

//    @RequestMapping(value="/games/0", headers="Content-Type=application/json", method = RequestMethod.PUT)
//    public void addGame(@ModelAttribute("game") Game game, BindingResult result, ModelMap model) {
//        System.out.println(model);
//        System.out.println(game);
//        GameValidator gameValidator = new GameValidator();
//        gameValidator.validate(game, result);
//
//        if(result.hasErrors()) {
//            System.out.println(result);
//        } else {
//            repository.save(game);
//        }
//    }

    private Collection<Game> sortBy(String sort, String order) {
        Collection<Game> result;

        switch (sort) {
            case "Name":
                if (order.equals("Asc")) {
                    result = repository.orderByNameAsc().stream()
                            .collect(Collectors.toList());
                } else {
                    result = repository.orderByNameDesc().stream()
                            .collect(Collectors.toList());
                }
                break;
            case "Platform":
                if (order.equals("Asc")) {
                    result = repository.orderByPlatformAsc().stream()
                            .collect(Collectors.toList());
                } else {
                    result = repository.orderByPlatformDesc().stream()
                            .collect(Collectors.toList());
                }
                break;
            case "Rating":
                if (order.equals("Asc")) {
                    result = repository.orderByRatingAsc().stream()
                            .collect(Collectors.toList());
                } else {
                    result = repository.orderByRatingDesc().stream()
                            .collect(Collectors.toList());
                }
                break;
            default:
                result = repository.findAll().stream()
                        .collect(Collectors.toList());
                System.out.println("You chose wrong sorting!");
                break;
        }
        return result;
    }

    private Collection<Game> filter(String filterParams) {

        Collection<Game> filtered, result;

        String delims = "[,]";
        String[] tokens = filterParams.split(delims);
        int[] params = new int[3];

        //only three first parameters are important
        for(int i = 0; i < 3; i++) {
            params[i] = Integer.parseInt(tokens[i]);
        }

        //minimal rating
        if(params[1] < 0) {
            params[1] = 0;
        } else if (params[1] > 5) {
            params[1] = 5;
        }

        //maximal rating
        if(params[2] < 0) {
            params[2] = 0;
        } else if (params[2] > 5) {
            params[2] = 5;
        }

        //passing min and max value
        result = repository.filterRating(params[1], params[2]);


        //check id
        if(params[0] == 0) {
            filtered = repository.findAll().stream()
                    .collect(Collectors.toList());
        } else {
            filtered = repository.filterPlatform(params[0]);
        }
        result = intersection(result, filtered);
        return result;

    }

    private Collection<Game> intersection(Collection<Game> list1, Collection<Game> list2) {
        Collection<Game> result;
        result = list1.stream().filter(list2::contains).collect(Collectors.toList());

        return result;
    }
}
