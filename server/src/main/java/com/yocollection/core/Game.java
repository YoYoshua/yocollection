package com.yocollection.core;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Game {
    @Id @GeneratedValue
    private Long id;
    private @NonNull String name;
    private String platform;
    private String producer;
    private int rating;
    private int relaseYear;

}
