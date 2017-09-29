/**
 * 
 */
package com.proword.service.BO;

import java.io.Serializable;

/**
 * @author houkai
 *
 */
public class UserBO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6440481186544633731L;

	private int userId;
	
	private String userName;

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void validation(){
		if(userId == 0){
			new Exception("userId不能为空");
		}
	}
	
	
}
