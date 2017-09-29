package com.proword.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proword.dao.WordDictDao;
import com.proword.model.WordDict;
import com.proword.service.WordDictService;

/**
 * 
 * @ClassName: WordDictServiceImpl
 * @Description: 词库字典实现层
 * @author zhuweimin
 * @date 2017年9月27日 下午3:07:02
 *
 */
@Service
public class WordDictServiceImpl implements WordDictService {

	@Autowired
	private WordDictDao wordDictDao;

	/**
	 * 词库字典列表
	 */
	public List<WordDict> getWordDicts() {
		return wordDictDao.getWordDicts();
	}

}
