package com.aspectworks.active24.rest;

import com.aspectworks.active24.api.rest.vo.CommentVO;
import com.aspectworks.active24.api.rest.vo.TopicVO;

import java.util.List;

public interface TopicService {

    int add(TopicVO topic);
    int addComment(Integer id, CommentVO comment);
    void delete(Integer id);
    List<CommentVO> getComments(Integer id);
    List<TopicVO> find(String search);
    List<TopicVO> find(String search, String sortBy);
    List<TopicVO> find(String search, String sortBy, String order);
    List<TopicVO> findAll();
}
