package com.demo.Dictionary.dao;

import java.util.List;

import com.demo.Dictionary.entities.Word;

public interface IWordDao {
	public Word save(Word word);
	public List<Word> getAll();
	public int deleteById(int id);
}
