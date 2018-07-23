package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.CommentVO;
import com.aspectworks.active24.api.rest.vo.TopicVO;
import com.aspectworks.active24.api.rest.vo.UserVO;
import com.aspectworks.active24.rest.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createTopic(@RequestBody TopicVO topic) {
        this.topicService.add(topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteTopic(@PathVariable("id") Integer id) {
        this.topicService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"search"})
    public List<TopicVO> findTopics(
            @RequestParam(value = "search") String search) {
        return this.topicService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"search", "sort"})
    public List<TopicVO> findTopicsSortedBy(
            @RequestParam(value = "search") String search,
            @RequestParam(value = "sort") String sort) {
        return this.topicService.find(search, sort);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"search", "sort", "order"})
    public List<TopicVO> findTopicsSortedByInOrder(
            @RequestParam(value = "search") String search,
            @RequestParam(value = "sort") String sort,
            @RequestParam(value = "order") String order) {
        return this.topicService.find(search, sort, order);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/comments")
    public void addComment(@PathVariable("id") Integer id, @RequestBody CommentVO comment) {
        this.topicService.addComment(id, comment);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/comments")
    public List<CommentVO> getAllComments(@PathVariable("id") Integer id) {
        return this.topicService.getComments(id);
    }
}
