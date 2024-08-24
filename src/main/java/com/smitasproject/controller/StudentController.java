package com.smitasproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.smitasproject.binding.Student;
import com.smitasproject.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public String loadIndexPage(Model model) {//model representing data that you want to send from controller to UI in form of key & value

		formInitBinding(model);
		return "index";
	}

	private void formInitBinding(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("courses", service.getCourses());
		model.addAttribute("prefTimings", service.getTimings());
	}
	
	@PostMapping("/save")
	public String handleSubmitBtn(Student s, Model model) {//model representing data that you want to send from controller to UI in form of key & value
		boolean isSaved = service.saveStudent(s);
		if(isSaved) { 
			model.addAttribute("msg", "Data Saved....");
		}
		formInitBinding(model);
		return "index";
	}
}
