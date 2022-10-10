package com.seal.api.gwf.dto;


import javax.persistence.*;
import java.util.Date;

public class Applicant {
    private int accountID;

    private Location location;

    private Degree degree;

    private String firstName;

    private String lastName;

    private String phone;

    private Date dob;

    private String gender;

    private String email;

    private String address;

    private int totalOfReviews;

    private Float averageStars;

    private int verify;

    private String description;
}
