package com.iiifi.framework.server.usercenter.utils;

public class UserResultCode {

	/**
	 *手机短信验证码发送失败 
	 */
	public final static String SEND_CODE_ERROR="12000001";
	/**
	 *手机短信验证码发送失败 
	 */
	public final static String SEND_CODE_ERROR_MESSAGE="手机短信验证码发送失败 ";
	/**
	 * 用户名或者密码不可为空
	 */
	public final static String LOGIN_NAME_OR_PASSWORD_INVALID="1200002";
	/**
	 * 用户名或者密码不可为空
	 */
	public final static String LOGIN_NAME_OR_PASSWORD_INVALID_MESSAGE="用户名或者密码不可为空";
	
	/**
	 * 该用户已存在
	 */
	public final static String LOGIN_NAME_EXIST="12000003";

	/**
	 * 该用户已存在
	 */
	public final static String LOGIN_NAME_EXIST_MESSAGE="该用户已存在";
	/**
	 * 无效的验证码
	 */
	public final static String INVALID_CODE="12000004";
	/**
	 * 无效的验证码
	 */
	public final static String INVALID_CODE_MESSAGE="无效的验证码";
	
	/**
	 * 用户不存在
	 */
	public final static String USER_NOT_EXIST="12000005";

	/**
	 * 用户不存在
	 */
	public final static String USER_NOT_EXIST_MESSAGE="用户不存在";
	
	/**
	 * 账号或者密码错误
	 */
	public final static String LOGIN_NAME_OR_PASSWORD_ERROR="12000006";
	/**
	 * 账号或者密码错误
	 */
	public final static String LOGIN_NAME_OR_PASSWORD_ERROR_MESSAGE="账号或者密码错误";
	/**
	 * 用户名或者支付密码不可为空
	 */
	public final static String LOGIN_NAME_OR_PAY_PASSWORD_INVALID="12000007";
	/**
	 * 用户名或者支付密码不可为空
	 */
	public final static String LOGIN_NAME_OR_PAY_PASSWORD_INVALID_MESSAGE="用户名或者支付密码不可为空";
	/**
	 * 未登录或登录失效,请重新登录
	 */
	public final static String NOT_LOGIN="12000008";
	/**
	 * 未登录或登录失效,请重新登录
	 */
	public final static String NOT_LOGIN_MESSAGE="未登录或登录失效,请重新登录";
	/**
	 * 支付密码错误
	 */
	public final static String PAY_PASSWORD_ERROR="12000009";
	/**
	 * 支付密码错误
	 */
	public final static String PAY_PASSWORD_ERROR_MESSAGE="支付密码错误";
	/**
	 * 余额不足
	 */
	public final static String YE_SHORTAGE="12000010";
	/**
	 * 余额不足
	 */
	public final static String YE_SHORTAGE_MESSAGE="余额不足";
	
	/**
	 * 无效的邀请码
	 */
	public final static String INVALID_MARKET_CODE="12000011";
	/**
	 * 无效的邀请码
	 */
	public final static String INVALID_MARKET_MESSAGE="无效的邀请码";
}
