package com.proword.facade.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proword.facade.WordDataFacade;
import com.proword.facade.pojo.BsnsBrowserResultForJsonVO;
import com.proword.facade.pojo.BsnsServResultEnum;
import com.proword.facade.pojo.WordDataPojo;
import com.proword.model.WordData;
import com.proword.service.WordDataService;
import com.proword.service.BO.WordDataBO;
import com.proword.util.ErrorMsgUtils;

/**
 * 
 * @ClassName: WordDataFacadeImpl
 * @Description: 词组门面层实现
 * @author zhuweimin
 * @date 2017年9月27日 下午1:39:58
 *
 */
@Component
public class WordDataFacadeImpl implements WordDataFacade {

	@Autowired
	private WordDataService wordDataService;

	/**
	 * 添加
	 */
	public void addWordData(WordDataPojo wordDataPojo) {
		if(null==wordDataPojo) {
			throw new RuntimeException("信息不完整，添加失败！");
		}
		WordDataBO wordDataBO = new WordDataBO();
		wordDataBO.setFrontColor(wordDataPojo.getFrontColor());
		wordDataBO.setBackColor(wordDataPojo.getBackColor());
		wordDataBO.setGroupWord(wordDataPojo.getGroupWord());
		wordDataBO.setGroupWord(wordDataPojo.getGroupWord());
		wordDataService.addWordData(wordDataBO);
	}

	/**
	 * 更新
	 */
	public void updateWordData(WordDataPojo wordDataPojo) {
		if(null==wordDataPojo) {
			throw new RuntimeException("信息不完整，更新失败！");
		}
		WordDataBO wordDataBO = new WordDataBO();
		wordDataBO.setFrontColor(wordDataPojo.getFrontColor());
		wordDataBO.setBackColor(wordDataPojo.getBackColor());
		wordDataBO.setGroupWord(wordDataPojo.getGroupWord());
		wordDataBO.setGroupWord(wordDataPojo.getGroupWord());
		wordDataService.update(wordDataBO);
	}

	/**
	 * 删除
	 */
	public void deleteWordData(Integer id) {
		wordDataService.delete(id);

	}

	/**
	 * 查找
	 */
	public WordData getWordDataById(Integer id) {
		WordData wordData = wordDataService.getWordData(id);
		try {
			return wordData;
		} catch (Exception e) {
			throw new RuntimeException("查询失败");
		}
		 
	}

	public void deleteByIds(List<Integer> ids) {
		wordDataService.deleteByIds(ids);
		
	}

	public HashMap<String, Object> getWordDatas(WordDataPojo wordDataPojo,Integer currentpage) {
		WordDataBO wordDataBO = new WordDataBO();
		wordDataBO.setGroupWord(wordDataPojo.getGroupWord());
		wordDataBO.setGroupWord(wordDataPojo.getGroupWord());
		
		HashMap<String, Object> dataMap = wordDataService.getDataList(wordDataBO,currentpage);
	
		return dataMap;
		
	}

	public BsnsBrowserResultForJsonVO getWordList(String wordType) {
		List<WordData> datas = wordDataService.getWordList(wordType);
		if(null==datas) {
			return BsnsServResultEnum.RESULTVO.getBrowserResultForJsonVO
					(0, ErrorMsgUtils.NO_RESULT_RETURN, null, null);
		}
		BsnsBrowserResultForJsonVO vo = BsnsServResultEnum.RESULTVO.getBrowserResultForJsonVO(1, null, datas, null);
		return vo;
	}

}
