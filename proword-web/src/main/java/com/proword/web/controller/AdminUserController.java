package com.proword.web.controller;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proword.facade.AdminUserFacade;
import com.proword.facade.WordDataFacade;
import com.proword.facade.pojo.AdminUserPojo;
import com.proword.model.AdminUser;
import com.proword.util.ContentUtil;

/**
 * 
 * @ClassName: AdminUserController
 * @Description: 管理员控制层
 * @author zhuweimin
 * @date 2017年9月27日 上午10:50:38
 *
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminUserController {

	@Autowired
	private AdminUserFacade adminUserFacade;
	@Autowired
	private WordDataFacade wordDatafacade;
	
	@RequestMapping(value="/jsonReader")
	public ModelAndView pageableTest(){
		
		ModelAndView modelAndView = new ModelAndView();
		
		String str = "{totalpages: 'xxx',currPage: 'yyy', totalCount: 'zzz',  dataList: [  {AGENTID:'1',STATUS:'1', AGTNAM:'1', APPLYDAT:'1', AGTTEL:'1', USER_ID:'1'},  {AGENTID:'1',STATUS:'1', AGTNAM:'1', APPLYDAT:'1', AGTTEL:'1', USER_ID:'1'}] }";
		
		modelAndView.addObject("jsonReader", str);
		
		return modelAndView; 
		
	}
	
	@RequestMapping("/topage")
	public String toPage(){
		return "page";
	}
	
	/**
	 * 
	* @Title: addAdminUser 
	* @Description: 添加管理员
	* @param modelMap
	* @param adminUserPojo    
	* void    
	* @throws
	 */
	@RequestMapping(value = "/addadmin", method = RequestMethod.POST)
	public String addAdminUser(@RequestParam(value="adminUserPojo",required=true)AdminUserPojo adminUserPojo) {
		adminUserFacade.addAdminUser(adminUserPojo);
		return "redirect:/administrator/administrator";
	}
	/**
	 * 
	* @Title: deleteAdmin 
	* @Description: 删除
	* @param id    
	* void    
	* @throws
	 */
	@RequestMapping(value="/deleteadmin",method = RequestMethod.POST)
	public String deleteAdmin(@RequestParam(value="id",required=true)Integer id) {
		adminUserFacade.deleteAdminUser(id);
		return "redirect:/administrator/administrator";
	}
	/**
	 * 
	* @Title: updateAdmin 
	* @Description: 修改
	* @param adminUserPojo    
	* void    
	* @throws
	 */
	@RequestMapping(value="/updateadmin",method = RequestMethod.POST)
	public String updateAdmin(@RequestParam(value="adminUserPojo",required=true)AdminUserPojo adminUserPojo) {
		adminUserFacade.updateAdminUser(adminUserPojo);
		return "redirect:/administrator/administrator";
	}
	/**
	 * 
	* @Title: getAdmin 
	* @Description: 获取管理员
	* @param id
	* @return    
	* ModelAndView    
	* @throws
	 */
	@RequestMapping(value="/getadmin",method = RequestMethod.POST)
	public ModelAndView getAdmin(@RequestParam(value="id",required=true)Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		AdminUser adminUser= adminUserFacade.getAdminUSerById(id);
		return modelAndView.addObject("admin", adminUser);
	}
	
	/**
	 * 
	* @Title: deleteByIds 
	* @Description: 批量删除管理员
	* @param ids
	* @return    
	* String    
	* @throws
	 */
	@RequestMapping(value="/deleteByIds",method = RequestMethod.POST)
	public String deleteByIds(@RequestParam(value="ids",required=true)List<Integer> ids) {
		adminUserFacade.deleteByIds(ids);
		return "redirect:/administrator/administrator";
	}
	
	/**
	* @Title: getAdminList 
	* @Description: 获取管理员列表
	* @param adminUserPojo
	* @return    
	* ModelAndView    管理员列表和分页信息
	* @throws
	 */
	@RequestMapping(value="/getAdminList",method = RequestMethod.POST)
	public ModelAndView getAdminList(@RequestParam(value="adminUserPojo")AdminUserPojo adminUserPojo,
									 @RequestParam(value="currentpage",required=true)Integer currentpage) {
		ModelAndView mView = new ModelAndView();
		
		Map<String, Object> admins = adminUserFacade.getAdmins(adminUserPojo,currentpage);
		return mView.addObject(ContentUtil.ADMIN_USER_LIST, admins);
	}
	
	/**
	 * 跳转到用户登录页面
	 * @return
	 */
	@RequestMapping(value="/toLogin")
	public ModelAndView toLogin(){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login/login");
		return modelAndView;
	}
	
	/**
	 * 用户登录
	 * @param request
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request,@RequestParam(value="userName", required=true)String userName,@RequestParam(value="password", required=true)String password){
		
		HttpSession session = request.getSession();
		
		AdminUser user = adminUserFacade.adminUserLogin(userName, password);
		
		session.setAttribute(session.getId(), user);
		session.setAttribute("userName", userName);
		
		return "lexicon/lexicon";
	}
	
	/**
	 * 
	* @Title: goToAdmin 
	* @Description: 跳转去管理员页面
	* @return    
	* ModelAndView    
	* @throws
	 */
	@RequestMapping(value="toAdmin")
	public ModelAndView goToAdmin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("administrator/administrator");
		return modelAndView;
	}
	/**
	 * 用户退出
	 * @param request
	 */
	@RequestMapping(value="/quit", method = RequestMethod.POST)
	public ModelAndView quit(HttpServletRequest request){
		HttpSession session = request.getSession();
				
		session.removeAttribute(session.getId());
		session.removeAttribute("userName");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login/login");
		
		
		return modelAndView;
	}
	
	/**
	 * 跳转到管理员管理页面
	 * @return
	 */
	@RequestMapping(value="/toAdministrator")
	public ModelAndView toAdministrator(){
		
		Map<String, Object> admins = adminUserFacade.getAdmins(new AdminUserPojo(),0);
		
		ModelMap map = new ModelMap();
		
		map.put("map", admins);
		return new ModelAndView( "administrator/administrator");
	} 
	
}
