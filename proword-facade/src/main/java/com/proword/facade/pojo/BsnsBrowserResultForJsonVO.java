package com.proword.facade.pojo;

import java.io.Serializable;

/**
 * 
* @ClassName: BsnsBrowserResultForJsonVO 
* @Description: 返回前台的数据
* @author zhuweimin
* @date 2017年9月25日 下午5:09:51 
*
 */
public class BsnsBrowserResultForJsonVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1806134522280030248L;

	private Integer status;

	private String msg;

	private Integer rows;
	
	private Object data;
	
	public BsnsBrowserResultForJsonVO() {
		
	}

	public BsnsBrowserResultForJsonVO(Integer status, String msg, Integer rows, Object data) {
		this.status = status;
		this.msg = msg;
		this.rows = rows;
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
