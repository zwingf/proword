package com.proword.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proword.dao.WordDictDao;
import com.proword.facade.WordDictFacade;
import com.proword.facade.pojo.BsnsBrowserResultForJsonVO;
import com.proword.facade.pojo.BsnsServResultEnum;
import com.proword.model.WordDict;
import com.proword.util.ErrorMsgUtils;
/**
 * 
* @ClassName: WordDictFacadeImpl 
* @Description: 词库门面接口实现层
* @author zhuweimin
* @date 2017年9月27日 下午3:03:04 
*
 */
@Component
public class WordDictFacadeImpl implements WordDictFacade {

	@Autowired
	private WordDictDao wordDictDao;
	
	/**
	 * 获取字典列表
	 */
	public BsnsBrowserResultForJsonVO getWordDicts() {
		List<WordDict> wordDicts = wordDictDao.getWordDicts();

		if(null==wordDicts || wordDicts.size() == 0) {
			return BsnsServResultEnum.RESULTVO.getBrowserResultForJsonVO(0,ErrorMsgUtils.NO_RESULT_RETURN , null, null);
		}
		BsnsBrowserResultForJsonVO vo = BsnsServResultEnum.RESULTVO.getBrowserResultForJsonVO(1, null, wordDicts, wordDicts.size());
		
		return  vo;
	}
	
}
