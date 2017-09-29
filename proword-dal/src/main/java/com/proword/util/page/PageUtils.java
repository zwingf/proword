package com.proword.util.page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页对象工具类
 * @author houkai
 */
public class PageUtils {
	
	private static final String PAGE_TOTAL_COUNT = "PAGE_TOTAL_COUNT";
	private static final String PAGE_LIST = "PAGE_LIST";
	
    public static <T> Map<String, Object> setPageList(List<T> partnerInfoBeans, int start, int pageSize) {
        if (partnerInfoBeans == null || partnerInfoBeans.size() ==0) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(PAGE_TOTAL_COUNT, 0);
            map.put(PAGE_LIST, Collections.emptyList());
            return map;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        //当前页的数据列表
        List<T> currentPageList = new ArrayList<T>();
        //获取分页遍历结束节点
        int length = getPageEndSize(start + pageSize, partnerInfoBeans.size());
        if (start != -1 && pageSize != -1) {
            //设置分页中的列表,start为起始下标
            for (int i = start; i < length; i++) {
                currentPageList.add(partnerInfoBeans.get(i));
            }
        } else {
            currentPageList = partnerInfoBeans;
        }

        map.put(PAGE_LIST, currentPageList);
        map.put(PAGE_TOTAL_COUNT, partnerInfoBeans.size());
        return map;
    }
    
    private static int getPageEndSize(int count, int size) {
        return count < size ? count : size;
    }
    
    /**
     * 内存中分页.
     * @param partnerInfoBeans 带分页的总共条数.
     * @param start 分页起始下标.
     * @param pageSize 分页大小。
     * @param <T>
     * @return
     */
    public static <T>PaginationSupport setPaginationObject(List<T> partnerInfoBeans, int start, int pageSize) {
        Map<String, Object> map = setPageList(partnerInfoBeans, start, pageSize);
        int totalCount = (Integer) map.get(PAGE_TOTAL_COUNT);
        List<T> currentPageList = (List<T>) map.get(PAGE_LIST);
        return new PaginationSupport<T>(currentPageList, totalCount, start);
    }

    
}
