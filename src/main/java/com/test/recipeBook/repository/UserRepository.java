package com.test.recipeBook.repository;

import com.test.recipeBook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "select * from users u where u.login = :login",
            nativeQuery = true)
    Optional<User> getByLogin(@Param("login") String login);
}
