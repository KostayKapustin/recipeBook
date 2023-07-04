package com.test.recipeBook.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "ingredient")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "ingredient_name", nullable = false)
    @Size(max = 50)
    String name;

    @Column(name = "ingredient_description")
    @Size(max = 150)
    String description;
}
