package com.proword.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proword.dao.WordUserDao;
import com.proword.model.WordUser;
import com.proword.service.WordUserService;
import com.proword.service.BO.WordUserBO;

@Service
public class WordUserServiceImpl implements WordUserService {

	@Autowired
	private WordUserDao wordUserDao;

	/**
	 * 
	 * @Title: addWordUser @Description: 添加用户 @param wordUserBO void @throws
	 */
	public void addWordUser(WordUserBO wordUserBO) {
		wordUserBO.checkWordUser();
		WordUser wordUser = new WordUser();
		wordUser.setId(wordUserBO.getId());
		wordUser.setUserName(wordUserBO.getUserName());
		wordUser.setUserPassword(wordUserBO.getUserPassword());
		WordUser user = wordUserDao.getUserByUserName(wordUser);
		if (user != null) {
			new Exception("用户名已经存在，请重新填写！");
		}
		wordUserDao.addWordUser(wordUser);
	}

	/**
	 * 更新
	 */
	public void update(WordUserBO wordUserBO) {
		wordUserBO.checkWordUser();
		WordUser wordUser = new WordUser();
		wordUser.setId(wordUserBO.getId());
		wordUser.setUserName(wordUserBO.getUserName());
		wordUser.setUserPassword(wordUserBO.getUserPassword());
		WordUser user = wordUserDao.getUserByUserName(wordUser);
		if (user != null) {
			new Exception("用户名已经存在，请重新填写！");
		}
		wordUserDao.update(wordUser);
	}

	/**
	 * 删除
	 */
	public void delete(Integer id) {
		if (null == id) {
			new Exception("id 不能为空！");
		}
		wordUserDao.delete(id);

	}

	/**
	 * 查找
	 */
	public WordUser getWordUser(Integer id) {
		if (null == id) {
			new Exception("id 不能为空！");
		}
		return wordUserDao.getWordUserById(id);
	}

}
