package com.proword.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proword.dao.WordUserDao;
import com.proword.mapper.WordUserMapper;
import com.proword.model.WordUser;
import com.proword.model.WordUserExample;

/**
 * 
 * @ClassName: WordUserDaoImpl
 * @Description: 用户和数据库接口实现层
 * @author zhuweimin
 * @date 2017年9月27日 上午11:51:57
 *
 */
@Repository
public class WordUserDaoImpl implements WordUserDao {

	@Autowired
	private WordUserMapper wordUserMapper;

	public int getUserNameCount(String userName) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deleteByIds(List<Integer> ids) {
		// TODO Auto-generated method stub

	}


	public void addWordUser(WordUser wordUser) {

	}

	/**
	 * 更新
	 */
	public void update(WordUser wordUser) {

	}

	/**
	 * 删除
	 */
	public void delete(Integer id) {


	}

	/**
	 * 获取用户 此方法有可能返回null值。
	 */
	public WordUser getWordUserById(Integer id) {

		return null;
	}

	public List<WordUser> getUserList(WordUser wordUser) {
		return null;
	}

	public WordUser getUserByUserName(WordUser wordUser) {
		return null;
	}

}
