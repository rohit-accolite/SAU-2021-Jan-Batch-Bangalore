package com.au.hibernate_two.repository;

import com.au.hibernate_two.entity.ContactInfo;
import com.au.hibernate_two.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    public Student getStudentById(int id) {
        Student student = entityManager.find(Student.class, id);
        ContactInfo contact = student.getContactInfo();

        System.out.println("Student Id: "+ student.getId());
        System.out.println("First name: "+ student.getFirstName());
        System.out.println("Last name: "+ student.getLastName());
        System.out.println("Phone number: "+ contact.getPhone());
        System.out.println("City: "+ contact.getCity());

        return student;
    }

    public Student updateStudent(Student student) {
        return entityManager.merge(student);
    }

    public void deleteStudentById(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
