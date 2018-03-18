package com.yocollection.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(value = "select * from Game where Rating >= :#{#min} and Rating <= :#{#max}", nativeQuery = true)
    Collection<Game> filterRating(@Param("min") int min, @Param("max") int max);

    @Query(value = "select g.* from Game g, Platform p where p.id = :#{#id} and g.PLATFORM = p.PLATFORM_NAME", nativeQuery = true)
    Collection<Game> filterPlatform(@Param("id")int id);
}
