package com.yocollection.core;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

    @Bean
    ApplicationRunner init(GameRepository repository) {
	    return args -> {
	        Stream.of("Super Mario Oddysey", "The Legend of Zelda: Breath of the Wild").forEach(name -> {
	            Game game = new Game();
	            game.setName(name);
	            repository.save(game);
            });
	        repository.findAll().forEach(System.out::println);
        };
    }
}
