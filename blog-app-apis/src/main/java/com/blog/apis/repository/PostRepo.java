package com.blog.apis.repository;

import com.blog.apis.model.Category;
import com.blog.apis.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByCategory(Category category);
    @Query("select p from Post p where p.tittle like : key")
    List<Post> findByTittleContaining(@Param("key") String tittle);
}
