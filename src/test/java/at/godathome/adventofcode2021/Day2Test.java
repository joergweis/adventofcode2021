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

public class Day2Test {
    private String[] inputData;
    private Day2 day2;

    @BeforeEach
    protected void setup() throws NullPointerException {
        // read input data from resource file
        File f = new File(this.getClass().getResource("./InputDay2.list").getFile());
        Path filePath = f.toPath();
        Charset charset = Charset.defaultCharset();
        List<String> stringList = null;
        try {
            stringList = Files.readAllLines(filePath, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputData = stringList.toArray(new String[]{});

        day2 = new Day2();
    }

    @Test
    public void shouldReturnHorizontalTimesDepth() {
        // pentest data
        assertThat(day2.returnHorizontalTimesDepth(new String[]{"forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2"})).isEqualTo(10);

        // assertThat(day2.returnFinalDepth(inputData)).isEqualTo(10);
    }
}
