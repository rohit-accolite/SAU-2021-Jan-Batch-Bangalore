package com.au.hibernate_two;

import com.au.hibernate_two.entity.*;
import com.au.hibernate_two.repository.StudentRepository;
import com.au.hibernate_two.repository.StudentJPARepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;

@SpringBootApplication
@Transactional
public class HibernateTwoApplication implements CommandLineRunner {

	@Resource
	StudentRepository studentRepository;

	@Autowired
	StudentJPARepository studentJPARepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateTwoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ContactInfo c1 = new ContactInfo();
		c1.setCity("Ludhiana");
		c1.setPhone("9876543210");
		Student s1 = new Student();
		s1.setFirstName("Rohit");
		s1.setLastName("Verma");
		s1.setContactInfo(c1);

		ContactInfo c2 = new ContactInfo();
		c2.setCity("Rishikesh");
		c2.setPhone("8569745236");
		Student s2 = new Student();
		s2.setFirstName("Rahul");
		s2.setLastName("Shah");
		s2.setContactInfo(c2);

		ContactInfo c3 = new ContactInfo();
		c3.setCity("Jammu");
		c3.setPhone("9658425477");
		Student s3 = new Student();
		s3.setFirstName("Manik");
		s3.setLastName("Mittal");
		s3.setContactInfo(c3);

		//Create
		studentRepository.addStudent(s1);
		studentRepository.addStudent(s2);
		studentRepository.addStudent(s3);

		//Read
		Student student = studentRepository.getStudentById(11);

		//Update
		student.setFirstName("RV");
		studentRepository.updateStudent(student);

		//Delete
		studentRepository.deleteStudentById(12);

		List<Student> s = studentJPARepository.findStudentsByFirstName("Rohit");
		for (Student st : s) {
			System.out.println("Id: " + st.getId() + " " + "FirstName: " + st.getFirstName());
		}
	}
}