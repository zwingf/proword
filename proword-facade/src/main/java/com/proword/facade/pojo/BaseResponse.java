package com.proword.facade.pojo;

import java.io.Serializable;

/**
 * @author houkai
 *
 */
public class BaseResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4734953717187592704L;

	//
	private boolean success = true;
	
	private String errorCode;
	
	private String errorMessage;
	
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
	
}
