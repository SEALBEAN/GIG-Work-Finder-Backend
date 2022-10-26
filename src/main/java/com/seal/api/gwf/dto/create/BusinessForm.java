package com.seal.api.gwf.dto.create;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusinessForm {
    private Integer locationID;

    private Integer accountID;

    private String address;

    private String businessName;

    private MultipartFile businessLogo;

    private String description;

    private String benefit;
}
