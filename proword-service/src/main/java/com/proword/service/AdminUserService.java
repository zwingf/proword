package com.proword.service;

import java.util.List;
import java.util.Map;

import com.proword.model.AdminUser;
import com.proword.service.BO.AdminUserBO;

/**
 * 
 * @ClassName: AdminUserService
 * @Description: 管理员接口
 * @author zhuweimin
 * @date 2017年9月22日 下午5:16:55
 *
 */
public interface AdminUserService {

	/**
	 * 
	* @Title: addAdminUser 
	* @Description: 添加管理员用户
	* @param adminUserBO    
	* void    
	* @throws
	 */
	void addAdminUser(AdminUserBO adminUserBO);

	/**
	 * 
	* @Title: update 
	* @Description: 更新管理员
	* @param adminUserBO    
	* void    
	* @throws
	 */
	void update(AdminUserBO adminUserBO);

	/**
	 * 
	* @Title: delete 
	* @Description: 删除
	* @param id    
	* void    
	* @throws
	 */
	void delete(Integer id);

	/**
	 * 
	* @Title: getAdminUser 
	* @Description: t通过管理员id查找
	* @param id 
	* @return    
	* AdminUser 管理员对象   
	* @throws
	 */
	AdminUser getAdminUser(Integer id);

	/**
	 * 
	* @Title: deleteByIds 
	* @Description: 批量删除
	* @param ids    要删除的管理员id
	* void    
	* @throws
	 */
	void deleteByIds(List<Integer> ids);

	/**
	 * 
	* @Title: getAdmins 
	* @Description: 获取管理员列表
	* @param adminUserBO
	* @return    
	* Map<String,Object>  返回带有分页信息 和管理员列表  
	* @throws
	 */
	Map<String, Object> getAdmins(AdminUserBO adminUserBO,Integer currentpage);
	
	/**
	 * 用户登录
	 * @param adminUserBO
	 * @return
	 */
	AdminUser adminUserLogin(AdminUserBO adminUserBO);
}
