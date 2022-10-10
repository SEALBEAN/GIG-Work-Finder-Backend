package com.seal.api.gwf.dto;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ReviewDetail {
    private int reviewID;

    private int accountID;

    private int stars;

    private Date createdTime;

    private Date updatedTime;

    private int status;

    private Applicant createdBy;

    private Set<ReviewContent> reviewContents = new HashSet<>();
}
