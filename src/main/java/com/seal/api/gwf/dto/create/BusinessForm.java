package com.seal.api.gwf.dto.create;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class BusinessForm {
    private Integer businessID;

    private Integer locationID;

    private Integer accountID;

    private String address;

    private String businessName;

    private MultipartFile businessLogo;

    private String description;

    private String benefit;

    public BusinessForm(Integer locationID, Integer accountID, String address, String businessName, MultipartFile businessLogo, String description, String benefit) {
        this.locationID = locationID;
        this.accountID = accountID;
        this.address = address;
        this.businessName = businessName;
        this.businessLogo = businessLogo;
        this.description = description;
        this.benefit = benefit;
    }
}
