package com.proword.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proword.dao.WordDataDao;
import com.proword.model.WordData;
import com.proword.service.WordDataService;
import com.proword.service.BO.WordDataBO;
import com.proword.util.ContentUtil;
import com.proword.util.ErrorMsgUtils;
import com.proword.util.PageEntity;
import com.proword.util.page.PageUtil;
import com.proword.util.page.PageUtils;
import com.proword.util.page.PaginationSupport;

/**
 * 
 * @ClassName: WordDataServiceImpl
 * @Description: 词组接口实现层
 * @author zhuweimin
 * @date 2017年9月27日 下午1:43:04
 *
 */
@Service
public class WordDataServiceImpl implements WordDataService {

	@Autowired
	private WordDataDao wordDataDao;

	/**
	 * 获取词组
	 */
	public WordData getWordData(Integer id) {
		if (null == id) {
			new Exception("id不能为空！");
		}
		return wordDataDao.getWordDataById(id);
	}

	/**
	 * 删除
	 */
	public void delete(Integer id) {
		if (null == id) {
			new Exception("id不能为空！");
		}
		wordDataDao.delete(id);
	}

	/**
	 * 更新
	 */
	public void update(WordDataBO wordDataBO) {
		wordDataBO.checkWordData();
		WordData wordData = new WordData();
		wordData.setId(wordDataBO.getId());
		wordData.setGroupWord(wordDataBO.getGroupWord());
		wordDataDao.update(wordData);
	}

	/**
	 * 添加
	 */
	public void addWordData(WordDataBO wordDataBO) {
		wordDataBO.checkWordData();
		WordData wordData = new WordData();
		wordData.setId(wordDataBO.getId());
		wordData.setGroupWord(wordDataBO.getGroupWord());
		wordDataDao.addWordData(wordData);
	}

	public void deleteByIds(List<Integer> ids) {
		if (null == null) {
			new Exception(ErrorMsgUtils.PARAM_MISS);
		}
		wordDataDao.deleteByIds(ids);
	}
	
	public HashMap<String, Object> getDataList(WordDataBO wordDataBO,Integer currentpage) {
		if (null == wordDataBO) {
			new Exception(ErrorMsgUtils.PARAM_MISS);
		}
		WordData wordData = new WordData();
		wordData.setGroupWord(wordDataBO.getGroupWord());
		
		List<WordData> dataList = wordDataDao.getWordDatas(wordData);
		int start = PageUtil.calEndIndex(currentpage, 10, dataList.size()); 		
		PaginationSupport page = PageUtils.setPaginationObject(dataList,start, 10);
		
		PageEntity entity = new PageEntity();
		
		entity.setTotalItemsCount(page.getTotalCount());  //总数量
		entity.setCurrentPage(currentpage);  //

		entity.setPageSize(page.getTotalCount());		
		entity.setTotalItemsCount(page.getTotalCount());
		entity.getPageCount(page.getTotalCount());
		
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
		
		dataMap.put(ContentUtil.WORD_LIST, dataList);
		dataMap.put(ContentUtil.SYS_PAGE_KEY, page.getList());
	
		return dataMap;
	}

	public List<WordData> getWordList(String wordType) {
		List<WordData> datas = wordDataDao.getWordList(wordType);
		if(null==datas) {
			throw new RuntimeException("查询信息不存在");
		}
		return datas;
	}
}
