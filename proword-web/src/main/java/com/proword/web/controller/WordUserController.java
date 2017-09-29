package com.proword.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.proword.facade.WordUserFacade;
import com.proword.facade.pojo.WordUserPojo;

/**
 * 
* @ClassName: WordUserController 
* @Description: 用户控制层
* @author zhuweimin
* @date 2017年9月27日 下午12:47:01 
*
 */
@Controller
@RequestMapping(value="/user")
public class WordUserController {

	@Autowired
	private WordUserFacade wordUserFacade;
	/**
	 * 
	* @Title: insert 
	* @Description: 添加
	* @param modelMap
	* @param wordUserPojo    
	* void    
	* @throws
	 */
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public String insert(ModelMap modelMap, WordUserPojo wordUserPojo) {
		wordUserFacade.addWordUser(wordUserPojo);
		return null;
	}
	/**
	 * 
	* @Title: getWordUser 
	* @Description: 获取用户
	* @param id
	* @return    
	* ModelAndView    
	* @throws
	 */
	@RequestMapping(value="/getwordUser",method = RequestMethod.POST)
	public ModelAndView getWordUser(Integer id) {
		ModelAndView mAndView = new ModelAndView();
		return mAndView.addObject("user", wordUserFacade.getWordUSerById(id));
	}
	/**
	 * 
	* @Title: deleteUser 
	* @Description: 删除
	* @param id
	* @return    
	* String    
	* @throws
	 */
	@RequestMapping(value="/deleteuser",method = RequestMethod.POST)
	public String deleteUser(Integer id) {
		wordUserFacade.deleteWordUser(id);
		return null;
	}
	/**
	 * 
	* @Title: updateuser 
	* @Description: 修改
	* @param wordUserPojo
	* @return    
	* String    
	* @throws
	 */
	@RequestMapping(value="/updateuser",method = RequestMethod.POST)
	public String updateuser(WordUserPojo wordUserPojo) {
	wordUserFacade.updateWordUser(wordUserPojo);
	return null;
	}
	@RequestMapping(value="/deleteByIds",method = RequestMethod.POST)
	public String deleteByIds(List<Integer> ids) {
		wordUserFacade.deleteByIds(ids);
		return null;
	}
}
