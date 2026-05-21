package lv.venta.model;

import java.util.Collection;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


@Table(name = "ProfessorTable")
@Entity
public class Professor {
	
	
	@Column(name = "pid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pId;
	
	
	@Column(name = "Name")
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,40}", message = "Name must start with a capital letter and be between 3 and 40 characters long")
	private String name;
	
	@Column(name = "Surname")
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,40}", message = "Name must start with a capital letter and be between 3 and 40 characters long")
	private String surname;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Degree")
	@NotNull
	private Degree degree;
	
	
	@OneToMany(mappedBy = "professor")
	private Collection<Course> courses;
	

	public int getpId() {
		return pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	
	
	//constructor

	public Professor() {}
	
	public Professor(String name, String surname, Degree degree) {
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}
	
//toString
	public String toString() {
		return "Professor [pId=" + pId + ", name=" + name + ", surname=" + surname + ", degree=" + degree + "]";
	}
	
}
