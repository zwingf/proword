package com.proword.dao;

import java.util.List;

import com.proword.model.WordDict;

/**
 * 
* @ClassName: WordDictDao 
* @Description: 字典表
* @author zhuweimin
* @date 2017年9月27日 下午2:47:41 
*
 */
public interface WordDictDao {

	/** 
	 * 
	* @Title: getWordDicts 
	* @Description: 字典列表
	* @return    
	* List<WordDict>    
	* @throws
	 */
	List<WordDict> getWordDicts();
	
}
