package com.testproject.swp.repository;

import com.testproject.swp.entity.MyService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface MyServiceRepository extends JpaRepository<MyService, Integer> {

    Page<MyService> findAll(Pageable pageable);

    MyService save(MyService myService);

    void deleteById(int id);

    @Query("SELECT m FROM MyService m WHERE (:status = -1 OR m.myServiceStatus.servicestatus = :status)")
    Page<MyService> findAllByStatus(int status, Pageable pageable);

    @Query("SELECT m FROM MyService m WHERE (:status = -1 OR m.myServiceStatus.servicestatus = :status) " +
            "AND (:title IS NULL OR :title = 'none' OR LOWER(m.title) LIKE LOWER(:title) || '%')" +
            "AND (:bi IS NULL OR :bi = 'none' OR LOWER(m.bi) LIKE LOWER(:bi) || '%')" +
            "AND (:category = -1 OR m.categoryid = :category)")
    Page<MyService> findAllByStatusAndTitle(int status, String title, String bi, int category, Pageable pageable);

    @Query("SELECT m FROM MyService m  WHERE (:category = -1 OR m.categoryid =:category) AND m.myServiceStatus.servicestatus =0")
    List<MyService> findAllByCategory(int category);

    @Query("SELECT m FROM MyService m WHERE m.id =:id")
    MyService findById(int id);

    List<MyService> findByTitleContainingIgnoreCase(String title);

    List<MyService> findByBiContainingIgnoreCase(String bi);

    List<MyService> findByMyServiceStatus_Servicestatus(int status);

    List<MyService> findAllByOrderByTitleAsc();

    List<MyService> findAllByOrderByTitleDesc();

    List<MyService> findAllByOrderByPriceAsc();

    List<MyService> findAllByOrderByPriceDesc();

    List<MyService> findAllByOrderByMyServiceStatus_ServicestatusAsc();

    List<MyService> findAllByOrderByMyServiceStatus_ServicestatusDesc();

    List<MyService> findAllByOrderByServiceCategory_CategorynameAsc();

    List<MyService> findAllByOrderByServiceCategory_CategorynameDesc();

}
