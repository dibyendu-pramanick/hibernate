package qcom.cas.hibernate.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@Column(name="address_id")
	private int id;
	
	@Column(name="place")
	private String place;
	
	//one to one mapping with foreign key association 
	/*@OneToOne(targetEntity=Student.class,cascade=CascadeType.ALL)
	@JoinColumn(name="s_id", referencedColumnName="student_id")
	private Student student;*/
	
	//one to one mapping with common join table
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="STUDENT_ADDRESS", joinColumns = @JoinColumn(name="ADD_ID"),
	inverseJoinColumns = @JoinColumn(name="STU_ID"))
	private Student student;*/
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Student student;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	

}
