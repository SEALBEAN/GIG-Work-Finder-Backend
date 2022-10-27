package com.seal.api.gwf.dto.create;

import com.seal.api.gwf.dto.Degree;
import com.seal.api.gwf.dto.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantForm {
    private int accountID;

    private Integer locationID;

    private Integer degreeID;

    private String firstName;

    private String lastName;

    private String phone;

    private String dob;

    private String gender;

    private String address;

    private String description;

    private int available;
}
