/**
 * 
 */
package com.proword.facade.pojo;

/**
 * @author houkai
 *
 */
public class UserPojo extends BaseResponse{
	/**
	 * 
	 */
	private static final long serialVersionUID = -724867847309817115L;
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
	
	
}
