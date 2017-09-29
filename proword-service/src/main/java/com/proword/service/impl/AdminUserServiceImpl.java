package com.proword.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.proword.dao.AdminUserDao;
import com.proword.model.AdminUser;
import com.proword.service.AdminUserService;
import com.proword.service.BO.AdminUserBO;
import com.proword.util.ContentUtil;
import com.proword.util.PageEntity;
import com.proword.util.page.PageUtil;
import com.proword.util.page.PageUtils;
import com.proword.util.page.PaginationSupport;

/**
 * 
 * @ClassName: AdminUserServiceImpl
 * @Description: 管理员用户接口实现层
 * @author zhuweimin
 * @date 2017年9月27日 下午3:09:17
 *
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private AdminUserDao adminUserDao;

	/**
	 * 添加
	 */
	public void addAdminUser(AdminUserBO adminUserBO) {
		adminUserBO.checkAdminUser();
		if(adminUserBO.getAdminName().length() < ContentUtil.NAME_MIN_LENGTH) {
			throw new RuntimeException("请输入大于六位小于八位的管理员名字！请重新填写！");
		}
		if(adminUserBO.getAdminPassword().length() < ContentUtil.PASSWORD_MIN_LENGTH) {
			throw new RuntimeException("请输入大于六位小于十八位的管理员密码！请重新填写！");
		}
		if(adminUserBO.getAdminName().length() > ContentUtil.NAME_MAX_LENGTH) {
			throw new RuntimeException("请输入大于六位小于八位的管理员名字！请重新填写！");
		}
		if(adminUserBO.getAdminPassword().length() > ContentUtil.PASSWORD_MAX_LENGTH) {
			throw new RuntimeException("请输入大于六位小于十八位的管理员密码！请重新填写！");
		}
		
		AdminUser adminUser = new AdminUser();
		adminUser.setId(adminUserBO.getId());
		adminUser.setAdminName(adminUserBO.getAdminName());
		adminUser.setAdminPassword(adminUserBO.getAdminPassword());
		List<AdminUser> adminUserList = adminUserDao.getAdminUserByName(adminUserBO.getAdminName());
		
		
		if (adminUserList != null || adminUserList.size() > 0) {
			throw new RuntimeException("此管理员名字已经存在！请重新填写！");
		}
		adminUserDao.addAdminUser(adminUser);
	}

	/**
	 * 更新
	 */
	public void update(AdminUserBO adminUserBO) {
		adminUserBO.checkId();
		if(adminUserBO.getAdminName().length() < ContentUtil.NAME_MIN_LENGTH) {
			throw new RuntimeException("请输入大于六位小于八位的管理员名字！请重新填写！");
		}
		if(adminUserBO.getAdminPassword().length() < ContentUtil.PASSWORD_MIN_LENGTH) {
			throw new RuntimeException("请输入大于六位小于十八位的管理员密码！请重新填写！");
		}
		if(adminUserBO.getAdminName().length() > ContentUtil.NAME_MAX_LENGTH) {
			throw new RuntimeException("请输入大于六位小于八位的管理员名字！请重新填写！");
		}
		if(adminUserBO.getAdminPassword().length() > ContentUtil.PASSWORD_MAX_LENGTH) {
			throw new RuntimeException("请输入大于六位小于十八位的管理员密码！请重新填写！");
		}
		
		AdminUser adminUser = new AdminUser();
		adminUser.setId(adminUserBO.getId());
		adminUser.setAdminName(adminUserBO.getAdminName());
		adminUser.setAdminPassword(adminUserBO.getAdminPassword());		
		
		
		AdminUser dbAdminUser = adminUserDao.getAdminUserById(adminUser.getId());
		
		if(!dbAdminUser.getAdminName().equals(adminUser.getAdminName())){
			List<AdminUser> adminUsers = adminUserDao.getAdminUserByName(adminUser.getAdminName());
			
			if(adminUsers == null || adminUsers.size() == 0){
				throw new RuntimeException("此管理员名字已经存在！请重新填写！");
			}
		}
		adminUserDao.update(adminUser);
	}

	/**
	 * 删除
	 */
	public void delete(Integer id) {
		if (null == id) {
			throw new RuntimeException("信息有误，操作失败！");
		}
		adminUserDao.delete(id);
	}
	
	/**
	 * 获取用户
	 */
	public AdminUser getAdminUser(Integer id) {
		if (null == id) {
			throw new RuntimeException("用户ID不能为空！");
		}
		return adminUserDao.getAdminUserById(id);
	}

	/**
	 * 批量删除
	 */
	public void deleteByIds(List<Integer> ids) {
		if(null==ids || ids.size() == 0) {
			throw new RuntimeException("ID 不能为空");
		}
		adminUserDao.deletebyIds(ids);
	}

	/**
	 * 获取列表
	 */
	public Map<String, Object> getAdmins(AdminUserBO adminUserBO,Integer currentpage) {
		if(null==adminUserBO) {
			throw new RuntimeException("信息有误，查询失败！");
		}
		AdminUser adminUser = new AdminUser();
		adminUser.setAdminName(adminUserBO.getAdminName());
		
		List<AdminUser> dataList = adminUserDao.getAllAdmin(adminUser);
		
		int start = PageUtil.calEndIndex(currentpage, 10, dataList.size()); 		
		PaginationSupport page = PageUtils.setPaginationObject(dataList,start, 10);
		
		PageEntity entity = new PageEntity();
		
		entity.setTotalItemsCount(page.getTotalCount());  //总数量
		entity.setCurrentPage(currentpage);  //

		entity.setPageSize(page.getTotalCount());		
		entity.setTotalItemsCount(page.getTotalCount());
		
		entity.getPageCount(page.getTotalCount());
		
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
		
		dataMap.put(ContentUtil.WORD_LIST, page.getList());
		dataMap.put(ContentUtil.SYS_PAGE_KEY, entity);
	
		return dataMap;
	}

	/**
	 * 用户登录
	 */
	public AdminUser adminUserLogin(AdminUserBO adminUserBO) {
		
		//业务 保证用户名不能重复 
		List<AdminUser> userList = adminUserDao.getAdminUserByName(adminUserBO.getAdminName());
		
		if(userList == null || userList.size() == 0){
			throw new RuntimeException("当前用户不存在");
		}else{
			String password = userList.get(0).getAdminPassword();
			
			if(password != null && password.equals(adminUserBO.getAdminPassword())){
				return userList.get(0);
			}else{
				throw new RuntimeException("您输入的密码有误！");
			}
		}
	}
}
