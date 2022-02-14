package com.aad.student;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String name, email;
	private Integer age;
	private LocalDate date;

	public Student() {
		super();
	}

	public Student(Long id, String name, String email, Integer age, LocalDate date) {
		super();
		Id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.date = date;
	}

	public Student(String name, String email, Integer age, LocalDate date) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.date = date;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Estudiante [Id=" + Id + ", name=" + name + ", email=" + email + ", age=" + age + ", date=" + date + "]";
	}

}
