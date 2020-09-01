package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    private Product product = new Smartphone(2, "LG", 100, "LG Electronics Inc");

    @Test
    public void shouldFindSmartphoneName() {
        boolean isMatch = product.matches("LG");
        assertTrue(isMatch);
    }

    @Test
    public void shouldNotFindSmartphoneName() {
        boolean isMatch = product.matches("Fly");
        assertFalse(isMatch);
    }

    @Test
    public void shouldFindSmartphoneManufacturer() {
        boolean isMatch = product.matches("LG Electronics Inc");
        assertTrue(isMatch);
    }

    @Test
    public void shouldNotFindSmartphoneManufacturer() {
        boolean isMatch = product.matches("LG Inc");
        assertFalse(isMatch);
    }

}