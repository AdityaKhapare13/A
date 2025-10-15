package SQTA;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Excelreader {
    private String inputFile;

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void read() throws IOException {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        int count = 0;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            Sheet sheet = w.getSheet(0);
            // Skip header row (start from row 1)
            for (int row = 1; row < sheet.getRows(); row++) {
                boolean hasMarkAbove60 = false;
                // Check only Subject1, Subject2, Subject3 (columns 1, 2, 3)
                for (int col = 1; col <= 3; col++) {
                    Cell cell = sheet.getCell(col, row);
                    try {
                        int mark = Integer.parseInt(cell.getContents());
                        if (mark >= 60) {
                            hasMarkAbove60 = true;
                            break; // No need to check other subjects
                        }
                    } catch (NumberFormatException e) {
                        // Not a number, skip
                    }
                }
                if (hasMarkAbove60) {
                    count++;
                }
            }
            // Fixed the print statement that was broken across two lines
            System.out.println("Total number of students who scored 60 or more in one or more subjects: " + count);
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Excelreader test = new Excelreader();
        test.setInputFile("C:\\Users\\HP\\eclipse-workspace\\SQTA\\student.xls");
        test.read();
    }
}
