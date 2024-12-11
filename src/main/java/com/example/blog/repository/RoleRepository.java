package com.example.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.blog.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{
    Role findByName(String name);
}
