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
                horizontal = horizontal + Integer.parseInt(value.substring(forward.length(), value.length()).trim());
            } else if (value.contains(up)) {
                depth = depth - Integer.parseInt(value.substring(up.length(), value.length()).trim());
            } else {
                depth = depth + Integer.parseInt(value.substring(down.length(), value.length()).trim());
            }
        }
        horizontalMultipliedWithDepth = horizontal * depth;
        return horizontalMultipliedWithDepth;
    }

    protected int returnHorizontalTimesDepthWithAim(String[] values)
    {
        int horizontal = 0;
        int depth = 0;
        int aim = 0;
        int horizontalMultipliedWithDepth = 0;
        String forward = "forward";
        String up = "up";
        String down = "down";

        for (String value:values) {
            if (value.contains(forward)) {
                int currentValue = Integer.parseInt(value.substring(forward.length(), value.length()).trim());
                horizontal = horizontal + currentValue;
                if (aim > 0) {
                    depth = depth + (aim * currentValue);
                }
            } else if (value.contains(up)) {
                int currentValue = Integer.parseInt(value.substring(up.length(), value.length()).trim());
                // rtfm depth is only changed by forward!!!
                //depth = depth - currentValue;
                aim = aim - currentValue;
            } else {
                int currentValue = Integer.parseInt(value.substring(down.length(), value.length()).trim());
                // rtfm depth is only changed by forward!!!
                //depth = depth + currentValue;
                aim = aim + currentValue;
            }
        }
        horizontalMultipliedWithDepth = horizontal * depth;
        return horizontalMultipliedWithDepth;
    }
}
