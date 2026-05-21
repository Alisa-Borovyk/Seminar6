package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Integer> {

}
