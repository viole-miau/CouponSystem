package com.nya.mitzi.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Integer> {
    boolean existsByName(String name);

    boolean existsByEmail(String email);


    @Query("select case when count(c)>0 then true else false end from Company c " +
            "where c.email = :email and c.password = :password")
    boolean existsByEmailAndPassword(@Param("email") String email, @Param("password") String password);
    
    Optional<Company> findByEmail(String email);

    Optional<Company> findByName(String name);



    //@Query("SELECT c.id FROM Company c WHERE c.name = :name")
    //int findIdByName(Company company);

    //add query that works:
    /*@Query("SELECT c FROM Company c WHERE c.email = :email and c.password = :password")
    boolean ExistByEmailAndPassword(@Param("email") String email, @Param("password") String password);*/

  /*  @Modifying
    @Query("UPDATE Company c SET c.name = :name and c.email = :email and c.password = :password " +
            "WHERE c.id = :companyId")
    void updateNameAndEmailAndPassword(@Param("companyId") int companyId, @Param("name") String name,
                                       @Param("email") String email,@Param("password") String password);

    @Modifying
    @Query(value = "insert into Company (id,name,email,password) "
            + "VALUES(:id,:name,:email,:password)", nativeQuery = true)
    public void insertCompanyUsingQueryAnnotation(@Param("id") int id,
                                                  @Param("name") String name,
                                                  @Param("email") String email,
                                                  @Param("password") String password);*/


}
