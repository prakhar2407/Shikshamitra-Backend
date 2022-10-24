package com.ncuindia.peermentoring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncuindia.peermentoring.model.UserTable;

@Repository
public interface UserTableRepository extends JpaRepository<UserTable, String> {
    Optional<UserTable> findByEmailId(String emailId);

    Boolean existsByEmailId(String email);
}
