package com.smitasproject.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smitasproject.binding.Student;
import com.smitasproject.entity.StudentEntity;
import com.smitasproject.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;
	
	public boolean saveStudent(Student student) {
		StudentEntity entity = new StudentEntity();
		BeanUtils.copyProperties(student, entity);
		entity.setTimings(Arrays.toString(student.getTimings()));
		repo.save(entity);
		return true;
	}
	public List<String> getCourses(){
		return Arrays.asList("Java","Python","AWS","DevOps");
	}
	public List<String> getTimings(){
		return Arrays.asList("Morning","Afternoon","Evening");
	}
}
