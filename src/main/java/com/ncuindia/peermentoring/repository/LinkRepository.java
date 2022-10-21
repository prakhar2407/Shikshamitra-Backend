package com.ncuindia.peermentoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncuindia.peermentoring.model.Link;


// Spring Data JPA internally provides @Repository Annotation so we don't need to 
// add @Repository to LinkRepository Interface

// By Default Spring Data JPA made jpa repository methods transactional so we not need to
// add @Transactional annotation in service class
public interface LinkRepository extends JpaRepository<Link, Long>{
	
}
