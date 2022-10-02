package com.seal.api.gwf.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ReviewContent")
public class ReviewContentEntity {

    @Id
    @Column(name = "ContentID")
    private int contentID;

    @Column(name = "ReviewID")
    private int reviewID;

    @Column(name = "Content", columnDefinition = "ntext")
    private String content;
}
