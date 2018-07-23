package com.aspectworks.active24.rest;

import com.aspectworks.active24.api.rest.vo.CommentVO;
import com.aspectworks.active24.api.rest.vo.TopicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {


    private final TopicRepository topicRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository, CommentRepository commentRepository) {
        this.topicRepository = topicRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public int add(TopicVO topic) {
        return this.topicRepository.save(topic).getId();
    }

    @Override
    public int addComment(Integer id, CommentVO comment) {
        Optional<TopicVO> result = this.topicRepository.findById(id);
        if (result.isPresent()) {
            TopicVO topic = result.get();
            topic.getComments().add(comment);
            this.commentRepository.save(comment);
            return this.topicRepository.save(topic).getId();
        }
        return 0;
    }

    @Override
    public void delete(Integer Id) {
        this.topicRepository.deleteById(Id);

    }

    @Override
    public List<CommentVO> getComments(Integer id) {
        Optional<TopicVO> result = this.topicRepository.findById(id);
        if (result.isPresent()) {
            return result.get().getComments();
        }
        else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<TopicVO> find(String search) {
        Sort sort = new Sort(Sort.Direction.ASC, "created");
        System.out.println("time to cry");
        return this.topicRepository.findByContentContaining(search, sort);
    }

    @Override
    public List<TopicVO> find(String search, String sortBy) {
        Sort sort = new Sort(Sort.Direction.ASC, sortBy);
        return this.topicRepository.findByContentContaining(search, sort);
    }

    @Override
    public List<TopicVO> find(String search, String sortBy, String order) {
        Sort sort = new Sort(Sort.Direction.ASC, sortBy);
        if (order.equalsIgnoreCase("desc")) {
            sort = sort.descending();
        }
        return this.topicRepository.findByContentContaining(search, sort);
    }

    @Override
    public List<TopicVO> findAll() {
        return this.topicRepository.findAll();
    }
}
