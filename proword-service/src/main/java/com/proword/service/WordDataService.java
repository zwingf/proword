package com.proword.service;

import java.util.HashMap;
import java.util.List;

import com.proword.model.WordData;
import com.proword.service.BO.WordDataBO;
import com.proword.util.PageEntity;
import com.proword.util.page.PaginationSupport;

/**
 * 
 * @ClassName: WordDataService
 * @Description: 词组接口层
 * @author zhuweimin
 * @date 2017年9月27日 下午1:41:59
 *
 */
public interface WordDataService {

	/**
	 * 
	* @Title: getWordData 
	* @Description: 获取词组
	* @param id 词组id
	* @return    
	* WordData    词组对象
	* @throws
	 */
	WordData getWordData(Integer id);

	/**
	 * 
	* @Title: delete 
	* @Description: 删除
	* @param id    
	* void    
	* @throws
	 */
	void delete(Integer id);

	/** 
	 * 
	* @Title: update 
	* @Description: 更新 
	* @param wordDataBO    
	* void    
	* @throws
	 */
	void update(WordDataBO wordDataBO);

	/** 
	 * 
	* @Title: addWordData 
	* @Description: 添加
	* @param wordDataBO    
	* void    
	* @throws
	 */
	void addWordData(WordDataBO wordDataBO);
	/**
	 * 
	* @Title: deleteByIds 
	* @Description: 批量删除 
	* @param ids    
	* void    
	* @throws
	 */
	void deleteByIds(List<Integer> ids);
	/**
	 * @param currentpage 
	 * 
	* @Title: getDataList 
	* @Description: 获取词组列表并且分页 
	* @param wordDataBO
	* @return    
	* HashMap<String, Object>    分页信息和词组列表
	* @throws
	 */
	HashMap<String, Object> getDataList(WordDataBO wordDataBO, Integer currentpage);
	/**
	 * 
	* @Title: getWordList 
	* @Description: 所有词组
	* @return    
	* List<WordData>    
	* @throws
	 */
	List<WordData> getWordList(String wordType);

}
