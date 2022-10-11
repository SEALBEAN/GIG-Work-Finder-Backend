package com.seal.api.gwf.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.seal.api.gwf.dto.Recruiter;
import com.seal.api.gwf.dto.ReviewDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Recruiter")
public class RecruiterEntity {

    @Id
    @Column(name = "AccountID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @JsonManagedReference
    @OneToMany(mappedBy = "accountID",fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = ReviewDetailEntity.class)
    private Set<ReviewDetailEntity> reviewDetailEntities = new HashSet<>();

}
