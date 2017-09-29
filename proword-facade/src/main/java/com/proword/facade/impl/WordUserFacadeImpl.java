package com.proword.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proword.facade.WordUserFacade;
import com.proword.facade.pojo.WordUserPojo;
import com.proword.model.WordUser;
import com.proword.service.WordUserService;
import com.proword.service.BO.WordUserBO;

/**
 * 
 * @ClassName: WordUserFacadeImpl
 * @Description: 用户门面的实现层
 * @author zhuweimin
 * @date 2017年9月27日 上午11:58:59
 *
 */
@Component
public class WordUserFacadeImpl implements WordUserFacade {

	@Autowired
	private WordUserService wordUserService;

	/**
	 * 添加用户
	 */
	public void addWordUser(WordUserPojo wordUserPojo) {
		WordUserBO wordUserBO = new WordUserBO();
		wordUserService.addWordUser(wordUserBO);

	}

	/**
	 * 更新
	 */
	public void updateWordUser(WordUserPojo wordUserPojo) {
		WordUserBO wordUserBO = new WordUserBO();
		wordUserService.update(wordUserBO);

	}

	/**
	 * 删除
	 */
	public void deleteWordUser(Integer id) {
		wordUserService.delete(id);

	}

	/**
	 * 查找
	 */
	public WordUser getWordUSerById(Integer id) {
		return wordUserService.getWordUser(id);

	}

	public void deleteByIds(List<Integer> ids) {
		// TODO Auto-generated method stub
		
	}

}
