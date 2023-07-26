package com.testproject.swp.repository;

import com.testproject.swp.entity.MyServiceImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface MyServiceImageRepository extends JpaRepository<MyServiceImage, Integer> {

    int deleteByServiceid(String serviceid);

    MyServiceImage save(MyServiceImage myService);
}
