package com.aspectworks.active24.rest;

import com.aspectworks.active24.api.rest.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(UserVO userVO) {
        this.userRepository.save(userVO);
    }

    @Override
    public List<UserVO> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public void delete(String username) {
        Optional<UserVO> result = this.userRepository.findByUsername(username);
        result.ifPresent(this.userRepository::delete);
    }
}
