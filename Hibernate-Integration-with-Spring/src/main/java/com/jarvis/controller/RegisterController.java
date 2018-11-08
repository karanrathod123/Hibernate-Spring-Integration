package com.jarvis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jarvis.model.Student;
import com.jarvis.service.StudentService;

@Controller
public class RegisterController {
	@Autowired
	StudentService studentservice;

	@RequestMapping("index")
	public String viewRegisterPage(Model model) {
		model.addAttribute("studentFormRegister", new Student());
		return "registration";
	}

	@RequestMapping(value = "studentRegister", method = RequestMethod.POST) // form value
	public String forwardRegiseterPage(Model model, @ModelAttribute("studentFormRegister") Student student,
			RedirectAttributes redirectAttributes) // no comma
	{
		System.out.println(student.getName());
		Boolean bx = studentservice.saveStudent(student);
		if (bx == true) {
			redirectAttributes.addFlashAttribute("success", "saved succesfully");
			return "redirect:index";
		} else {
			redirectAttributes.addFlashAttribute("error", "Data not saved");
			return "redirect:index";
		}

	}

	@ModelAttribute("list")
	public List<Student> getList() {
		return studentservice.getList();

	}

	@RequestMapping(value = "editStudent", method = RequestMethod.GET)
	public String editStudentAction(Model model, @RequestParam("id") Integer id) {
		model.addAttribute("studentFormRegister", studentservice.getStudentById(id));			//value as model attribute for binding result	
		return "registration";																	//page name

	}

	@RequestMapping(value = "deleteStudent",method=RequestMethod.GET)
	private String deleteAction(Model model, @RequestParam("id")Integer id,RedirectAttributes attributes) 
	{
		Boolean bx=studentservice.deleteStudent(id);
		if(bx==true)
		{
			attributes.addFlashAttribute("success", "succesfully deleted");
			return "redirect:index";
		}
		else
		{
			attributes.addFlashAttribute("error", "not deleted data");
			return "redirect:index";
			
		}
		
		
		
	}

}
