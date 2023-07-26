package com.testproject.swp.repository;

import com.testproject.swp.entity.MyServiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;

@EnableJpaRepositories
@Repository
public interface MyServiceStatusRepository extends JpaRepository<MyServiceStatus, Integer> {

    int deleteByServiceid(int serviceid);

    public List<MyServiceStatus> findByServiceid(int serviceid);
}
