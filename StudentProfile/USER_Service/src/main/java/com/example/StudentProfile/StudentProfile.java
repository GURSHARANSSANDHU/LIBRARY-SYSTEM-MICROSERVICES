package com.example.StudentProfile;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class StudentProfile {

	@Id
	private long rollno;

	private String student_Name;

	@OneToMany(targetEntity = Book.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "StudentID", referencedColumnName = "rollno")
	private List<Book> l1 = new ArrayList<>();

	private int no_of_books_issued;

	public int getNo_of_books_issued() {
		return no_of_books_issued;
	}

	public void setNo_of_books_issued(int no_of_books_issued) {
		this.no_of_books_issued = no_of_books_issued;
	}

	

	public String getStudent_Name() {
		return student_Name;
	}

	public void setStudent_Name(String student_Name) {
		this.student_Name = student_Name;
	}

	public long getRollno() {
		return rollno;
	}

	public void setRollno(long rollno) {
		this.rollno = rollno;
	}

	public List<Book> getL1() {
		return l1;
	}

	public void setL1(List<Book> l1) {
		this.l1 = l1;
	}

}
