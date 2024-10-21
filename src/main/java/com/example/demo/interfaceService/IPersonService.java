package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import pe.edu.cibertec.web.model.Person;

public interface IPersonService {

	public List<Person>listarPerson();
	public Optional<Person>listarId(int id);
	public int Save(Person p);
	public void delete (int d);
	
	
	
}
