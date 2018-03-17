package com.yocollection.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;


@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface GameRepository extends JpaRepository<Game, Long> {

    Collection<Game> findByName(String name);

    @Query(value = "select * from Game order by Name asc", nativeQuery = true)
    Collection<Game> orderByNameAsc();

    @Query(value = "select * from Game order by Name desc", nativeQuery = true)
    Collection<Game> orderByNameDesc();

    @Query(value = "select * from Game order by Platform asc", nativeQuery = true)
    Collection<Game> orderByPlatformAsc();

    @Query(value = "select * from Game order by Platform desc ", nativeQuery = true)
    Collection<Game> orderByPlatformDesc();

    @Query(value = "select * from Game order by Rating asc", nativeQuery = true)
    Collection<Game> orderByRatingAsc();

    @Query(value = "select * from Game order by Rating desc", nativeQuery = true)
    Collection<Game> orderByRatingDesc();
}
