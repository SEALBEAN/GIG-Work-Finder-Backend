package com.seal.api.gwf.dto;

import com.seal.api.gwf.entity.JobOfferEntity;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
@Component
public class JobOfferDTO {

    private int offerID;

    private int accountID;

    private int typeID;

    private int locationID;

    private Integer degreeID;

    private Integer businessID;

    private String typeName;

    private int numOfRecruit;

    private Date offerEndTime;

    private Integer salary;

    private Integer age;

    private Integer visual;

    private String jobDescription;

    private String other;

    private Date startTime;

    private Date endTime;

    private String address;

    private Float popularScore;


}
