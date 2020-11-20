package com.tutorialtwo.tutorialtwo.service;

import com.tutorialtwo.tutorialtwo.entity.Faculty;

import java.util.List;

public interface FacultyService {

	List<Faculty> findAll();
	Faculty findById(int theId);
	
	void save(Faculty theFaculty);
	
	void deleteById (int theId);
	
}
