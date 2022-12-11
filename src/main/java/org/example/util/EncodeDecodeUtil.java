package org.example.util;

import java.util.Base64;

public class EncodeDecodeUtil {
    private  final Base64.Encoder encoder = Base64.getEncoder();
    private  final Base64.Decoder decoder = Base64.getDecoder();

    public  byte[] encode(String password) {
        return encoder.encode(password.getBytes());
    }

    public  String decode(byte[] bytes) {
        return new String(decoder.decode(bytes));
    }
}
