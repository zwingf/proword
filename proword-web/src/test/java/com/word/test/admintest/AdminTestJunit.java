package com.word.test.admintest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.proword.facade.AdminUserFacade;
import com.proword.facade.pojo.AdminUserPojo;
import com.proword.model.AdminUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application.xml" })
public class AdminTestJunit {

	@Autowired
	private AdminUserFacade adminUserFacade;

	@Test
	public void insertAdmin() {
		AdminUserPojo adminUserPojo = new AdminUserPojo();
		adminUserPojo.setAdminName("5457946");
		adminUserPojo.setAdminPassword("4764545");
		adminUserFacade.addAdminUser(adminUserPojo);
	}

	@Test
	public void deleteAdmin() {
		adminUserFacade.deleteAdminUser(265);
	}

	@Test
	public void getAdmin() {
		AdminUser adminUSerById = adminUserFacade.getAdminUSerById(1);
		System.out.println(adminUSerById);
	}
	
	/**
	 * 用户表分页查询
	 */
	@Test
	public void getAdminList() {
		AdminUserPojo pojo = new AdminUserPojo();
		Map<String, Object> map = adminUserFacade.getAdmins(pojo, 1);
		
		System.out.println(map);
	}

	@Test
	public void delleteByids() {
		List<Integer> ids = new ArrayList<Integer>();
				ids.add(256);
				ids.add(257);
				adminUserFacade.deleteByIds(ids);
	}

}
