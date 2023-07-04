package com.test.recipeBook.repository;

import com.test.recipeBook.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query(value = "select id from tag t where t.tag_name = :tagName",
            nativeQuery = true)
    Long getTagByName(@Param("tagName") String tagName);

    @Query(value = "select recipe_id from recipe_tags rt where rt.tags_id = :id",
            nativeQuery = true)
    List<Long> getRecipeIdByTagId(@Param("id")Long id);
}
