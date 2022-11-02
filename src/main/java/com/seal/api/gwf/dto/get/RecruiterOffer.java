package com.seal.api.gwf.dto.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecruiterOffer {
    private Integer offerID;
    private int accountID;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private int state;
    private int applicationID;
    private int mapID;
}
