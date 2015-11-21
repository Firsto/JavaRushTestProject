package ru.firsto.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by razor on 21.11.15.
 */

@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {
    User findByName(String name);
}
