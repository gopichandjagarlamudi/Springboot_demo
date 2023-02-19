package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository 
	extends JpaRepository<student ,Long> {
	@Query("Select s from student s WHERE s.email = ?1")
	Optional<student> findStudentByEmail(String email);

}
