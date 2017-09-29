package com.proword.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proword.dao.WordDataDao;
import com.proword.mapper.WordDataMapper;
import com.proword.model.WordData;
import com.proword.model.WordDataExample;

/**
 * 
* @ClassName: WordDataDaoImpl 
* @Description: 词组实现接口
* @author zhuweimin
* @date 2017年9月27日 上午10:09:44 
*
 */
@Repository
public class WordDataDaoImpl implements WordDataDao {
	
	@Autowired
	private WordDataMapper wordDataMapper;
	
	public void deleteByIds(List<Integer> ids) {
		try {
			WordDataExample example = new  WordDataExample();
			example.createCriteria().andIdIn(ids);			
			wordDataMapper.deleteByExample(example);
		} catch (Exception e) {
			throw new RuntimeException("操作失败");
		}
	}
	/**
	 * 添加词组
	 */
	public void addWordData(WordData wordData) {
		try {
			wordDataMapper.insert(wordData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 更新词组
	 */
	public void update(WordData wordData) {
		
		try {
			wordDataMapper.updateByPrimaryKey(wordData);
		} catch (Exception e) {
			throw new RuntimeException("更新失败");
		}

	}
	
	/**
	 * 删除词组
	 */
	public void delete(Integer id) {
		try {
			wordDataMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			throw new RuntimeException("删除失败");
		}

	}

	/**
	 * 获取词组 此方方法返回结果有可能是null值。
	 */
	public WordData getWordDataById(Integer id) {
		WordDataExample example = new WordDataExample();
		example.createCriteria().andIdEqualTo(id);
		try {
			return wordDataMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			throw new RuntimeException("查询失败");
		}
		 
	}
	
	public List<WordData> getWordDatas(WordData wordData) {
		WordDataExample example = new WordDataExample();
		example.createCriteria().andGroupWordEqualTo(wordData.getGroupWord());		

		try {
			return wordDataMapper.selectByExample(example);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败");
		}
	}
	
	public List<WordData> getWordList(String wordType) {
		
		WordDataExample wordDataExample = new WordDataExample();
		wordDataExample.createCriteria().andWordTypeEqualTo(wordType);
		
		try {
			return wordDataMapper.selectByExample(wordDataExample);
		} catch (Exception e) {
			throw new RuntimeException("查询失败");
		}
	}
	
}
