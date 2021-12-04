package at.godathome.adventofcode2021;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day1Test {
    private String[] inputData;
    private Day1 day1;

    @BeforeEach
    protected void setup() throws NullPointerException, IOException {
        // read input data from resource file
        File f = new File(this.getClass().getResource("./InputDay1.list").getFile());
        Path filePath = f.toPath();
        Charset charset = Charset.defaultCharset();
        List<String> stringList = Files.readAllLines(filePath, charset);
        inputData = stringList.toArray(new String[]{});

        day1 = new Day1();
    }

    @Test
    public void shouldReturnIncreasedCount() {
        // pentest data
        // assertThat(day1.countIncreased(new String[]{"199","200","208","210","200","207","240","269","260","263"})).isEqualTo(7);

        assertThat(day1.sumIncreased(inputData)).isEqualTo(1393);
    }

    @Test
    public void shouldReturnSlidedWindowIncreaseCounter() {

        // pentest data
        // assertThat(day1.sumSlidedWindowIncreased(new String[]{"199","200","208","210","200","207","240","269","260","263"})).isEqualTo(5);

        assertThat(day1.sumSlidedWindowIncreased(inputData)).isEqualTo(1359);
    }
}
