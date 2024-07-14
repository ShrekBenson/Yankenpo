package com.diego.yankenpo;

public interface Hex {
    
    default String toHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte B : bytes) {
            sb.append(String.format("%02x", B));
        }
        
        return sb.toString();
    };
}
