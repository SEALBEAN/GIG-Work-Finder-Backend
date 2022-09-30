package com.seal.api.gwf.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Comment")
public class CommentEntity {

    @Id
    @Column(name = "CommentID")
    private int commentID;

    @Column(name = "OfferID")
    private int offerID;

    @Column(name = "CreatedByID")
    private int createdByID;

    @Column(name = "RepToID")
    private int repToID;

    @Column(name = "Status")
    private int Status;

    @Column(name = "UpdatedTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;

    @Column(name = "CreatedTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
}
