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
@Table(name = "JobMapping")
public class JobMappingEntity {
    @Id
    @Column(name = "MapID")
    private int mapID;

    @Column(name = "OfferID")
    private int offerID;

    @Column(name = "ApplicationID")
    private int applicationID;

    @Column(name = "AccountID")
    private int accountID;

    @Column(name = "State")
    private int state;
}
