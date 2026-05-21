package lv.venta.model;



import java.util.Collection;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Table(name = "CourseTable")
@Entity

public class Course {
	

	@Column(name = "cid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	
	@Column(name = "Title")
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Za-z ]{3,50}", message = "Title must start with a capital letter and be between 3 and 40 characters long")
	private String title;

	@Column(name = "CreditPoints")
	@Min(0)
	@Max(30)
	private int creditPoints;
	
	@ManyToOne
	@JoinColumn(name = "pid")
	private Professor professor;
	
	@OneToMany(mappedBy = "course")
	private Collection<Grade> grades;

	//getters and setters	
	public int getCid() {
		return cid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCreditPoints() {
		return creditPoints;
	}

	public void setCreditPoints(int creditPoints) {
		this.creditPoints = creditPoints;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	//constructors
	
	public Course() {}
	public Course(String title, int creditPoints, Professor professor) {
		setTitle(title);
		setCreditPoints(creditPoints);
		setProfessor(professor);
		
	}
	
	//toString
public String toString() {
	return "Course [title=" + title + ", creditPoints=" + creditPoints + ", professor=" + professor
			+ "]";
}

}
