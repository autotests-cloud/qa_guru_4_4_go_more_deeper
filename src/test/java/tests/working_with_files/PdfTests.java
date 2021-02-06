package tests.working_with_files;

import org.junit.jupiter.api.Test;
import com.codeborne.pdftest.PDF;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.FileUtils.readPdfFromFile;
import static utils.FileUtils.readStringFromFile;

public class PdfTests {
    @Test
    void checkPdfTest() {
        // test data
        String dataPath = "./src/test/resources/data/Google.pdf";
        String expectedData = "Сервисы Google доступны на разных языках";

        // read text
        PDF actualPdf = readPdfFromFile(dataPath);

        // assert data
        assertThat(actualPdf, PDF.containsText(expectedData));
    }

    @Test
    void negativeCheckPdfWithHamcrestTest() {
        // test data
        String dataPath = "./src/test/resources/data/Google.pdf";
        String expectedData = "Сервисы Google не доступны на разных языках";

        // read text
        PDF actualPdf = readPdfFromFile(dataPath);

        // assert data
        assertThat(actualPdf, PDF.containsText(expectedData));
        /*
        Expected: a PDF containing "Сервисы Google не доступны на разных языках"
        but: was "06.02.2021 Google https://www.google.com/?gws_rd=ssl
        1/1 Сервисы Google доступны на разных языках: ...
        */
    }
}
