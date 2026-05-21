package lv.venta.model;

import java.util.Collection;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Table(name = "StudentTable")
@Entity
public class Student {
	
	@Column(name = "sid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	

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

	
	//@ManyToMany
	@OneToMany(mappedBy = "student")
	private Collection<Grade> courses;

	public int getSid() {
		return sid;
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

	//constructors
	
	public Student() {}
	
	public Student(String name, String surname) {
	setName(name);
	setSurname(surname);
		
	}

	
	//toString
	public String toString() {
		return "Student [Sid=" + sid + ", name=" + name + ", surname=" + surname + "]";
	}
}
