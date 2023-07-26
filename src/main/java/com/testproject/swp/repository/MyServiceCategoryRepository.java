package com.testproject.swp.repository;

import com.testproject.swp.entity.MyServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface MyServiceCategoryRepository extends JpaRepository<MyServiceCategory, Integer> {


}
