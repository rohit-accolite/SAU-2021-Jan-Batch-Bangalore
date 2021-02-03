package com.demo.Dictionary.crud.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dictionary.crud.services.IWordService;
import com.demo.Dictionary.dao.IWordDao;
import com.demo.Dictionary.entities.Word;

@Service
public class WordService implements IWordService {

	@Autowired
	IWordDao iWordDao;
	
	@Override
	public Word save(Word word) {
		return iWordDao.save(word);
	}
	
	@Override
	public List<Word> getAll() {
		return iWordDao.getAll();
	}

	@Override
	public int deleteById(int id) {
		return iWordDao.deleteById(id);
	}
	
}