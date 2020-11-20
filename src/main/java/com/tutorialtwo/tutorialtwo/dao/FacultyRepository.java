package com.tutorialtwo.tutorialtwo.dao;

import com.tutorialtwo.tutorialtwo.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

	
	
	//Method to sort the results by last name asc
	List<Faculty>findAllByOrderByLastNameAsc();
	
	
}
