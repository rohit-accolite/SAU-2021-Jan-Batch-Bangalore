package com.au.hibernate_two.repository;

import com.au.hibernate_two.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentJPARepository extends CrudRepository<Student, Integer> {

    public Student findStudentById(int id);
    public List<Student> findStudentsByFirstName(String firstName);

}
