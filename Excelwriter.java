package SQTA;

import jxl.*;
import jxl.write.*;
import jxl.write.Number;
import java.io.*;
import java.util.Locale;

public class Excelwriter {
    public static void main(String[] args) throws IOException, WriteException {
        int r = 0, c = 0;
        String[] header = {"Student Name", "Subject1", "Subject2", "Subject3", "Total"};
        String[] sname = {"Akash", "Karthik", "Keziah", "Sakshi"};
        int[] marks = {50, 45, 60, 55, 70, 45, 67, 78, 89, 90, 30, 40}; // 4 students × 3 subjects = 12 marks

        File file = new File("student.xls");
        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));
        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        WritableSheet excelSheet = workbook.createSheet("Report", 0);

        // Create header
        for (c = 0; c < header.length; c++) {
            Label l = new Label(c, 0, header[c]);
            excelSheet.addCell(l);
        }

        int markIndex = 0; // to track index in marks[]
        // Fill student data
        for (r = 1; r <= sname.length; r++) {
            // Student Name
            Label nameLabel = new Label(0, r, sname[r - 1]);
            excelSheet.addCell(nameLabel);
            int total = 0;

            // Subjects 1 to 3
            for (c = 1; c <= 3; c++) {
                int mark = marks[markIndex++];
                total += mark;
                Number markCell = new Number(c, r, mark);
                excelSheet.addCell(markCell); // fixed line
            }

            // Total
            Number totalCell = new Number(4, r, total);
            excelSheet.addCell(totalCell);
        }

        workbook.write();
        workbook.close();
        System.out.println("Excel File Created!!!!!");
    }
}
