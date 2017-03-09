package com.iiifi.framework.server.usercenter.utils;


public class UserInfoUtils {
	/*public static String getUserNo(){
		return DateUtils.formatDate(new Date(), "yyyyMMddHHmmss")+NumberUtils.generateSixRandomNum();
	}
	
	public static final String USERCENTER_USER="usercenter-user";
	public static final String USERCENTER_PHONE="usercenter-phone";
	*//**
	 * 将用户信息放入缓存中
	 * @param userInfo
	 * @param commnParameters
	 *//*
	public static String setUserToRedis(UserInfo userInfo,CommonParameters commonParameters){
		String token=IdGen.uuid();
		String oldToken=JedisUtils.hget(USERCENTER_PHONE,userInfo.getId());
		if(oldToken!=null&&!oldToken.equals("")){
			removeUser(oldToken);
		}
		JedisUtils.hset(USERCENTER_USER, token, userInfo);
		JedisUtils.hset(USERCENTER_PHONE, userInfo.getId(), token);
		return token;
	}
	*//**
	 * 从redis中获取用户信息
	 * @param commnParameters
	 * @return
	 *//*
	public static UserInfo getUserByRedis(CommonParameters commonParameters){
		String token=commonParameters.getToken();
		UserInfo userInfo= JedisUtils.hget(USERCENTER_USER,token,UserInfo.class);
		return userInfo;
	}
	*//**
	 * 从redis中删除用户信息
	 * @param commnParameters
	 * @return
	 *//*
	public static void removeUser(String token){
		JedisUtils.hdel(USERCENTER_USER, token);
	}
	public static String checkPower(CommonParameters commonParameters,String requestUrl){
		if(requestUrl==null||requestUrl.startsWith("/main/share")||requestUrl.startsWith("/main/open")){
			return ResultConstant.APP_RETURN_SUCESS;
		}
		String token=commonParameters.getToken();
		if(token==null||token.equals("")){
			return ResultConstant.APP_NOT_LOGIN_CODE;
		}
		UserInfo userInfo=getUserByRedis(commonParameters);
		if(userInfo==null){
			return ResultConstant.APP_NOT_LOGIN_CODE;
		}
		int perfectStatus=userInfo.getPerfectStatus();
		if(requestUrl.equals("/main/phone")){
			if(perfectStatus<UserConstant.BINDING_PHONE){
				return  ResultConstant.APP_NOT_BINDING_PHONE_CODE;
			}
		}
		if(requestUrl.equals("/main/perfect")){
			if(perfectStatus<UserConstant.ALREADY_PERFECT){
				return  ResultConstant.APP_NOT_PERFECT_CODE;
			}
		}
		if(requestUrl.equals("/main/realname")){
			if(perfectStatus<UserConstant.REAL_NAME_AUTH){
				return  ResultConstant.APP_NOT_REALNAME_CODE;
			}
		}
		return ResultConstant.APP_RETURN_SUCESS;
	}*/
}
