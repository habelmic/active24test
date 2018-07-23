package com.aspectworks.active24.rest;

import com.aspectworks.active24.api.rest.vo.UserVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public void add(UserVO user);
    public List<UserVO> findAll();
    public void delete(String username);

}
