package cl.emilym.contrastaccessibility;

/**
 * An interface representing different contrast accessibility contexts for text elements.
 * <p>
 * Contrast accessibility contexts define thresholds for contrast ratios to determine accessibility levels
 * for text elements in user interfaces.
 *
 * @see <a href="https://www.w3.org/TR/WCAG21/#contrast-minimum">WCAG 2.1 Success Criterion Contrast (Minimum)</a>
 */
public interface ContrastAccessibilityContext {

    /**
     * Gets the contrast threshold ratio for the context.
     *
     * @return The contrast threshold ratio as a double value.
     */
    double getThreshold();

    /**
     * Represents the contrast accessibility context for regular text.
     */
    public static final ContrastAccessibilityContext TEXT = new ContrastAccessibilityContext() {
        @Override
        public double getThreshold() {
            return 4.5;
        }
    };

    /**
     * Represents the contrast accessibility context for large text.
     */
    public static final ContrastAccessibilityContext LARGE_TEXT = new ContrastAccessibilityContext() {
        @Override
        public double getThreshold() {
            return 3;
        }
    };

    /**
     * Represents the contrast accessibility context for incidental text.
     * <p>
     * Incidental text has a contrast ratio threshold of 0, indicating that contrast accessibility is not required.
     */
    public static final ContrastAccessibilityContext INCIDENTAL = new ContrastAccessibilityContext() {
        @Override
        public double getThreshold() {
            return 0;
        }
    };
}
