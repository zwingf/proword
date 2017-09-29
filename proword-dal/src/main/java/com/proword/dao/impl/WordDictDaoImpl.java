package com.proword.dao.impl;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proword.dao.WordDictDao;
import com.proword.mapper.WordDictMapper;
import com.proword.model.WordDict;
import com.proword.model.WordDictExample;

/**
 * 
 * @ClassName: WordDictDaoImpl
 * @Description: 词库字典实现层
 * @author zhuweimin
 * @date 2017年9月27日 下午2:49:54
 *
 */
@Repository
public class WordDictDaoImpl implements WordDictDao {
		
	@Autowired
	private WordDictMapper wordDictMapper;
	
	public List<WordDict> getWordDicts() {
		
		WordDictExample example = new WordDictExample();
		
		try{
			return wordDictMapper.selectByExample(example);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("数据库查询一场");
		}

	}

}
