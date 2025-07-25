package com.code.auth_service.auth.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.auth_service.auth.entity.UserVO;

public interface AuthRepository extends JpaRepository<UserVO, String> {

    Boolean existsByEmail(String email);


    Optional<UserVO> findByUsername(String username);

    Optional<UserVO> findByEmail(String email);


}
