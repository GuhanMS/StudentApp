 package com.guhan.tech.StudentApp.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.guhan.tech.StudentApp.Model.Student;



public class UserExcel {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	private List<Student> student;

	public UserExcel(List<Student> student) {
		this.student = student;
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Users");
	}

	private void writeHeaderRow() {
		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		Cell cell = row.createCell(0);
		cell.setCellValue("Id");
		cell.setCellStyle(style);

		cell = row.createCell(1);
		cell.setCellValue("FirstName");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("LastName");
		cell.setCellStyle(style);

		cell = row.createCell(3);
		cell.setCellValue("Email");
		cell.setCellStyle(style);

		cell = row.createCell(4);
		cell.setCellValue("Password");
		cell.setCellStyle(style);
	}

	private void writeDataRows() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(14);
		style.setFont(font);

		for (Student student : student) {
			Row row = sheet.createRow(rowCount++);

			Cell cell = row.createCell(0);
			cell.setCellValue(student.getId());
			sheet.autoSizeColumn(0);
			cell.setCellStyle(style);

			cell = row.createCell(1);
			cell.setCellValue(student.getFirstname());
			sheet.autoSizeColumn(1);
			cell.setCellStyle(style);

			cell = row.createCell(2);
			cell.setCellValue(student.getLastname());
			sheet.autoSizeColumn(2);
			cell.setCellStyle(style);

			cell = row.createCell(3);
			cell.setCellValue(student.getEmail());
			sheet.autoSizeColumn(3);
			cell.setCellStyle(style);

			cell = row.createCell(4);
			cell.setCellValue(student.getPassword());
			sheet.autoSizeColumn(4);
			cell.setCellStyle(style);
		}
	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderRow();
		writeDataRows();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);

	}
}
