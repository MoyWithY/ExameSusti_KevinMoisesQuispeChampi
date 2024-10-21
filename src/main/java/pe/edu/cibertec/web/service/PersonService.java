package pe.edu.cibertec.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.web.model.Person;
import pe.edu.cibertec.web.repository.IPersonaRepository;

@Service
public class PersonService {

	@Autowired
	private IPersonaRepository data ;
	
	public List<Person> listarPerson() {
		// TODO Auto-generated method stub
		
		
		
		return (List<Person>)data.findAll(); 
	}

	public Optional<Person> listarId(int id) {
	 return data.findById(id);
	}

	
	
	
	public int Save(Person p) {
		// TODO Auto-generated method stub
		
		int res=0;
		Person persona =data.save(p);
		
		if(!persona.equals(null)) {
			res=1;
		}
		return res;
	}
	
	
	
	

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
		data.deleteById(id);
		
	}
}
