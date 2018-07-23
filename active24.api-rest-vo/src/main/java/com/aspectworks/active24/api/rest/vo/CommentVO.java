package com.aspectworks.active24.api.rest.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class CommentVO {

    @Id
    @GeneratedValue
    private Integer Id;

    @JsonIgnore
    @ManyToOne
    private UserVO user;

    @JsonIgnore
    @ManyToOne
    private TopicVO topic;

    private String content;
    private Date created = new Date();
}
