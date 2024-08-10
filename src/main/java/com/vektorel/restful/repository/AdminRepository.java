package com.vektorel.restful.repository;

import com.vektorel.restful.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

    Optional<Admin> findOptionalByEmail(String email);

    List<Admin> findByName(String name);


    List<Admin> findBySurname(String surname);

    boolean existsById(Long id);

}
