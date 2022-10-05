package com.seal.api.gwf.entity;


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
@Table(name = "Degree")
public class DegreeEntity {

    @Id
    @Column(name = "DegreeID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int degreeID;

    @Column(name = "DegreeName", columnDefinition = "ntext")
    private String degreeName;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "DegreeID")
//    private

}
