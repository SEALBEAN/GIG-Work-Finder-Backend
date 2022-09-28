package com.example.testbe.Entity;

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
@Table(name = "Location")
public class LocationEntity {

    @Id
    @Column(name = "LocationID")
    private int id;

    @Column(name = "Province")
    private String province;

    @Column(name = "City")
    private String city;
}
