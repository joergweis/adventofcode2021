package at.godathome.adventofcode2021;

public class Day3 {
    int rowCount = 0;
    int valueLenght = 0;
    protected int binaryDiagnostic(String[] values) {

        // initialize array with length of list and width of value length
        rowCount = values.length;
        valueLenght = values[0].length();
        int[][] valueArray = new int[rowCount][valueLenght];
        // fill multidimensional array with value
        valuesToMultiDimensionalArray(valueArray, values);
        // get the non/significant bits per column
        return getMostAndLeastSignificantBitPerColumn(valueArray);
    }

    private void valuesToMultiDimensionalArray(int[][] data, String[] values) {
        // fill array from values each line into one row
        int row = 0;
        for (String value:values) {
            char[] charArray = value.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                data[row][i] = Character.getNumericValue(charArray[i]);
            }
            row = row + 1;
        }
    }

    private int getMostAndLeastSignificantBitPerColumn(int[][] data) {
        // loop through all values row by row and build up the values per column
        // get the most and least significant bit per column to return gamma and epsilon
        String[] columnValues = new String[data.length - 1];
        for (int j = 0; j <= (valueLenght - 1); j++) {
            for (int i = 0; i <= (data.length - 1); i++) {
                if (columnValues[j] == null) {
                    columnValues[j] = Integer.toString(data[i][j]);
                } else {
                    columnValues[j] = columnValues[j].trim() + Integer.toString(data[i][j]);
                }
            }
        }

        // determine most occuring char in values
        String sGamma = "";
        String sEpsilon = "";
        for (String value:columnValues) {
            if (value != null) {
                char mostSignificantChar = AdventUtil.getMaxOccuringChar(value);
                sGamma = sGamma.trim() + mostSignificantChar;
                if (mostSignificantChar == '1') {
                    sEpsilon = sEpsilon.trim() + "0";
                } else {
                    sEpsilon = sEpsilon.trim() + "1";
                }
            }
        }
        int gamma = Integer.parseInt(sGamma,2);
        int epsilon = Integer.parseInt(sEpsilon, 2);
        return gamma * epsilon;
    }

}
