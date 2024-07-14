package com.diego.yankenpo;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HMAC implements Hex{         
    private String hmac;
    
    public HMAC(String key, String move) throws Exception {
        setHmac(key, move);
    }
    
    private void setHmac(String key, String move) throws Exception {
        Mac sha256Hmac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        sha256Hmac.init(secretKey);

        byte[] hmacBytes = sha256Hmac.doFinal(move.getBytes());
        this.hmac = toHex(hmacBytes);
    }
    
    public String getHmac() {
        return hmac;
    }
}
