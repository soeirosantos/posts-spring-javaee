package br.com.soeirosantos.posts.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
    @NamedQuery(name = Post.FIND_ALL, query = "select p from Post p order by p.title")
})
public class Post {

    public static final String FIND_ALL = "Post.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    private LocalDateTime publishDate;

    private String author;

    @JsonIgnore
    public boolean isNew() {
        return id == null;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
