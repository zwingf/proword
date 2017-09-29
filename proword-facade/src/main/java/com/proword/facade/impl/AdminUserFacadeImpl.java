package com.proword.facade.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proword.facade.AdminUserFacade;
import com.proword.facade.pojo.AdminUserPojo;
import com.proword.model.AdminUser;
import com.proword.service.AdminUserService;
import com.proword.service.BO.AdminUserBO;

/**
 * 
 * @ClassName: AdminUserFacadeImpl
 * @Description: 管理员门面实现层
 * @author zhuweimin
 * @date 2017年9月27日 上午10:34:17
 *
 */
@Component
public class AdminUserFacadeImpl implements AdminUserFacade {

	@Autowired
	private AdminUserService adminUserService;

	/**
	 * 添加管理员
	 */
	public void addAdminUser(AdminUserPojo adminUserPojo) {
		AdminUserBO adminUserBO = new AdminUserBO();
		adminUserBO.setAdminName(adminUserPojo.getAdminName());
		adminUserBO.setAdminPassword(adminUserPojo.getAdminPassword());
		adminUserService.addAdminUser(adminUserBO);
	}

	/**
	 * 更新
	 */
	public void updateAdminUser(AdminUserPojo adminUserPojo) {
		AdminUserBO adminUserBO = new AdminUserBO();
		adminUserBO.setAdminName(adminUserPojo.getAdminName());
		adminUserBO.setAdminPassword(adminUserPojo.getAdminPassword());
		adminUserService.update(adminUserBO);

	}

	/**
	 * 删除
	 */
	public void deleteAdminUser(Integer id) {
		adminUserService.delete(id);
	}

	/**
	 * 查找
	 */
	public AdminUser getAdminUSerById(Integer id) {
		return adminUserService.getAdminUser(id);

	}
	
	public AdminUser adminUserLogin(String userName, String password) {
		
		AdminUserBO adminUserBO = new AdminUserBO();

		adminUserBO.setAdminName(userName);
		adminUserBO.setAdminPassword(password);
		
		return adminUserService.adminUserLogin(adminUserBO);
				
	}

	/**
	 * 批量删除
	 */
	public void deleteByIds(List<Integer> ids) {
		adminUserService.deleteByIds(ids);
	}
	
	public Map<String, Object> getAdmins(AdminUserPojo adminUserPojo,Integer currentpage) {
		AdminUserBO adminUserBO = new AdminUserBO();
		adminUserBO.setAdminName(adminUserPojo.getAdminName());
		Map<String, Object> admins = adminUserService.getAdmins(adminUserBO,currentpage);
		return admins;
	}

}
