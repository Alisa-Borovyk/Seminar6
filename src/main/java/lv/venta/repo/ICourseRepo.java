package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import model.Course;

public interface ICourseRepo extends CrudRepository<Course, Integer> {
	
	

}
