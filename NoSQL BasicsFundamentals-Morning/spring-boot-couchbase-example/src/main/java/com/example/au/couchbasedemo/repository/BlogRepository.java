package com.example.au.couchbasedemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.au.couchbasedemo.model.Blogs;

public interface BlogRepository extends CrudRepository<Blogs, String> {
	
	Blogs findByAuthor(String author);

	List<Blogs> deleteBytopicAndAuthor(String title, String author);
	
	List<Blogs> getByTags(String tag1, String tag2);
	   
}