package com.proword.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proword.facade.WordDictFacade;
import com.proword.facade.pojo.BsnsBrowserResultForJsonVO;
import com.proword.facade.pojo.BsnsServResultEnum;
import com.proword.model.WordDict;

/**
 * 
* @ClassName: WordDictContrller 
* @Description: 词库字典控制层
* @author zhuweimin
* @date 2017年9月27日 下午3:10:18 
*
 */
@Controller
@RequestMapping(value="/dict")
public class WordDictContrller {

	@Autowired 
	private WordDictFacade wordDictFacade;
	
	/**
	 * 
	* @Title: getDictList 
	* @Description: 词库字典列表
	* @return    
	* ModelAndView    
	* @throws
	 */
	@RequestMapping(value="/getDictList")
	@ResponseBody
	public BsnsBrowserResultForJsonVO getDictList() {
		return wordDictFacade.getWordDicts();
	}
}
