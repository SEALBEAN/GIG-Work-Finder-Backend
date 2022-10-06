package com.seal.api.gwf.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "Location")
//@JsonIgnoreProperties({"businessEntityList"})
public class LocationEntity {
    @Id
    @Column(name = "LocationID")
    private int locationID;

    @Column(name = "Province")
    private String province;

    @Column(name = "City")
    private String city;

    @JsonManagedReference
    @OneToMany(mappedBy = "location",fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = BusinessEntity.class)
    private Set<BusinessEntity> businessEntityList = new HashSet<>();
}
