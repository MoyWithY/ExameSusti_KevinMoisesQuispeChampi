package com.example.demo.controller;


import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;



import pe.edu.cibertec.web.model.User;
import pe.edu.cibertec.web.repository.IPersonRepository;
import pe.edu.cibertec.web.repository.IRoleRepository;
import pe.edu.cibertec.web.repository.IUserRepository;
import pe.edu.cibertec.web.service.UserService;

@Controller
public class ProyectoController {
	
	@Autowired
	private IRoleRepository repos;
	
	@Autowired
	private IPersonRepository reposPerson;
	
	
	
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/greeting")
	public String greeting (@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@GetMapping("/listar")
	public String listRole(Model model) {
		try {
			model.addAttribute("ltsRole", repos.findAll());
			model.addAttribute("ltsPerson", reposPerson.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "listado";
	}
	

	
	
	@GetMapping("/login")
	public String loginGet(Model model) {
		System.out.println("Mostrando loginGet");
		User uNew = new User();
		model.addAttribute("usrLogin", uNew);
		return "login";
	}
	
	
	@PostMapping("/login")
	public String loginPost(@ModelAttribute User user, Model model) {
		System.out.println("Validando loginPost");		
		String redirect = "login2";
		User u2 = userService.validateUserByNameAndPassword(user.getName(), user.getPassword());
		if (u2 != null) {
			u2.setLastlogin(new Date());
			System.out.println("Actualizando usuario - Login2");
		User updateUser = userService.updateUserLogin(u2);
			model.addAttribute("usrLogin", updateUser);
			redirect = "login";
		} else {
			model.addAttribute("errors", "Usuario o clave incorrectos");
			model.addAttribute("usrLogin", new User());
		}
		return redirect;
	}
	
	
	
	
	
	
}
