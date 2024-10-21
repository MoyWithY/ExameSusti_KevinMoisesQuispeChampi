package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceService.IPersonService;

import org.springframework.ui.Model;

import pe.edu.cibertec.web.model.Person;



@Controller
@RequestMapping
public class PersonController {

	@Autowired
	
	private IPersonService service;
	
	
	@GetMapping("/listar")
	public String Listar(Model model ) {
		List<Person>personas =service.listarPerson();
		model.addAttribute("personas",personas);	
		return "index";
	}
	
	@GetMapping("/nuevo")
	public String Agregar (Model model){
		model.addAttribute("personaAgregar", new Person());
		return "formulario";
	}
	
	@PostMapping ("/save")
	
	public String save (@Validated Person p, Model model) {
		
		service.Save(p);
		
		return "redirect:/listar";
	}
	
	@PostMapping ("/editar/{id}")
	public String editar (@PathVariable int id , Model model) {
		Optional<Person> persona =service.listarId(id);
		model.addAttribute("persona", persona);
		
		return "formulario";
	}
	
	public String delete (Model model ,@PathVariable int id ) {
		
		service.delete(id);
		
		return "redirect:/listar";
		
		
	}
	
	
}
