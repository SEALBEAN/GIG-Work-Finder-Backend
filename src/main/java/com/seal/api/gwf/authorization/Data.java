package com.seal.api.gwf.authorization;

import com.seal.api.gwf.authorization.ecrytion.Token;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Data extends Token {
        private String token;
}
