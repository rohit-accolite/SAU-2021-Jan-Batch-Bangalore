package com.demo.Dictionary.crud.services;

import java.util.List;

import com.demo.Dictionary.entities.Word;

public interface IWordService {
	public Word save(Word word) ;
	public List<Word> getAll();
	public int deleteById(int id);
	
}
