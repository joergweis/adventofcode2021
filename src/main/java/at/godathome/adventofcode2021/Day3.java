package at.godathome.adventofcode2021;

public class Day3 {
    protected int binaryDiagnostic(String[] values) {

        int[][] valueArray = new int[values.length][5];
        // fill multidimensional array with value
        fillValueArray(valueArray, values);
        // get the non/significant bits per column
        int gamma = getMostSignificantBitPerColumn(valueArray);
        int epsilon = getLeastSignificantBitPerColumn(valueArray);

        return gamma * epsilon;
    }

    private void fillValueArray(int[][] data, String[] values) {
        // fill array from values
        int row = 0;
        for (String value:values) {
            char[] charArray = value.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                data[row][i] = Character.getNumericValue(charArray[i]);
            }
            row = row + 1;
        }
    }

    private int getMostSignificantBitPerColumn(int[][] data) {
        return 0;
    }

    private int getLeastSignificantBitPerColumn(int[][] data) {
        return 0;
    }
}
