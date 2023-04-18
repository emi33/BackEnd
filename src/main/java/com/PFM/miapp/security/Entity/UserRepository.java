package com.PFM.miapp.security.Entity;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    //crear metodo, hallar user por nombreusuario
    Optional<User> findByEmail(String email);
    public boolean existsByEmail(String email);
}
