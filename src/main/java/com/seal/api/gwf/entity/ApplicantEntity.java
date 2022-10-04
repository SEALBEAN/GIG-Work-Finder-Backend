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
@Table(name = "Applicant")
public class ApplicantEntity {
    @Id
    @Column(name = "AccountID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountID;

    @Column(name = "LocationID")
    private Integer locationID;

    @Column(name = "DegreeID")
    private Integer degreeID;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Email")
    private String email;

    @Column(name = "Address", columnDefinition = "ntext")
    private String address;

    @Column(name = "TotalOfReviews")
    private int totalOfReviews;

    @Column(name = "AverageStars")
    private Float averageStars;

    @Column(name = "Verify")
    private int verify;

    @Column(name = "Status")
    private int status;

    @Column(name = "Description", columnDefinition = "ntext")
    private String description;
}
