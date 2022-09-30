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
@Table(name = "Degree")
public class DegreeEntity {

    @Id
    @Column(name = "DegreeID")
    private int degreeID;

    @Column(name = "DegreeName", columnDefinition = "ntext")
    private String degreeName;

}
