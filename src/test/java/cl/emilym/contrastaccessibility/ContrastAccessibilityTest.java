package cl.emilym.contrastaccessibility;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContrastAccessibilityTest {

    @Test
    void testValidContrastRatio() {
        // Colors with contrast ratio greater than 3
        long color1 = 0xFF0000; // Red
        long color2 = 0x000000; // Green
        assertTrue(ContrastAccessibility.valid(color1, color2));
    }

    @Test
    void testValidContrastRatioWithAlpha() {
        // Colors with contrast ratio greater than 3
        long color1 = 0xFFFF0000L; // Red
        long color2 = 0xFF000000L; // Green
        assertTrue(ContrastAccessibility.valid(color1, color2));
    }

    @Test
    void testInvalidContrastRatio() {
        // Colors with contrast ratio less than 3
        long color1 = 0xFF0000; // Red
        long color2 = 0xFF9900; // Orange
        assertFalse(ContrastAccessibility.valid(color1, color2));
    }

    @Test
    void testInvalidContrastRatioWithAlpha() {
        // Colors with contrast ratio less than 3
        long color1 = 0xFFFF0000L; // Red
        long color2 = 0xFFFF9900L; // Orange
        assertFalse(ContrastAccessibility.valid(color1, color2));
    }

    @Test
    void testValidContrastRatioBlackWhite() {
        // Colors with high contrast ratio (black and white)
        long color1 = 0x000000; // Black
        long color2 = 0xFFFFFF; // White
        assertTrue(ContrastAccessibility.valid(color1, color2));
    }

    @Test
    void testInvalidContrastRatioGreyscale() {
        // Colors with low contrast ratio (black and dark gray)
        long color1 = 0x000000; // Black
        long color2 = 0x333333; // Dark Gray
        assertFalse(ContrastAccessibility.valid(color1, color2));
    }

    @Test
    void testValidContrastRatioSameColor() {
        // Same colors, should never have valid contrast ratio
        long color1 = 0xFF0000; // Red
        long color2 = 0xFF0000; // Red
        assertFalse(ContrastAccessibility.valid(color1, color2));
    }

}