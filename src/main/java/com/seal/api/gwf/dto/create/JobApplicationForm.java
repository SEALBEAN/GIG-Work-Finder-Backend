package com.seal.api.gwf.dto.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobApplicationForm {
    private int accountID;
    private String other;
    private Time startTime;
    private Time endTime;
    private int available;
}
