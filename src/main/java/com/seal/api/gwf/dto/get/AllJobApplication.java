package com.seal.api.gwf.dto.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllJobApplication {
    private int applicationID;
    private String firstName;
    private String lastName;
    private String jobName;
    private String businessName;
    private String businessAddress;
    private String joAddress;
}
