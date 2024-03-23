package com.ucofreestyle2.ucoFreestyle2.repositories;


import com.ucofreestyle2.ucoFreestyle2.models.Membrership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MembrershipRepository extends JpaRepository<Membrership, Long> {

}
