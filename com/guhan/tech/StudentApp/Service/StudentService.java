package com.guhan.tech.StudentApp.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.guhan.tech.StudentApp.Model.Student;
import com.guhan.tech.StudentApp.Repo.StudentInterface;

@Service
@Transactional
public class StudentService {

	@Autowired
	public StudentService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	private StudentInterface studentInterface = null;

	public StudentService(StudentInterface studentInterface) {
		this.studentInterface = studentInterface;
	}

	public void saveMyStudent(Student student) {
		studentInterface.save(student);
	}

	public List<Student> showAllStudent() {
		List<Student> students = new ArrayList<Student>();
		for (Student student : studentInterface.findAll()) {
			students.add(student);
		}
		return students;
	}

	public void DeleteStudent(int id) {
		studentInterface.deleteById(id);
	}

	public Student EditStudent(int id) {
		return studentInterface.getOne(id);
	}

	public Student ViewStudent(int id) {
		return studentInterface.getOne(id);
	}

	public Student findByEmailAndPassword(String email, String password) {
		return studentInterface.findByEmailAndPassword(email, password);
	}
	
	public void sendNotification(Student student) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(student.getEmail());
		mail.setFrom("guhanmsguga@gmail.com");
		mail.setSubject("Sending Mail");
		mail.setText("I am sending mail from Spring Boot Application");
		javaMailSender.send(mail);
	}
}