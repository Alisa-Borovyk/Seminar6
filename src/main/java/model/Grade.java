package model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Table(name = "GradeTable")
@Entity
public class Grade {
	
	@Column(name = "gid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int gId;
	
	@Column(name = "gradeValue")
	@Min(0)
	@Max(100)
	private int gradeValue;
	
	@ManyToOne
	@JoinColumn(name = "pid")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name = "cid")
	private Student student;

	public int getGradeValue() {
		return gradeValue;
	}

	public void setGradeValue(int gradeValue) {
		this.gradeValue = gradeValue;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	public Grade() {
		
	}
	
	public Grade(Student student, Course course, int gradeValue) {
		this.student = student;
		this.course = course;
		this.gradeValue = gradeValue;
	}

	public String toString() {
		return "Grade [gId=" + gId + ", gradeValue=" + gradeValue + "(" + student.getName() + " " + student.getSurname() + " - " + course.getTitle() + 
				")]";
		
}
	

}
