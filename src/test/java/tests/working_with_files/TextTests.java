package tests.working_with_files;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.FileUtils.readStringFromFile;

public class TextTests {
    @Test
    void checkTxtTest() {
        // test data
        String dataPath = "./src/test/resources/data/1.txt";
        String expectedData = "hello qa.guru";

        // read text
        String actualData = readStringFromFile(dataPath);

        // assert data
        assertTrue(actualData.contains(expectedData));
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void negativeCheckTxtTest() {
        // test data
        String dataPath = "./src/test/resources/data/1.txt";
        String expectedData = "no hello qa.guru";

        // read text
        String actualData = readStringFromFile(dataPath);

        // assert data
        assertTrue(actualData.contains(expectedData));
        /*
        expected: <true> but was: <false>
        Expected :true
        Actual   :false
        org.opentest4j.AssertionFailedError: expected: <true> but was: <false>
         */
    }

    @Test
    void negativeCheckTxtWithHamcrestTest() {
        // test data
        String dataPath = "./src/test/resources/data/1.txt";
        String expectedData = "no hello qa.guru";

        // read text
        String actualData = readStringFromFile(dataPath);

        // assert data
        assertThat(actualData, containsString(expectedData));
        /*
        Expected: a string containing "no hello qa.guru"
        but: was "hello qa.guru students!"
        java.lang.AssertionError:
        Expected: a string containing "no hello qa.guru"
        */
    }
}
