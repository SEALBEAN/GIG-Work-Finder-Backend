package com.seal.api.gwf.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CommentContent")
public class CommentContentEntity {

    @Id
    @Column(name = "ContentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contentID;

    @Column(name = "CommentID")
    private int commentID;

    @Column(name = "Content", columnDefinition = "ntext")
    private String content;
}
