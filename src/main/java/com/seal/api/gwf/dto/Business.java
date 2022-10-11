package com.seal.api.gwf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Business {
    private int businessID;

    private int accountID;

    private Location location;

    private String address;

    private String businessName;

    private String businessLogo;

    private String description;

    private String benefit;
}
