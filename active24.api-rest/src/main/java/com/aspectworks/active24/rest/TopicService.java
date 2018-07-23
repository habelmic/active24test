package com.aspectworks.active24.rest;

import com.aspectworks.active24.api.rest.vo.CommentVO;
import com.aspectworks.active24.api.rest.vo.TopicVO;

import java.util.List;

public interface TopicService {

    public void add(TopicVO topic);
    public void addComment(Integer id, CommentVO comment);
    public void delete(Integer id);
    public List<CommentVO> getComments(Integer id);
    public List<TopicVO> find(String search);
    public List<TopicVO> find(String search, String sortBy);
    public List<TopicVO> find(String search, String sortBy, String order);
}
