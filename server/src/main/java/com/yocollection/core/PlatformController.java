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
public class PlatformController {
    private PlatformRepository repository;

    public PlatformController(PlatformRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/platforms")
    public Collection<Platform> platforms() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/platforms/search/{name}")
    public Collection<Platform> platforms(@PathVariable String name) {
        return repository.findByPlatformName(name).stream()
                .collect(Collectors.toList());
    }
}
