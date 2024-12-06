package com.saiDeveloper.Spring_Boot_Rest.repo;

import com.saiDeveloper.Spring_Boot_Rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
}
