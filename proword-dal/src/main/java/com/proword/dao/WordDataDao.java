package com.proword.dao;

import java.util.List;

import com.proword.model.WordData;

/**
 * 
 * @ClassName: WordDataDao
 * @Description: 词组和数据库访问接口
 * @author zhuweimin
 * @date 2017年9月22日 下午5:21:26
 *
 */
public interface WordDataDao {

	/**
	 * 
	* @Title: getWordDatas 
	* @Description: 获取词组列表
	* @param wordData
	* @return    
	* List<WordData>    返回词组列表
	* @throws
	 */
	List<WordData> getWordDatas(WordData wordData);

	/**
	 * 
	* @Title: deleteByIds 
	* @Description: 批量删除
	* @param id    词组id
	* void    
	* @throws
	 */
	void deleteByIds(List<Integer> id);

	/**
	 * 
	* @Title: addWordData 
	* @Description: c插入词组 
	* @param wordData    
	* void    
	* @throws
	 */
	void addWordData(WordData wordData);

	/**
	 * 
	* @Title: update 
	* @Description: 修改词组 
	* @param wordData    
	* void    
	* @throws
	 */
	void update(WordData wordData);

	/**
	 * 
	* @Title: delete 
	* @Description: 删除词组 
	* @param id    词组id
	* void    
	* @throws
	 */
	void delete(Integer id);

	/**
	 * 
	* @Title: getWordDataById 
	* @Description: 通过词组id获取词组 
	* @param id 词组id
	* @return    
	* WordData    返回词组对象
	* @throws
	 */
	WordData getWordDataById(Integer id);
	
	/**
	 * 
	* @Title: getWordList 
	* @Description: 所有词组信息
	* @return    
	* List<WordData>    
	* @throws
	 */
	List<WordData> getWordList(String wordType);
	
}
