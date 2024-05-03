package cl.emilym.contrastaccessibility;

/**
 *
 */
public class ContrastAccessibility {

    private static final int CHANNEL_MASK = 0xFF;
    private static final int RED_SHIFT = 16;
    private static final int GREEN_SHIFT = 8;
    private static final int BLUE_SHIFT = 0;

    private static final double DOUBLE_DENOMINATOR = 255.0;

    private ContrastAccessibility() {}

    /**
     * Checks if the contrast ratio between two colors meets the accessibility threshold for text.
     *
     * @param color1 The first color as a long integer.
     * @param color2 The second color as a long integer.
     * @return true if the contrast ratio is above the text accessibility threshold, false otherwise.
     */
    public static boolean valid(
            long color1,
            long color2
    ) {
        return valid(color1, color2, ContrastAccessibilityContext.TEXT);
    }

    /**
     * Checks if the contrast ratio between two colors meets the accessibility threshold for a specified context.
     *
     * @param color1   The first color as a long integer.
     * @param color2   The second color as a long integer.
     * @param context  The context for which to check the accessibility threshold.
     * @return true if the contrast ratio is above the specified accessibility threshold, false otherwise.
     */
    public static boolean valid(
            long color1,
            long color2,
            ContrastAccessibilityContext context
    ) {
        return ratio(color1, color2) > context.getThreshold();
    }

    /**
     * Calculates the contrast ratio between two colors.
     *
     * @param color1 The first color as a long integer.
     * @param color2 The second color as a long integer.
     * @return The contrast ratio between the two colors.
     * @see <a href="https://www.w3.org/TR/WCAG21/#dfn-contrast-ratio">WCAG 2.1 Contrast Ratio</a>
     */
    public static double ratio(long color1, long color2) {
        double luminance1 = luminance(color1) + 0.05;
        double luminance2 = luminance(color2) + 0.05;
        if (luminance1 > luminance2) {
            return luminance1 / luminance2;
        } else {
            return luminance2 / luminance1;
        }
    }

    /**
     * Calculates the relative luminance of a color as per WCAG 2.1 specifications.
     *
     * @param color The color as a long integer.
     * @return The relative luminance of the color.
     * @see <a href="https://www.w3.org/TR/WCAG21/#dfn-relative-luminance">WCAG 2.1 Relative Luminance</a>
     */
    public static double luminance(long color) {
        double[] channels = new double[]{
            ((color >> RED_SHIFT) & CHANNEL_MASK) / DOUBLE_DENOMINATOR,
            ((color >> GREEN_SHIFT) & CHANNEL_MASK) / DOUBLE_DENOMINATOR,
            ((color >> BLUE_SHIFT) & CHANNEL_MASK) / DOUBLE_DENOMINATOR
        };

        for (int i = 0; i < channels.length; i++) {
            double channel = channels[i];
            if (channel < 0.04045) {
                channels[i] /= 12.92;
            } else {
                channels[i] = Math.pow((channel + 0.055) / 1.055, 2.4);
            }
        }

        return ((0.2126 * channels[0]) + (0.7152 * channels[1]) + (0.0722 * channels[2]));
    }

}
