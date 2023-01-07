package com.workshop.mongodb.repo;

public interface CustomAuthorRepo {
	
	void updateByEmail(String email, String name , String phone);
}
