package com.example.StudentProfile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Serve 
{
	
	@Autowired
	private DAO dao;
	
	
	
	
	public List <StudentProfile> getAll()
	
	{
		return this.dao.findAll();
	}



   
	public void insertOne(StudentProfile s) {
		// TODO Auto-generated method stub
		this.dao.save(s);
		
	}
	public void updateAdd(int rollno, Book b1)
	{
		List <StudentProfile> l1 = this.dao.findAll();
		StudentProfile c = null;
		for(StudentProfile s : l1)
		{
			if(s.getRollno() == rollno)
			{
				c = s;
				break;
			}
		}
		c.getL1().add(b1);
		c.setNo_of_books_issued(c.getNo_of_books_issued() + 1);
		this.dao.save(c);
		
	}




	public StudentProfile readOne(int rollno) {
		// TODO Auto-generated method stub
		List <StudentProfile> l1 = this.dao.findAll();
		StudentProfile c = null;
		for(StudentProfile s : l1)
		{
			if(s.getRollno() == rollno)
			{
				c = s;
				break;
			}
		}
		return c;
	}
	
	
	public int updateSub(int rollno, Book b1)
	{
		int flag = 0;
		List <StudentProfile> l1 = this.dao.findAll();
		StudentProfile c = null;
		for(StudentProfile s : l1)
		{
			if(s.getRollno() == rollno)
			{
				c = s;
				
				break;
			}
		}
		int i = 0;
		for(Book b2 : c.getL1())
		{
			if(b2.getName().equals(b1.getName()))
					{
				c.getL1().remove(i);
				c.setNo_of_books_issued(c.getNo_of_books_issued() - 1);
				flag = 1;
				
				     break;       
					}
			else
			{
				i = i+1;
			}
		}
		
		this.dao.save(c);
		return flag;
	}
	

}
