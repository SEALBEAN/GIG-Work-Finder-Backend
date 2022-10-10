package com.seal.api.gwf.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.seal.api.gwf.dto.ReviewDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ReviewDetail")
public class ReviewDetailEntity {

    @Id
    @Column(name = "ReviewID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ApplicantEntity.class)
    @JoinColumn(name = "CreatedByID", referencedColumnName = "AccountID")
    private ApplicantEntity createdBy;

    @JsonManagedReference
    @OneToMany(mappedBy = "reviewID",fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = ReviewContentEntity.class)
    private Set<ReviewContentEntity> reviewContentEntities = new HashSet<>();
}
