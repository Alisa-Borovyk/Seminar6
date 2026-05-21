package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Course;
import lv.venta.model.Grade;

public interface IFilterService {
	
	//get all grades for student if student id is known
	
	public abstract ArrayList<Grade> filterGradeByStudentId(int id)
			throws Exception; 
	
	//get all grades for course if course title is known
	
	public abstract ArrayList<Grade> filterGradeByCourseTitle(String title)
			throws Exception;
	
	//get courses leading by professor if professor id is known
	
	public abstract ArrayList<Course> filterCourseByProfessorId(int id)
			throws Exception;

}
