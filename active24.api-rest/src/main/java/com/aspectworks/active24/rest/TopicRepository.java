package com.aspectworks.active24.rest;

import com.aspectworks.active24.api.rest.vo.TopicVO;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<TopicVO, Integer> {
    public List<TopicVO> findByContentContaining(String text, Sort sort);
}
