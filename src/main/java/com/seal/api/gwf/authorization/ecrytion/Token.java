package com.seal.api.gwf.authorization.ecrytion;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    private int id;
    private String email;
    private String role;
    private String name;
    private String picUrl;
    private String gender;//    Nam/Nữ

}
