package com.seal.api.gwf.authorization.ecrytion;

public interface CryptionService {
    public String encrypt(String data);
    public String decrypt(String data);

    public String encode(Token token);
    public Token decode(String token);

}
