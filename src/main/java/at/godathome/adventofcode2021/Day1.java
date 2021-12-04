package at.godathome.adventofcode2021;

import java.util.Arrays;

public class Day1 {
    protected int sumIncreased(String[] values)
    {
        int previousValue = 0;
        int increasedCtr = 0;

        for (String value:values) {
            if (previousValue == 0) {
                previousValue = Integer.parseInt(value.trim());
            } else if (Integer.parseInt(value.trim()) > previousValue) {
                increasedCtr++;
                previousValue = Integer.parseInt(value.trim());
            } else {
                previousValue = Integer.parseInt(value.trim());
            }
        }
        return increasedCtr;
    }

    protected int sumSlidedWindowIncreased(String[] values) {
        // what to do:
        // on each iteration sum the last three and
        // create a left window value array and a right window array
        // on each iteration fill both arrays, sum and check if rightwindow is bigger than left window
        // shift right
        // guard is to check if rightWindow last position is greater than values .length -1 (array starts with 0)
        int[] leftWindow = {0,0,0};
        int[] rightWindow = {0,0,0};
        int increasedCtr = 0;

        for (int i = 0; i < values.length; i++) {
            if ((i + 3) > (values.length - 1)) {
                break;
            }
            fillLeftWindow(values, leftWindow, i);
            fillRightWindow(values, rightWindow, i);
            increasedCtr = compareWindowSums(leftWindow, rightWindow, increasedCtr);
        }
        return increasedCtr;
    }

    private int compareWindowSums(int[] leftWindow, int[] rightWindow, int increasedCtr)
    {
        int sumLeftWindow = Arrays.stream(leftWindow).sum();
        int sumRightWindow = Arrays.stream(rightWindow).sum();
        // System.out.println(sumLeftWindow + " vs " + sumRightWindow);

        if (sumRightWindow > sumLeftWindow) {
            return increasedCtr + 1;
        } else {
            return increasedCtr;
        }
    }

    private void fillRightWindow(String[] values, int[] rightWindow, int i) {
        rightWindow[0] = Integer.parseInt(values[i+1]);
        rightWindow[1] = Integer.parseInt(values[i+2]);
        rightWindow[2] = Integer.parseInt(values[i+3]);
    }

    private void fillLeftWindow(String[] values, int[] leftWindow, int i) {
        leftWindow[0] = Integer.parseInt(values[i]);
        leftWindow[1] = Integer.parseInt(values[i+1]);
        leftWindow[2] = Integer.parseInt(values[i+2]);
    }
}
