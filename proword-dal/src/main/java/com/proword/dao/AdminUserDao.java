package com.proword.dao;

import java.util.List;

import com.proword.model.AdminUser;

/**
 * 
 * @ClassName: AdminUserDao
 * @Description: 管理员和数据库交互接口
 * @author zhuweimin
 * @date 2017年9月22日 下午5:20:14
 *
 */
public interface AdminUserDao {
	
	/**
	 * 通过用户名查找用户
	 * 
	 * @param adminUserName
	 * @return
	 */
	List<AdminUser> getAdminUserByName(String adminUserName);

	/**
	 * 
	 * @Title: getAllAdmin @Description: 管理员列表 @param adminUser @return
	 * List<AdminUser> 返回管理员列表 @throws
	 */
	List<AdminUser> getAllAdmin(AdminUser adminUser);

	/**
	 * 
	 * @Title: deletebyIds @Description: 批量删除 @param ids void 需要删除的id @throws
	 */
	void deletebyIds(List<Integer> ids);

	/**
	 * 
	 * @Title: addAdminUser @Description: 添加管理员 @param adminUser void @throws
	 */
	void addAdminUser(AdminUser adminUser);

	/**
	 * 
	 * @Title: update @Description: 更新管理员 @param adminUser void @throws
	 */
	void update(AdminUser adminUser);

	/**
	 * 
	 * @Title: delete @Description: 删除管理员 @param id void @throws
	 */
	void delete(Integer id);

	/**
	 * 
	 * @Title: getAdminUserById @Description: 通过管理员id获取管理员 @param id @return
	 * AdminUser 返回管理员对象 @throws
	 */
	AdminUser getAdminUserById(Integer id);

}
