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

    private String jobName;

    private String buName;

    private String buLogo;

    private String buAddress;

    private String JOAddress;

    private Integer BusinessID;

    private int state;

    private int applicationID;

    private int mapID;
}
