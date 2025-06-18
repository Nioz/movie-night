/**
 * Comment class representing comments with properties of id, comment's author and comment's content, as well as
 * date & time posted, and the movie it was posted to
 */

package com.movie.app.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String author;
    private String content;

    private LocalDateTime postedAt;

    @ManyToOne //Many comments to one movie
    @JoinColumn(name ="movie_id")

    private Movie movie;

    //Getters
    //START
        public Long getId() {
            return id;
        }

        public String getAuthor() {
            return author;
        }

        public String getContent() {
            return content;
        }

        public LocalDateTime getPostedAt () {
            return postedAt;
        }

        public Movie getMovie() {
            return movie;
        }
    //END

    //Setters
    //START
        public void setId(Long id) {
            this.id = id;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setPostedAt(LocalDateTime postedAt) {
            this.postedAt = postedAt;
        }

        public void setMovie(Movie movie) {
            this.movie = movie;
        }
    //END

    //Checks if time isn't already set then auto sets it to current time
    @PrePersist
    public void onPrePersist() {
        if (this.postedAt == null) {
            this.postedAt = LocalDateTime.now();
        }
    }
}
