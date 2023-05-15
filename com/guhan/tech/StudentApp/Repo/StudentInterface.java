package com.guhan.tech.StudentApp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guhan.tech.StudentApp.Model.Student;


@Repository
public interface StudentInterface extends JpaRepository<Student, Integer> {

	public Student findByEmailAndPassword(String email, String password);
}