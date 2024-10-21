package pe.edu.cibertec.web.repository;

import org.springframework.data.repository.CrudRepository;

import pe.edu.cibertec.web.model.Person;

public interface IPersonaRepository extends CrudRepository<Person, Integer>{

}
