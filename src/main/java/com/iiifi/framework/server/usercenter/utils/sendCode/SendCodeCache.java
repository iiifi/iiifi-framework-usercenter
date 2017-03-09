package com.iiifi.framework.server.usercenter.utils.sendCode;

import com.iiifi.framework.server.common.common.mapper.JsonMapper;
import com.iiifi.framework.server.common.common.utils.JedisUtils;


public class SendCodeCache {

	private static final String SMS_CACHE_KEY = "usercenter_smscode";
	
	/**
	 * 注册标志
	 */
	public static final String SMS_REGISTER_CODE = "register";
	/**
	 * 修改密码标志
	 */
	public static final String SMS_RESET_LOGIN_PWD_CODE = "resetLoginPwd";
	/**
	 * 支付密码标志
	 */
	public static final String SMS_RESET_PAY_PWD_CODE = "resetPayPwd";
	/**
	 * 修改登录名标志
	 */
	public static final String SMS_RESET_LOGIN_NAME="resetLoginName";
	
	/**
	 * 快捷登录标志
	 */
	public static final String SPEED_LOGIN="speedLogin";

	
	/**
	 * 绑定手机号标志
	 */
	public static final String BINDING_PHONE="bindingPhone";
	/**
	 * 设置缓存
	 * @param sms
	 */
	public static void setSMSCache(SendCodeBean sendCode){
		JedisUtils.hset(SMS_CACHE_KEY, sendCode.getBizcode() + sendCode.getTel(), sendCode);
	}
	
	/**
	 * 获取缓存
	 * @param tel
	 * @return
	 */
	public static SendCodeBean getSMSCache(String tel,String bizcode){
		String smscache = JedisUtils.hget(SMS_CACHE_KEY, bizcode + tel);
		if (smscache == null || "".equals(smscache)) {
			return null;
		}
		return (SendCodeBean) JsonMapper.fromJsonString(smscache, SendCodeBean.class);
//		return (SMSBean) JSONUtils.parseJson2Object(smscache, SMSBean.class);
	}
	
	/**
	 * 删除缓存
	 * @param tel
	 */
	public static void delSMSCache(String tel,String bizcode){
		JedisUtils.hdel(SMS_CACHE_KEY, bizcode + tel);
	}
}
