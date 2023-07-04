package com.test.recipeBook.repository;

import com.test.recipeBook.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query(value = "select * from recipe r where r.recip_name = :name",
            nativeQuery = true)
    Optional<Recipe> getRecipeByName(@Param("name")String name);
}
