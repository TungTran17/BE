package com.testproject.swp.repository;

import com.testproject.swp.entity.MyService;
import com.testproject.swp.entity.MyServiceCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface MyServiceCategoryRepository extends JpaRepository<MyServiceCategory, Integer> {


}
