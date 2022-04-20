package com.example.demo.netflix;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NetflixRepos extends JpaRepository<Netflix, Long> {
	
}
