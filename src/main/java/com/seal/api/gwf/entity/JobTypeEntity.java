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
@Table(name = "JobType")
public class JobTypeEntity {
    @Id
    @Column(name = "TypeID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeID;

    @Column(name = "Name", columnDefinition = "ntext")
    private String name;

    @Column(name = "Status")
    private int status;

    @Column(name = "Quantity")
    private int quantity;
}
