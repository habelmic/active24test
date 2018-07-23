package com.aspectworks.active24.rest;

import com.aspectworks.active24.api.rest.vo.CommentVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentVO, Integer> {
}
