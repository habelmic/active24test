package com.aspectworks.active24.api.rest.vo;

import lombok.Data;

import javax.persistence.*;
import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class UserVO {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String firstName;
    private String surname;

    @OneToOne
    private TopicVO topic;

    @OneToMany(mappedBy = "user")
    private List<CommentVO> comments = new ArrayList<>();


}
