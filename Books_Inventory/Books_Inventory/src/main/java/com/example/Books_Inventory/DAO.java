package com.example.Books_Inventory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface DAO extends JpaRepositoryImplementation<BooksAvailable, String> 
{


	  public abstract List<BooksAvailable> findByNameAndQuantity(String name, int quantity);
	  
	  
	  @Query("select ba from BooksAvailable  ba")
	  public List<BooksAvailable> getAllBooksAvailable();
	  
	  
	  @Query("select u from BooksAvailable u where u.name =:n")
	  public BooksAvailable getOne(@Param("n") String name);
	  
	  
	  @Query(value = "select * from books_available" , nativeQuery = true)
	  public List <BooksAvailable> natFindAll();
}
