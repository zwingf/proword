package com.proword.facade;

import java.util.HashMap;
import java.util.List;

import com.proword.facade.pojo.BsnsBrowserResultForJsonVO;
import com.proword.facade.pojo.WordDataPojo;
import com.proword.model.WordData;

/**
 * 
 * @ClassName: WordDataFacade
 * @Description: 词组门面层
 * @author zhuweimin
 * @date 2017年9月27日 下午1:28:24
 *
 */
public interface WordDataFacade {
	
	/**
	 * 
	* @Title: addWordData 
	* @Description: 添加
	* @param wordDataPojo 词组实体    
	* void    
	* @throws
	 */
	void addWordData(WordDataPojo wordDataPojo);

	/**
	 * 
	* @Title: updateWordData 
	* @Description: 修改词组
	* @param wordDataPojo 词组实体
	* void    
	* @throws
	 */
	void updateWordData(WordDataPojo wordDataPojo);

	/**
	 * 
	* @Title: deleteWordData 
	* @Description: 通过id删除词组
	* @param id    词组id
	* void    
	* @throws
	 */
	void deleteWordData(Integer id);

	/**
	 * 
	* @Title: getWordDataById 
	* @Description: 通过id查找词组
	* @param id 词组id
	* @return    
	* WordData    
	* @throws
	 */
	WordData getWordDataById(Integer id);
	
	/**
	 * 
	* @Title: deleteByIds 
	* @Description: 通过词组id 批量删除 
	* @param ids    要删除的词组的id
	* void    
	* @throws
	 */
	void deleteByIds(List<Integer> ids);

	/**
	 * @param currentpage 
	 * 
	* @Title: getWordDatas 
	* @Description: 获取词组的列表
	* @param wordDataPojo
	* @return    
	* HashMap<String,Object>  返回词组列表 和分页信息  
	* @throws
	 */
	HashMap<String, Object> getWordDatas(WordDataPojo wordDataPojo, Integer currentpage);
	
	/**
	 * 
	* @Title: getWordList 
	* @Description: 获取词组列表
	* @return    
	* BsnsBrowserResultForJsonVO    
	* @throws
	 */
	BsnsBrowserResultForJsonVO getWordList(String wordType);
}
