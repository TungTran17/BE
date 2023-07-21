package com.testproject.swp.repository;

import com.testproject.swp.entity.Category;
import com.testproject.swp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
