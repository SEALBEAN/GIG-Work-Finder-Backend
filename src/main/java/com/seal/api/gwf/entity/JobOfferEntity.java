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
@Table(name = "JobOffer")
public class JobOfferEntity {
    @Id
    @Column(name = "OfferID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int offerID;

    @Column(name = "AccountID", nullable = false)
    private int accountID;

    @Column(name = "TypeID", nullable = false)
    private int typeID;

    @Column(name = "LocationID", nullable = false)
    private int locationID;

    @Column(name = "DegreeID")
    private Integer degreeID;

    @Column(name = "BusinessID")
    private Integer businessID;

    @Column(name = "NumOfRecruit", nullable = false)
    private int numOfRecruit;

    @Column(name = "OfferEndTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date offerEndTime;

    @Column(name = "CreatedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "Status", nullable = false)
    private int status;

    @Column(name = "Salary")
    private Integer salary;

    @Column(name = "Age")
    private Integer age;

    @Column(name = "Visual")
    private Integer visual;

    @Column(name = "JobDescription", columnDefinition = "ntext")
    private String jobDescription;

    @Column(name = "Other", columnDefinition = "ntext")
    private String other;

    @Column(name = "StartTime")
    @Temporal(TemporalType.TIME)
    private Date startTime;

    @Column(name = "EndTime")
    @Temporal(TemporalType.TIME)
    private Date endTime;

    @Column(name = "Address", columnDefinition = "ntext")
    private String address;

    @Column(name = "PopularScore")
    private Float popularScore;
}
