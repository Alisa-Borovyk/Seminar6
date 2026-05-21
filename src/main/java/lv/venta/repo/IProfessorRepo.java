package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import model.Professor;

public interface IProfessorRepo extends CrudRepository<Professor, Integer> {

}
