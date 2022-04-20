package com.example.demo.netflix;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Netflix")
public class Netflix {
	
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String movieName;
	private String genre;
	private LocalDate releaseDate;
	private Integer rating;
	private String creator;
	
	public Netflix(Long id, String movieName, String genre, LocalDate releaseDate, Integer rating, String creator) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.rating = rating;
		this.creator = creator;
	}
		
	public Netflix() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "Netflix [id=" + id + ", movieName=" + movieName + ", genre=" + genre + ", releaseDate=" + releaseDate
				+ ", rating=" + rating + ", creator=" + creator + "]";
	}
	
	
	

}
