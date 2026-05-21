package lv.venta;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Course;
import lv.venta.model.Degree;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;

@SpringBootApplication
public class Seminar6Application {

	public static void main(String[] args) {
		SpringApplication.run(Seminar6Application.class, args);
		
		
	}
	
	@Bean
	public CommandLineRunner testData(IStudentRepo studentRepo, IProfessorRepo professorRepo, ICourseRepo courseRepo, IGradeRepo gradeRepo) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {

				Student student1 = new Student("John", "Safo");
				Student student2 = new Student("David", "Akimov");
				
			studentRepo.saveAll(Arrays.asList(student1, student2));

				Professor professor1 = new Professor("Karina", "Skirmante", Degree.master);	
				Professor professor2 = new Professor("Karlis", "Immers", Degree.doctor);
				professorRepo.saveAll(Arrays.asList(professor1, professor2));
				
				Course course1 = new Course("Java", 6, professor1);
				Course course2 = new Course("Operating Systems", 6, professor2);
				
				courseRepo.saveAll(Arrays.asList(course1, course2));
				
				Grade grade1 = new Grade(student1, course1, 8);
				Grade grade2 = new Grade(student2, course1, 9);
				Grade grade3 = new Grade(student1, course2, 7);
				Grade grade4 = new Grade(student2, course2, 10);
				
				
				gradeRepo.saveAll(Arrays.asList(grade1, grade2, grade3, grade4));
	

			}
		};
	}
	

	

}
