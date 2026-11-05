package com.aman.paygate.paygate;

import com.aman.paygate.paygate.merchant.ApiKeyGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiKeyGeneratorTests {

    @Test
    void generatedKeyHasPrefixAndLength() {
        String key = ApiKeyGenerator.generate();
        assertTrue(key.startsWith("key_live_"));
        assertEquals(41, key.length());
    }
}
