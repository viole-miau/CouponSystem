package com.nya.mitzi.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {
    boolean existsByName(String name);

    Optional<Category> findByName(String name);
    //Category findById(int id);


}
