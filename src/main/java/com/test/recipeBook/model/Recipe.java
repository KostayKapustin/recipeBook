package com.test.recipeBook.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@Table(name = "recipe")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "recipe_name", nullable = false)
    String name;

    @Column(name = "imagePath")
    String imagePath;

    @Column(name = "recipe_description",length = 150)
    String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_recipe_id")
    List<Tag> tags;

    @Column(name = "cookingTime")
    Integer cookingTime;

    @Column(name = "portionsDish")
    Integer portionsDish;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_recipe_id")
    List<Ingredient> ingredients;

    @ManyToMany(fetch = FetchType.LAZY)
    List<User> favorites;

    @ManyToMany(fetch = FetchType.LAZY)
    List<User> likes;

    @ElementCollection
    @CollectionTable(name="recipe_descriptionStep", joinColumns = @JoinColumn(name = "descriptionStep_recipe_id"))
    List<String> descriptionStep;
}
