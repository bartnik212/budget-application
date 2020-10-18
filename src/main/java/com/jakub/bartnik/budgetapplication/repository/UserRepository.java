package com.jakub.bartnik.budgetapplication.repository;

import com.jakub.bartnik.budgetapplication.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
