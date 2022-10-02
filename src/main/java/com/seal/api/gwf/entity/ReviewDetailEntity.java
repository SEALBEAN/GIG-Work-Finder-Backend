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
@Table(name = "ReviewDetail")
public class ReviewDetailEntity {

    @Id
    @Column(name = "ReviewID")
    private int reviewID;

    @Column(name = "AccountID")
    private int accountID;

    @Column(name = "Stars")
    private int stars;

    @Column(name = "CreatedTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;

    @Column(name = "UpdatedTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;

    @Column(name = "Status")
    private int status;

    @Column(name = "CreatedByID")
    private int createdByID;
}
