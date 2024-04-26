package com.example.jpaintrodemocrudu.repo;

import com.example.jpaintrodemocrudu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    @Modifying
    @Transactional
    @Query(value = "update users set name = :newName where id = :id", nativeQuery = true)
    void updateUserInfoById(String newName, Integer id);

    List<User> findUserByUserName(String name);
}
