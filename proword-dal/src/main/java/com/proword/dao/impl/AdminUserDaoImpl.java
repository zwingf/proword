package com.proword.dao.impl;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proword.dao.AdminUserDao;
import com.proword.mapper.AdminUserMapper;
import com.proword.model.AdminUser;
import com.proword.model.AdminUserExample;
import com.proword.util.ContentUtil;

/**
 * 
 * @ClassName: AdminUserDaoImpl
 * @Description: 管理员接口实现
 * @author zhuweimin
 * @date 2017年9月27日 上午9:42:11
 *
 */
@Repository
public class AdminUserDaoImpl implements AdminUserDao {
	
	private Log log = LogFactory.getLog(AdminUserDaoImpl.class);
	
	@Autowired
	private AdminUserMapper adminUserMapper;

	/**
	 * 批量删除
	 */
	public void deletebyIds(List<Integer> ids) {
		
		AdminUserExample example = new AdminUserExample();
		example.createCriteria().andIdIn(ids);
		try {
			adminUserMapper.deleteByExample(example);			
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException("数据库删除失败");
		}

	}

	public List<AdminUser> getAllAdmin(AdminUser adminUser) {
		AdminUserExample example = new AdminUserExample();
		if(adminUser.getAdminName() != null && !"".equals(adminUser.getAdminName())){	
			example.createCriteria().andAdminNameLike(adminUser.getAdminName());
		}
		
		try {
			return adminUserMapper.selectByExample(example);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException("查询数据失败");
		}
	} 

	/**
	 * 添加
	 */
	public void addAdminUser(AdminUser adminUser) {
		try {
			adminUserMapper.insert(adminUser);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException("数据库添加失败");
		}
	}

	/**
	 * 修改
	 */
	public void update(AdminUser adminUser) {		
		try {
			adminUserMapper.updateByPrimaryKey(adminUser);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException("服务原因，修改失败！");
		}
	}

	/**
	 * 删除
	 */
	public void delete(Integer id) {
		try {
			adminUserMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException("服务原因，删除失败！");
		}
	}

	/**
	 * 根据id获取管理员 此方法有可能返回null值 。
	 */
	public AdminUser getAdminUserById(Integer id) {
		AdminUserExample example = new AdminUserExample();
		example.createCriteria().andIdEqualTo(id);
		try {
			return adminUserMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException("没有查到相关的管理员信息！");
		}
	}

	
	/* (non-Javadoc)
	 * @see com.proword.dao.AdminUserDao#getAdminUserByName(java.lang.String)
	 */
	public List<AdminUser> getAdminUserByName(String adminUserName) {
		AdminUserExample example = new AdminUserExample();
		
		example.createCriteria().andAdminNameEqualTo(adminUserName);
		try {
			return adminUserMapper.selectByExample(example);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException("通过用户名查找用户出现异常");
		}
	}

}
