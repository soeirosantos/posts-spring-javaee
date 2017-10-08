package br.com.soeirosantos.posts.services;

import br.com.soeirosantos.posts.domain.entities.Post;
import java.util.List;
import java.util.Optional;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Named
@Singleton
public class PostService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Post> findAll() {
        return entityManager.createNamedQuery(Post.FIND_ALL, Post.class).getResultList();
    }

    public Optional<Post> findOne(Long id) {
        Post Post = entityManager.find(Post.class, id);
        return Optional.ofNullable(Post);
    }

    @Transactional
    public Post save(Post post) {
        if (post.isNew()) {
            entityManager.persist(post);
        } else {
            post = entityManager.merge(post);
        }
        return post;
    }

    @Transactional
    public void delete(Long id) {
        Optional<Post> post = findOne(id);
        if (post.isPresent()) {
            entityManager.remove(post.get());
        }
    }

}
