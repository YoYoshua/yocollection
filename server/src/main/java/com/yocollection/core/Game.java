package com.yocollection.core;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Getter @Setter
@ToString @EqualsAndHashCode
public class Game {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "name")
    private @NonNull String name;

    private String platform;
    private String producer;

    @Min(0) @Max(5)
    private int rating;
    private int relaseYear;
    private String gameCoverPath;

    public Game() {

    }

    public Game(String name, String platform, String producer, @Min(0) @Max(5) int rating, int relaseYear, String gameCoverPath) {
        this.name = name;
        this.platform = platform;
        this.producer = producer;
        this.rating = rating;
        this.relaseYear = relaseYear;
        this.gameCoverPath = gameCoverPath;
    }
}
