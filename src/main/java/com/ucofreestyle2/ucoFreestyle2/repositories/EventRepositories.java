package com.ucofreestyle2.ucoFreestyle2.repositories;


import com.ucofreestyle2.ucoFreestyle2.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EventRepositories extends JpaRepository<Event, Long> {

}
