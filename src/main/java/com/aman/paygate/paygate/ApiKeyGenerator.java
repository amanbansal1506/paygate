package com.aman.paygate.paygate;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HexFormat;

public class ApiKeyGenerator {

    private static final String KEY_PREFIX = "key_live_";
    private static final SecureRandom RANDOM = new SecureRandom();

    // Returns e.g. "key_live_Ab3x..." (KEY_PREFIX + 32 random characters)
    public static String generate() {
        byte[] bytes = new byte[24];
        RANDOM.nextBytes(bytes);
        String encoded = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
        return KEY_PREFIX + encoded;
    }

    // Returns the SHA-256 of the key as 64 lowercase hex characters
    public static String hash(String rawKey) {
       try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(rawKey.getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(hashBytes);
            } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 is not available", e);
            }
    }

    // Returns the first 13 characters (shown in the dashboard, not secret)
    public static String prefixOf(String rawKey) {
        return rawKey.substring(0, 13);
    }
}