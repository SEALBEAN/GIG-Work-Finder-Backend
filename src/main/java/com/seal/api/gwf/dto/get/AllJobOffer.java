package com.seal.api.gwf.dto.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllJobOffer {
    private int OfferID;

    private int AccountID;

    private Integer TypeID;

    private Integer LocationID;

    private Integer DegreeID;

    private int NumOfRecruit;

    private Date offerEndTime;

    private int status;

    private Integer salary;

    private Integer age;

    private Integer visual;

    private String jobDescription;

    private String other;

    private Time startTime;

    private Time endTime;

    private String address;

    private Integer businessID;

    private int state;

    private int applicationID;

    private int mapID;
}
