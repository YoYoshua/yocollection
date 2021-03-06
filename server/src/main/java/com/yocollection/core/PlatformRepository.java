package com.yocollection.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface PlatformRepository extends JpaRepository<Platform, Long> {

    Collection<Platform> findByPlatformName(String name);
}
