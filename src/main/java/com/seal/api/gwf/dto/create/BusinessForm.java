package com.seal.api.gwf.dto.create;

import com.seal.api.gwf.entity.LocationEntity;

import javax.persistence.Column;

public class BusinessForm {
    private Integer location;

    private Integer accountID;

    private String address;

    private String businessName;

    private String businessLogo;

    private String description;

    private String benefit;
}
