 package com.guhan.tech.StudentApp.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guhan.tech.StudentApp.Repo.StudentInterface;
import com.guhan.tech.StudentApp.Service.StudentService;
import com.lowagie.text.DocumentException;
import com.guhan.tech.StudentApp.Model.*;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentInterface studentInterface;
	
	@RequestMapping("/Home")
	public String Home()
	{
		return "Home";
	}
	
	@ResponseBody
	@RequestMapping("/Hom")
	public String home1()
	{
		return "hi welcome";
	}
	
	
	@RequestMapping("/Register")
	public String registeration()
	{
		return "Register";
	}
	
	@RequestMapping("/Login")
	public String login()
	{
		return "Login";
	}
	
	@RequestMapping("/DeleteStudent")
	public String DeleteStudent(@RequestParam int id, HttpServletRequest request)
	{
		studentService.DeleteStudent(id);
		request.setAttribute("student", studentService.showAllStudent());
		request.setAttribute("errorSuccess", "Successfully Deleted");
		return "Allstudent";
	}
	
	@RequestMapping("/EditStudent")
	public String EditStudent(@RequestParam int id,HttpServletRequest request)
	{  
		request.setAttribute("student", studentService.EditStudent(id));
		return "Editstudent";
	}
	
	@RequestMapping("/Student")
	public String Student(@RequestParam int id,HttpServletRequest request)
	{
		request.setAttribute("studentView", studentService.ViewStudent(id));
		return "Student";
	}
	
	@RequestMapping("/LoginStudent")
	public String loginStudent(@ModelAttribute Student student, HttpServletRequest request)
	{
		if(studentService.findByEmailAndPassword(student.getEmail(), student.getPassword())!=null) {
			System.out.println(student);
			System.out.println("successfull login");
		return "LoginHome";
		} else {
			request.setAttribute("errorfail", "Invalid Email or Password");
			return "Login";
		}
	}
	
//	pdf
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");

		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateformat.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";

		response.setHeader(headerKey, headerValue);
		List<Student> listUsers = studentInterface.findAll();

		UserPDF exporter = new UserPDF(listUsers);
		exporter.export(response);
	}
	
//	excel
	@GetMapping("/excel")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormat.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";

//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//		String currentDateTime = dateFormat.format(new Date());
//		String fileName = "users_"+ currentDateTime +".xlsx";
//		String headerValue = "attachment; filename"+ fileName;

		response.setHeader(headerKey, headerValue);

		List<Student> listUsers = studentInterface.findAll();

		UserExcel exporter = new UserExcel(listUsers);
		exporter.export(response);
	}
	
	
//	Getting Data from MYSQL database
	@GetMapping("/Allstudent")
	public String getData(HttpServletRequest request)
	{
		request.setAttribute("student", studentService.showAllStudent());
		return "Allstudent";
	}
	
//	Adding Data in MYSQL Database
	@PostMapping("/addData")
	public String registerStd(@ModelAttribute Student student, BindingResult bindingResult, HttpServletRequest request) {
		 studentService.saveMyStudent(student);
		 studentService.sendNotification(student);
		 System.out.println(student.getEmail());
		return "Login";
	}
	
	@RequestMapping("**")
	public String PageNotFound()
	{
		return "Error";
	}

	//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
}