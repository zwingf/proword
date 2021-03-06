package com.proword.facade.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: AdminUserPojo
 * @Description: 管理员
 * @author zhuweimin
 * @date 2017年9月27日 上午10:27:53
 *
 */
public class AdminUserPojo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8061026436058976012L;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column admin_user.id
	 *
	 * @mbggenerated
	 */
	private Integer id;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column admin_user.admin_name
	 *
	 * @mbggenerated
	 */
	private String adminName;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column admin_user.admin_password
	 *
	 * @mbggenerated
	 */
	private String adminPassword;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column admin_user.create_time
	 *
	 * @mbggenerated
	 */
	private Date createTime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column admin_user.update_time
	 *
	 * @mbggenerated
	 */
	private Date updateTime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column admin_user.id
	 *
	 * @return the value of admin_user.id
	 *
	 * @mbggenerated
	 */
	
	private int pageSize;

	private int startSize;

	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column admin_user.id
	 *
	 * @param id
	 *            the value for admin_user.id
	 *
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column admin_user.admin_name
	 *
	 * @return the value of admin_user.admin_name
	 *
	 * @mbggenerated
	 */
	public String getAdminName() {
		return adminName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column admin_user.admin_name
	 *
	 * @param adminName
	 *            the value for admin_user.admin_name
	 *
	 * @mbggenerated
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column admin_user.admin_password
	 *
	 * @return the value of admin_user.admin_password
	 *
	 * @mbggenerated
	 */
	public String getAdminPassword() {
		return adminPassword;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column admin_user.admin_password
	 *
	 * @param adminPassword
	 *            the value for admin_user.admin_password
	 *
	 * @mbggenerated
	 */
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column admin_user.create_time
	 *
	 * @return the value of admin_user.create_time
	 *
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column admin_user.create_time
	 *
	 * @param createTime
	 *            the value for admin_user.create_time
	 *
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column admin_user.update_time
	 *
	 * @return the value of admin_user.update_time
	 *
	 * @mbggenerated
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column admin_user.update_time
	 *
	 * @param updateTime
	 *            the value for admin_user.update_time
	 *
	 * @mbggenerated
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartSize() {
		return startSize;
	}

	public void setStartSize(int startSize) {
		this.startSize = startSize;
	}
	
}
