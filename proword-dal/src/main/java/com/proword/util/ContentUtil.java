package com.proword.util;

/***
 * 
 * @author wangjiang
 *
 */
public class ContentUtil {
	/** 系统Page 的KEY */
	public final static String SYS_PAGE_KEY = "page";
	/** IP缓存时间 */
	public final static Long IP_LOGIN_TIME = 60L;
	
	/** 用户名个数*/
	public final static Integer NAME_COUNT = 1;
	
	/** 用户在session域中存放的id */
	public static final String USER_FILED = "user_id";
	
	/** 保存时间  7天*/
	public static final int USER_LOGIN_TIME = 7*60*60*24;
	/** 词组的key */
	public static final String WORD_LIST = "wordList";
	
	/** 用的key */
	public static final String USER_LIST = "userList";
	
	/** 管理员的key*/
	public static final String ADMIN_USER_LIST = "adminList";
	
	/** 管理员登录的信息 */
	public static final String ADMIN_LOGIN_KEY = "admin";
	
	/** 管理员用户名 */
	public static final int NAME_MIN_LENGTH = 4;
	
	/** 管理员没加密之前的密码长度 */
	public static final int PASSWORD_MIN_LENGTH = 6;
	
	/** 管理员用户名最大的长度*/
	public static final int NAME_MAX_LENGTH = 8;
	
	/** 最大的密码长度 */
	public static final int PASSWORD_MAX_LENGTH = 18;
	
	/** 验证名字的唯一 */
	public static final int CHECK_ADMIN_NAME = 1;
	
	/** 词组的key*/
	public static final String SYS_DICT_KEY = "sysDictList";
	
}
