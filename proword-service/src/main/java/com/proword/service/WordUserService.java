package com.proword.service;

import org.springframework.stereotype.Service;

import com.proword.model.WordUser;
import com.proword.service.BO.WordUserBO;

/**
 * 
 * @ClassName: WordUserService
 * @Description: 用户的service接口层
 * @author zhuweimin
 * @date 2017年9月27日 下午12:00:44
 *
 */
@Service
public interface WordUserService {
	
	/** 
	 * 
	* @Title: addWordUser 
	* @Description: 添加用户
	* @param wordUserBO    
	* void    
	* @throws
	 */
	void addWordUser(WordUserBO wordUserBO);

	/** 
	 * 
	* @Title: update 
	* @Description: 更新用户通过id
	* @param wordUserBO    
	* void    
	* @throws
	 */
	void update(WordUserBO wordUserBO);

	/** 
	 * 
	* @Title: delete 
	* @Description: 删除用户通过id
	* @param id    
	* void    
	* @throws
	 */
	void delete(Integer id);

	/** 
	 * 
	* @Title: getWordUser 
	* @Description: 查找用户 通过id
	* @param id
	* @return    
	* WordUser   用户的对象 
	* @throws
	 */

	WordUser getWordUser(Integer id);
}
