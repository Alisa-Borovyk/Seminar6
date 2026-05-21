package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import model.Student;

public interface IStudentRepo extends CrudRepository<Student, Integer> {
	
	

}
