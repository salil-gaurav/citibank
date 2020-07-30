package com.citi.bank.repository;

import com.citi.bank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("Select ob from com.citi.bank.entity.User ob where ob.key = ?1")
    User findByKey(String key);
}
