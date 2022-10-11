package com.seal.api.gwf.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentID;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OfferID")
    private JobOfferEntity jobOffer;

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
