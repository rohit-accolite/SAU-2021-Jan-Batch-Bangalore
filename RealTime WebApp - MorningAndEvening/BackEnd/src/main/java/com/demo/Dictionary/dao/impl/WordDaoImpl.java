package com.demo.Dictionary.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.demo.Dictionary.dao.IWordDao;
import com.demo.Dictionary.entities.Word;

@Repository
public class WordDaoImpl implements IWordDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Word save(Word word) {
		final KeyHolder holder = new GeneratedKeyHolder();
		String sql = "INSERT INTO WORDS ( WORD , MEANING , PART_OF_SPEECH , EXAMPLE , CREATION_TM , LAST_MODIFIED_TM ) "
				+ " VALUES ( :WORD , :MEANING , :PART_OF_SPEECH , :EXAMPLE , :CREATION_TM , :LAST_MODIFIED_TM )";
		MapSqlParameterSource srcMap = new MapSqlParameterSource();
		srcMap.addValue("WORD", word.getWord());
		srcMap.addValue("MEANING", word.getMeaning());
		srcMap.addValue("PART_OF_SPEECH", word.getPartOfSpeech());
		srcMap.addValue("EXAMPLE", word.getExample());
		srcMap.addValue("CREATION_TM", word.getCreationTm());
		srcMap.addValue("LAST_MODIFIED_TM", word.getLastModifiedTm());

		namedParameterJdbcTemplate.update(sql, srcMap, holder, new String[] { "ID" });
		word.setId(holder.getKey().intValue());
		return word;
	}

	@Override
	public List<Word> getAll() {
		String sql = "select * from WORDS";
		return namedParameterJdbcTemplate.query(sql, (resultSet, rowNum) -> {
			Word word = new Word();
			word.setId(resultSet.getInt("ID"));
			word.setCreationTm(resultSet.getDate("CREATION_TM"));
			word.setExample(resultSet.getString("EXAMPLE"));
			word.setLastModifiedTm(resultSet.getDate("LAST_MODIFIED_TM"));
			word.setMeaning(resultSet.getString("MEANING"));
			word.setPartOfSpeech(resultSet.getString("PART_OF_SPEECH"));
			word.setWord(resultSet.getString("WORD"));
			return word;
		});
	}

	@Override
	public int deleteById(int id) {
		String sql = "DELETE FROM WORDS WHERE id = :id";
		MapSqlParameterSource srcMap = new MapSqlParameterSource();
		srcMap.addValue("id", id);
		return namedParameterJdbcTemplate.update(sql, srcMap);
	}
}
