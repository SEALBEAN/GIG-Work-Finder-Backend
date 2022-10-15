package com.seal.api.gwf.dto.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusinessForm {
    private Integer location;

    private Integer accountID;

    private String address;

    private String businessName;

    private String businessLogo;

    private String description;

    private String benefit;
}
