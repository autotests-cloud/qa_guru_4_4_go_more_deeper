package tests.working_with_files;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.FileUtils.*;

public class XslTests {
    @Test
    void checkXlsTest() {
        // test data
        String dataPath = "./src/test/resources/data/1.xls";
        String expectedData = "hello qa.guru";

        // read text
        XLS actualXls = readXlsFromFile(dataPath);

        // assert data
        assertThat(actualXls, XLS.containsText(expectedData));
    }

    @Test
    void negativeCheckXlsTest() {
        // test data
        String dataPath = "./src/test/resources/data/1.xls";
        String expectedData = "no hello qa.guru";

        // read text
        XLS actualXls = readXlsFromFile(dataPath);

        // assert data
        assertThat(actualXls, XLS.containsText(expectedData));
        /*
        Expected: a XLS containing text "no hello qa.guru"
         but: was "C:\Users\Vasenkov\IdeaProjects\qa_guru_4_4_go_more_deeper\.\src\test\resources\data\1.xls"
        hello qa.guru
        some text
         */
    }

    @Test
    void checkXlsTextTest() {
        // test data
        String dataPath = "./src/test/resources/data/1.xls";
        String expectedData = "hello qa.guru";

        // read text
        XLS actualXls = readXlsFromFile(dataPath);
        String actualCell = actualXls.excel.getSheetAt(0).getRow(3).getCell(1).toString();

        // assert data
        assertThat(actualCell, containsString(expectedData));
    }

    @Test
    void checkXlsxTest() {
        // test data
        String dataPath = "./src/test/resources/data/1.xlsx";
        String expectedData = "hello qa.guru";

        // read text
        String actualXls = readXlsxFromFile(dataPath);

        // assert data
        assertThat(actualXls, containsString(expectedData));
    }
}
