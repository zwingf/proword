package com.proword.dao;

import java.util.List;

import com.proword.model.WordUser;

/**
 * 
 * @ClassName: WordUserDao
 * @Description: 用户和数据库访问接口
 * @author zhuweimin
 * @date 2017年9月22日 下午5:22:01
 *
 */
public interface WordUserDao {
	
	/** 用户列表 */
	List<WordUser> getUserList(WordUser wordUser);
	
	/** 检查用户名 */
	int getUserNameCount(String userName);

	/** 通过用户名字获取用户 */
	WordUser getUserByUserName(WordUser wordUser);

	/** 批量删除 */
	void deleteByIds(List<Integer> ids);

	/** 插入 */
	void addWordUser(WordUser wordUser);
	
	/** 修改 */
	void update(WordUser wordUser);

	/** 删除 */
	void delete(Integer id);

	/** 查找 */
	WordUser getWordUserById(Integer id);

}
