package com.guhan.tech.StudentApp.Controller;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.guhan.tech.StudentApp.Model.Student;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UserPDF {

	private List<Student> listusers;
	
	public UserPDF(List<Student> listusers) {
		this.listusers = listusers;
	}
	
	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.cyan);
		cell.setPadding(5);
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);
		
		cell.setPhrase(new Phrase("ID",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("FirstName",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("LastName",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Email",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Password",font));
		table.addCell(cell);
	}
	
	private void writeTableData(PdfPTable table) {
		
		for(Student student:listusers) {
			table.addCell(String.valueOf(student.getId()));
			table.addCell(student.getFirstname());
			table.addCell(student.getLastname());
			table.addCell(student.getEmail());
			table.addCell(student.getPassword());
//			table.addCell(String.valueOf(pieChartData.isEnabled()));
		}
	}
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		
		document.add(new Paragraph("List of all users"));
		
		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100);
		table.setSpacingBefore(15);
		
		writeTableHeader(table);
		writeTableData(table);
		
		document.add(table);
		
		document.close();
	}
}
