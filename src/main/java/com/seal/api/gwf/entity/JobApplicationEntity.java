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
@Table(name = "JobApplication")
public class JobApplicationEntity {

    @Id
    @Column(name = "ApplicationID")
    private int applicationID;

    @Column(name = "AccountID")
    private int accountID;

    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "Salary")
    private int salary;

    @Column(name = "Age")
    private int age;

    @Column(name = "Visual")
    private int visual;

    @Column(name = "Other")
    private int other;

    @Column(name = "StartTime")
    @Temporal(TemporalType.TIME)
    private Date startTime;

    @Column(name = "EndTime")
    @Temporal(TemporalType.TIME)
    private Date endTime;

    @Column(name = "Status")
    private int status;

}
