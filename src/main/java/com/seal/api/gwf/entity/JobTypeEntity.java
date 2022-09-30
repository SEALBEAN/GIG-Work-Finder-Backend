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
@Table(name = "JobType")
public class JobTypeEntity {
    @Id
    @Column(name = "TypeID")
    private int typeID;

    @Column(name = "Name", columnDefinition = "ntext")
    private String name;

    @Column(name = "Status")
    private int status;

    @Column(name = "Quantity")
    private int quantity;
}
