package com.seal.api.gwf.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Seen")
public class SeenEntity {

    @Id
    @Column(name = "SeenID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seenID;

    @Column(name = "LineID")
    private int lineID;

    @Column(name = "SeenTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date seenTime;

    @Column(name = "AccountID")
    private int accountID;
}
