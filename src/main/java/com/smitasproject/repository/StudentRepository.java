package com.smitasproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smitasproject.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
	
}
