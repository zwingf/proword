package com.proword.facade;

import java.util.List;
import java.util.Map;

import com.proword.facade.pojo.AdminUserPojo;
import com.proword.model.AdminUser;
/**
 * 
* @ClassName: AdminUserFacade 
* @Description: 管理员门面层
* @author zhuweimin
* @date 2017年9月27日 上午10:32:52 
*
 */
public interface AdminUserFacade {
	
	/**
	 * 
	* @Title: addAdminUser 
	* @Description: 添加
	* @param adminUserPojo 管理员对象实体    
	* void    
	* @throws
	 */
	void addAdminUser(AdminUserPojo adminUserPojo);

	/**
	 * 
	* @Title: updateAdminUser 
	* @Description: 修改
	* @param adminUserPojo  管理员对象实体 
	* void    
	* @throws
	 */
	void updateAdminUser(AdminUserPojo adminUserPojo);

	/**
	 * 
	* @Title: deleteAdminUser 
	* @Description: 删除 
	* @param id    管理员id
	* void    
	* @throws
	 */
	void deleteAdminUser(Integer id);

	/**
	 * 
	* @Title: getAdminUSerById 
	* @Description: 通过id查找管理员 
	* @param id 管理员id
	* @return    
	* AdminUser    
	* @throws
	 */
	AdminUser getAdminUSerById(Integer id);
	
	/**
	 * 
	* @Title: deleteByIds 
	* @Description: 批量删除
	* @param ids    管理员的id
	* void    
	* @throws
	 */
	void deleteByIds(List<Integer> ids);
	
	/**
	 * 
	* @Title: getAdmins 
	* @Description: 管理员列表
	* @param adminUserPojo 管理员实体
	* @return    
	* Map<String,Object>  包括管理员列表的和分页信息   
	* @throws
	 */
	Map<String, Object> getAdmins(AdminUserPojo adminUserPojo,Integer currentpage);
	
	/**
	 * 用户登录
	 * @param userName 用户名
	 * @param password 密码
	 * @return
	 */
	AdminUser adminUserLogin(String userName,String password);
}
