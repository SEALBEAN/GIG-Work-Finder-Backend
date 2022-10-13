package com.seal.api.gwf.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "JobOffer")
public class JobOfferEntity {
    @Id
    @Column(name = "OfferID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int offerID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AccountID")
    private RecruiterEntity recruiter;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TypeID")
    private JobTypeEntity jobType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LocationID")
    private LocationEntity location;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DegreeID")
    private DegreeEntity degree;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BusinessID")
    private BusinessEntity business;

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
    private Time startTime;

    @Column(name = "EndTime")
    private Time endTime;

    @Column(name = "Address", columnDefinition = "ntext")
    private String address;

    @Column(name = "PopularScore")
    private Float popularScore;

    @JsonManagedReference
    @OneToMany(mappedBy = "jobOffer",fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = CommentEntity.class)
    private Set<CommentEntity> commentEntities = new HashSet<>();
}
