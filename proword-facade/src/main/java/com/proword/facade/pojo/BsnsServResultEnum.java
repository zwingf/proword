package com.proword.facade.pojo;




/**
 * 
 * @author zhuweimin
 *
 */
public enum BsnsServResultEnum {
	/** 结果返回 */
	RESULTVO;

	
	private BsnsBrowserResultForJsonVO browserResultForJsonVO = new BsnsBrowserResultForJsonVO();

	public BsnsBrowserResultForJsonVO getBrowserResultForJsonVO(Integer status, String msg, Object data, Integer rows) {
		browserResultForJsonVO.setData(data);
		browserResultForJsonVO.setMsg(msg);
		browserResultForJsonVO.setRows(rows);
		browserResultForJsonVO.setStatus(status);
		return browserResultForJsonVO;
	}
	
}
