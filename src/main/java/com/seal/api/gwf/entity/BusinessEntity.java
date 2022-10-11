package com.seal.api.gwf.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Business")
public class BusinessEntity {
    @Id
    @Column(name = "BusinessID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int businessID;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LocationID")
    private LocationEntity location;

//    @Column(name = "LocationID")
//    private int locationID;

    @Column(name = "AccountID")
    private int accountID;

    @Column(name = "Address", columnDefinition = "ntext")
    private String address;

    @Column(name = "BusinessName", columnDefinition = "ntext")
    private String businessName;

    @Column(name = "BusinessLogo", columnDefinition = "ntext")
    private String businessLogo;

    @Column(name = "Description", columnDefinition = "ntext")
    private String description;

    @Column(name = "Benefit", columnDefinition = "ntext")
    private String benefit;


}
