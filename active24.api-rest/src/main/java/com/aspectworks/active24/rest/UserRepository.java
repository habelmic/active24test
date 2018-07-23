package com.aspectworks.active24.rest;


import com.aspectworks.active24.api.rest.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserVO, Integer> {
    Optional<UserVO> findByUsername(String username);
}
