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
@Table(name = "Recruiter")
public class RecruiterEntity {

    @Id
    @Column(name = "AccountID")
    private int accountID;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Email")
    private String email;

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
