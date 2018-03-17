package com.yocollection.core;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode @ToString
public class Platform {
    @Id @GeneratedValue
    private Long id;
    private String platformName;
    private String platformLogotypePath;

}
