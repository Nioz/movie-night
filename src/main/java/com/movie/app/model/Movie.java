/*****
 * Movie class representing movies with their properties: id, title, description, release date, and associated comments
 */
package com.movie.app.model;

import jakarta.persistence.*;
import java.util.List;
import java.time.LocalDate;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private LocalDate releaseDate;

    //One movie to many comments
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Comment> comments;

    //Getters
    //START
        public Long getId(){
            return id;
        }

        public String getTitle(){
            return title;
        }

        public String getDescription(){
            return description;
        }

        public LocalDate getReleaseDate(){
            return releaseDate;
        }

        public List<Comment> getComments(){
            return comments;
        }
    //END

    //Setters
    //START
        public void setId(Long id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setReleaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
        }

        public void setComments (List<Comment> comments) {
            this.comments = comments;
        }

}
