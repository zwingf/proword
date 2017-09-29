package com.proword.facade;

import com.proword.facade.pojo.BsnsBrowserResultForJsonVO;

/**
 * 
* @ClassName: WordDictFacade 
* @Description: 词库字典门面层
* @author zhuweimin
* @date 2017年9月27日 下午3:00:47 
*
 */


public interface WordDictFacade {

	/**
	 * 
	* @Title: getWordDicts 
	* @Description: 词库字典id
	* @return    返回词库字典的列表
	* BsnsBrowserResultForJsonVO 
	* @throws
	 */
	BsnsBrowserResultForJsonVO getWordDicts();
}
