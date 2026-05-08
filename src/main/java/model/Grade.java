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
	

}
