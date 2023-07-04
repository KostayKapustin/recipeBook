package com.test.recipeBook.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "tag")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "tag_name", nullable = false)
    @Size(max = 100)
    String name;

    @Column(name = "tag_description")
    @Size(max = 150)
    String description;
}
