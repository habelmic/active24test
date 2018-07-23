package com.aspectworks.active24.api.rest.vo;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class TopicVO {

    @Id
    @GeneratedValue
    private Integer Id;

    @OneToOne
    private UserVO user;

    @OneToMany(mappedBy = "topic")
    private List<CommentVO> comments = new ArrayList<>();

    private String title;
    private String content;
    private Date created = new Date();
}
