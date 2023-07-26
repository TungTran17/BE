package com.testproject.swp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.testproject.swp.entity.User;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
        
        public Optional<User> findByEmail(String email);

        public Optional<User> findOneByEmailAndPassword(String email, String password);

        public User findByName(String name);

        @Query("SELECT DISTINCT  u FROM User u " +
                        "JOIN u.roles r " +
                        "WHERE   (:idRole = -1 OR r.roleID = :idRole)")
        public List<User> findByRole(int idRole);

        @Query("SELECT DISTINCT  u FROM User u " +
                        "JOIN u.roles r " +
                        "WHERE (:status = -1 OR u.status = :status) " +
                        "AND (:email IS NULL OR :email = 'none' OR LOWER(u.email) LIKE LOWER(:email) || '%') " +
                        "AND (:idRole = -1 OR r.roleID = :idRole)")
        Page<User> getListUsersPage(String email, int idRole, int status, Pageable pageable);

        @Query("SELECT  count( DISTINCT u) FROM User u " +
                        "JOIN u.roles r " +
                        "WHERE (:status = -1 OR u.status = :status) " +
                        "AND (:email IS NULL OR :email = 'none' OR LOWER(u.email) LIKE LOWER(:email) || '%') " +
                        "AND (:idRole = -1 OR r.roleID = :idRole)")
        int countListUsersPage(String email, int idRole, int status);

}
