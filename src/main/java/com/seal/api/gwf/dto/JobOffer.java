package com.seal.api.gwf.dto;

import com.seal.api.gwf.entity.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobOffer {

    private int offerID;

    private RecruiterEntity recruiter;

    private JobTypeEntity jobType;

    private Location location;

    private DegreeEntity degree;

    private BusinessEntity business;

    private int numOfRecruit;

    private Date offerEndTime;

    private Date createdDate;

    private int status;

    private Integer salary;

    private Integer age;

    private Integer visual;

    private String jobDescription;

    private String other;

    private Date startTime;

    private Date endTime;

    private String address;

    private Float popularScore;

    private Set<CommentEntity> commentEntities = new HashSet<>();
}
