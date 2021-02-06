package tests.working_with_files;

import org.junit.jupiter.api.Test;
import utils.ZipUtils;

import static com.codeborne.selenide.Selenide.sleep;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.FileUtils.readStringFromFile;

public class ZipTests {
    @Test
    void checkZipTest() {
        // test data
        String dataPath = "./src/test/resources/data/1.zip";
        String dataUnzipPath = "./src/test/resources/data/unzip";
        String dataUnzipFile = "./src/test/resources/data/unzip/1.txt";
        String expectedData = "hello qa.guru";


        // read data
        new ZipUtils().unzip(dataPath, dataUnzipPath);
        sleep(1000);

        String actualData = readStringFromFile(dataUnzipFile);

        // assert data
        assertThat(actualData, containsString(expectedData));
    }
}
