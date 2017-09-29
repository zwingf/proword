package com.proword.service;

import java.util.List;

import com.proword.model.WordDict;

/**
 * 
* @ClassName: WordDictService 
* @Description: 词库字典接口
* @author zhuweimin
* @date 2017年9月27日 下午3:05:48 
*
 */
public interface WordDictService {
	/**
	 * 
	* @Title: getWordDicts 
	* @Description: 获取词库字典列表
	* @return    
	* List<WordDict>    词库字典列表
	* @throws
	 */
	List<WordDict> getWordDicts();
}
