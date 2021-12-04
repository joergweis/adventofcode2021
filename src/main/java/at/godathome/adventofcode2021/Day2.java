package at.godathome.adventofcode2021;

import java.util.Arrays;

public class Day2 {
    protected int returnHorizontalTimesDepth(String[] values)
    {
        int horizontal = 0;
        int depth = 0;
        int horizontalMultipliedWithDepth = 0;
        String forward = "forward";
        String up = "up";
        String down = "down";

        for (String value:values) {
            if (value.contains(forward)) {
                horizontal = horizontal + Integer.parseInt(value.substring(forward.length(), value.length()));
            } else if (value.contains(up)) {
                depth = depth - Integer.parseInt(value.substring(up.length(), value.length()));
            } else {
                depth = depth + Integer.parseInt(value.substring(down.length(), value.length()));
            }
        }
        horizontalMultipliedWithDepth = horizontal * depth;
        return horizontalMultipliedWithDepth;
    }
}
