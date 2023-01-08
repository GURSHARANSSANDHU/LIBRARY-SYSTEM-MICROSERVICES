package com.example.StudentProfile;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;


@Repository
public interface DAO extends JpaRepositoryImplementation<StudentProfile, Integer> 
{
	

}
