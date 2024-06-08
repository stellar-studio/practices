package dev.practice.order.common.util;


import java.util.UUID;

public class TokenGenerator {
    public static String randomCharacter() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}