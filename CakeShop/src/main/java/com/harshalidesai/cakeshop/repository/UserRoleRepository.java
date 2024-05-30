package com.harshalidesai.cakeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harshalidesai.cakeshop.entity.User;

@Repository
public interface UserRoleRepository extends JpaRepository<User, Integer> {
}
