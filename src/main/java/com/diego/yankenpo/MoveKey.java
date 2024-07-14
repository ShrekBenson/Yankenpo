package com.diego.yankenpo;

import java.security.SecureRandom;

public class MoveKey implements Hex{
    private String key;
    
    public MoveKey() {
        setKey();
    }
    
    private void setKey() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32];        
        random.nextBytes(bytes);
        
        this.key = toHex(bytes);
    }
    
    public String getKey() {
        return key;
    }
}
