package com.test.recipeBook.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "user_name", nullable = false)
    String name;

    @Column(name = "login", nullable = false, unique = true)
    String login;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "user_description")
    String description;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn
    List<Recipe> myRecipes = new ArrayList<>();

    public User(Long id, String name, String login, String password, String description, List<Recipe> myRecipes) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.description = description;
        this.myRecipes = myRecipes;
    }

    public User() {

    }
}
