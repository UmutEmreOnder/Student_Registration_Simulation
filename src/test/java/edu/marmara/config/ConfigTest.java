package edu.marmara.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ConfigTest {
    /**
     * Method under test:
     *
     * Config#Config(Double)
     */
    @Test
    void testConstructor() {
        assertEquals(0.25d, (new Config(0.25d)).getPassProbability().doubleValue());
        assertNull((new Config()).getPassProbability());
    }

    /**
     * Methods under test:
     *
     *    Config# Config()
     *    Config#setPassProbability(Double)
     */
    @Test
    void testConstructor2() {
        Config actualConfig = new Config();
        actualConfig.setPassProbability(0.25d);
        assertEquals(0.25d, actualConfig.getPassProbability().doubleValue());
    }
}

