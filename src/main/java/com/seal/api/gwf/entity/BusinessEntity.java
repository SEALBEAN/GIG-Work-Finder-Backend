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
@Table(name = "Business")
public class BusinessEntity {
    @Id
    @Column(name = "BusinessID")
    private int businessID;

    @Column(name = "LocationID")
    private int locationID;

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
