package at.godathome.adventofcode2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day3Test {
    private String[] inputData;
    private Day3 day3;

    @BeforeEach
    protected void setup() throws NullPointerException {
        // read input data from resource file
        File f = new File(this.getClass().getResource("/InputDay3.list").getFile());
        Path filePath = f.toPath();
        Charset charset = Charset.defaultCharset();
        List<String> stringList = null;
        try {
            stringList = Files.readAllLines(filePath, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputData = stringList.toArray(new String[]{});

        day3 = new Day3();
    }

    @Test
    public void shouldReturnBinaryDiagnostic() {
        // pentest data
        //assertThat(day3.binaryDiagnostic(new String[]{"00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010"})).isEqualTo(198);

        assertThat(day3.binaryDiagnostic(inputData)).isEqualTo(1307354);
    }
}


