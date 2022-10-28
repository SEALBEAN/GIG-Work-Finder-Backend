package com.seal.api.gwf.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "JobApplication")
public class JobApplicationEntity {

    @Id
    @Column(name = "ApplicationID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applicationID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AccountID")
    private ApplicantEntity accountID;

    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "Salary")
    private Integer salary;

    @Column(name = "Age")
    private int age;

    @Column(name = "Visual")
    private Integer visual;

    @Column(name = "Other")
    private String other;

    @Column(name = "StartTime")
    private Time startTime;

    @Column(name = "EndTime")
    private Time endTime;

    @Column(name = "Status")
    private int status;

    @Column(name = "Available")
    private int available;
}
