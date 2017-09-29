package com.proword.web.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.proword.facade.WordDataFacade;
import com.proword.facade.WordDictFacade;
import com.proword.facade.pojo.BsnsBrowserResultForJsonVO;
import com.proword.facade.pojo.WordDataPojo;
import com.proword.util.ContentUtil;

/**
 * 
* @ClassName: WordDataController 
* @Description: 词组控制层
* @author zhuweimin
* @date 2017年9月27日 下午1:15:44 
*
 */
@Controller
@RequestMapping(value="/word")
public class WordDataController {

	@Autowired
	private WordDataFacade wordDataFacade;	
	@Autowired
	private WordDictFacade wordDictFacade;
	/**
	* @Title: getDictList 
	* @Description: 词库字典列表
	* @return  ModelAndView    
	* @throws
	 */
	@RequestMapping(value="/getDictList")
	@ResponseBody
	public BsnsBrowserResultForJsonVO getDictList() {
		BsnsBrowserResultForJsonVO wordDicts = wordDictFacade.getWordDicts();
		return wordDicts;
	}
	
	/**
	 * 
	* @Title: getWordList 
	* @Description: 词组列表
	* @return BsnsBrowserResultForJsonVO    
	* @throws
	 */
	@RequestMapping(value="/getWordList")
	@ResponseBody
	public BsnsBrowserResultForJsonVO getWordList(@RequestParam("wordType")String wordType) {
		BsnsBrowserResultForJsonVO dataList = wordDataFacade.getWordList(wordType);
		return dataList;
	}
	
	
	/**
	 * 
	* @Title: addWrodData 
	* @Description: 添加词组
	* @param wordDataPojo    
	* void    
	* @throws
	 */
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String addWrodData(@RequestParam(value="wordDataPojo",required=true)WordDataPojo wordDataPojo) {
		wordDataFacade.addWordData(wordDataPojo);
		return null;
	}
	/**
	 * 
	* @Title: getWordData 
	* @Description: 获取词组
	* @param id
	* @return    
	* ModelAndView    
	* @throws
	 */
	@RequestMapping(value="getWordData",method=RequestMethod.POST)
	public ModelAndView getWordData(@RequestParam(value="id",required=true)Integer id) {
		ModelAndView modelAndView = new  ModelAndView();
		return modelAndView.addObject("worddata",wordDataFacade.getWordDataById(id));
	}
	/**
	 * 
	* @Title: deletedata 
	* @Description: 删除
	* @param id    
	* void    
	* @throws
	 */
	@RequestMapping(value="deletedata",method=RequestMethod.POST)
	public String deletedata(@RequestParam(value="id",required=true)Integer id) {
		wordDataFacade.deleteWordData(id);
		return null;
	}
	/**
	 * 
	* @Title: updateData 
	* @Description: 更新
	* @param wordDataPojo    
	* void    
	* @throws
	 */
	@RequestMapping(value="updatedata",method=RequestMethod.POST)
	public String updateData(@RequestParam(value="wordDataPojo",required=true)WordDataPojo wordDataPojo) {
		wordDataFacade.updateWordData(wordDataPojo);
		return null;
	}
	/**
	 * 
	* @Title: deleteByIds 
	* @Description: 批量删除
	* @param ids 词库id
	* @return    
	* String    
	* @throws
	 */
	@RequestMapping(value="deletebyids",method=RequestMethod.POST)
	public String deleteByIds(@RequestParam(value="ids",required=true)List<Integer> ids) {
		wordDataFacade.deleteByIds(ids);
		return null;
	}
	/**
	 * 
	* @Title: getWordDatas 
	* @Description: 获取词组列表
	* @param wordDataPojo
	* @return    
	* ModelAndView    返回词组列表和分页信息
	* @throws
	 */
	@RequestMapping(value="getworddatas",method=RequestMethod.POST)
	public ModelAndView getWordDatas(@RequestParam(value="wordDataPojo",required=true)WordDataPojo wordDataPojo,
			@RequestParam(value="currentpage",required=true) Integer currentpage) {
		ModelAndView mAndView = new ModelAndView();
		HashMap<String, Object> dataMap = wordDataFacade.getWordDatas(wordDataPojo,currentpage);
		return mAndView.addObject(ContentUtil.WORD_LIST, dataMap);
	}
	
	@RequestMapping(value="toLexico")
	public String toLexico(){
		return "lexicon/lexicon";
	}
}
