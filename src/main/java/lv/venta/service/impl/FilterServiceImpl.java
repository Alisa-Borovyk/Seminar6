package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IFilterService;

@Service
public class FilterServiceImpl implements IFilterService {
	
	@Autowired
	private IStudentRepo studRepo;
	
	private IGradeRepo gradeRepo;
	
	private ICourseRepo courseRepo;
	

	@Override
	public ArrayList<Grade> filterGradeByStudentId(int id) throws Exception {
		// TODO Auto-generated method stub
		if (id<1) {
			throw new Exception("Must be positive");
		}
		
		if (!studRepo.existsById(id)) {
			throw new Exception("Student with id " + id + " doesn`t exist");
		}
		
		if(gradeRepo.count() == 0) {
			throw new Exception ("No grades in DB");
		}
		
		ArrayList<Grade> resultFromDB = gradeRepo.findByStudentSid(id);
		
		if (resultFromDB.isEmpty()) {
			throw new Exception ("NO linked grades to student with id " + id);
		}
		
		return null;
	}

	@Override
	public ArrayList<Grade> filterGradeByCourseTitle(String title) throws Exception {
		// TODO Auto-generated method stub
		
		if (title == null || title.isEmpty()) {
			throw new Exception ("Title can`t be empty and null");
		}
		
		if (!courseRepo.existsByTtile(title)) {
			throw new Exception ("Course" + title + "doesn`t exist");
		}
		
		if (gradeRepo.count() == 0) {
			
			throw new Exception ("No grades in DB");
			
		}
		
		ArrayList <Grade> resultFromDB = gradeRepo.FindByCourseTitle(title);
		
		if(resultFromDB.isEmpty()) {
			throw new Exception ("No linked grades to course");
		}
		
		return null;
	}

	@Override
	public ArrayList<Course> filterCourseByProfessorId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
