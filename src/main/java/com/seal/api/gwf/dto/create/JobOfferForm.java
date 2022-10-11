package com.seal.api.gwf.dto.create;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobOfferForm {
    private int jobType;

    private Integer location;

    private Integer degree;

    private Integer business;

    private int numOfRecruit;

    private String offerEndTime;

    private Integer salary;

    private Integer age;

    private String jobDescription;

    private String other;

    private String startTime;

    private String endTime;

    private String address;
}
