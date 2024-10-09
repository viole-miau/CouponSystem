package com.nya.mitzi.customer;

import com.nya.mitzi.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    boolean existsByEmail(String email);

    @Query("select case when count(c)>0 then true else false end from Customer c " +
            "where c.email = :email and c.password = :password")
    boolean existsByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    boolean existsByFirstName(String firstName);

    //Customer findByEmail(String email);

    //Customer findByFirstName(String firstName);

    Optional<Customer> findByFirstName(String name);
    Optional<Customer> findByEmail(String email);
}
