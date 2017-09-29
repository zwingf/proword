package com.proword.facade;

import java.util.List;

import com.proword.facade.pojo.WordUserPojo;
import com.proword.model.WordUser;

/**
 * 
 * @ClassName: WordUserFacade
 * @Description: 用户门面层
 * @author zhuweimin
 * @date 2017年9月27日 上午11:55:14
 *
 */

public interface WordUserFacade {

	/**
	 * 
	* @Title: addWordUser 
	* @Description: 添加用户
	* @param wordUserPojo    
	* void    
	* @throws
	 */
	void addWordUser(WordUserPojo wordUserPojo);

	/**
	 * 
	* @Title: updateWordUser 
	* @Description: 修改用户
	* @param wordUserPojo    
	* void    
	* @throws
	 */
	void updateWordUser(WordUserPojo wordUserPojo);

	/**
	 * 
	* @Title: deleteWordUser 
	* @Description: 通过id删除
	* @param id    用户id
	* void    
	* @throws
	 */
	void deleteWordUser(Integer id);

	/**
	 * 
	* @Title: getWordUSerById 
	* @Description: 通过id查找
	* @param id 用户id
	* @return    
	* WordUser    用户实体对象
	* @throws
	 */
	WordUser getWordUSerById(Integer id);
	
	/**
	 * 
	* @Title: deleteByIds 
	* @Description: 批量删除
	* @param ids    
	* void    
	* @throws
	 */
	void deleteByIds(List<Integer> ids);
}
