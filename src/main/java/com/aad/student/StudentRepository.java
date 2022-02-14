package com.aad.student;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {

	// @Query("SELECT s FROM Student s WHERE s.email=?1")
	Optional<Student> findStudentByEmail(String email);

	@Transactional
	@Modifying
	@Query("UPDATE Student s SET s.name=?1, s.email=?2 WHERE s.id=?3")
	void updateStudentByNameAndEmail(String name, String email, Long studentId);

}
