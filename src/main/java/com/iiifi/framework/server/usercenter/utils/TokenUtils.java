/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.iiifi.framework.server.usercenter.utils;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import com.iiifi.framework.server.common.common.utils.IdGen;
import com.iiifi.framework.server.common.common.utils.JedisUtils;


/**
 * token管理工具类
 */
public class TokenUtils {
	public static final String USERCENTER_TOKEN="usercenter-token";
	/**
	 * 获取令牌
	 * @param request
	 * @return
	 */
	public static String getToken(){
		String tokenStr=IdGen.uuid();
		Token token=new Token();
		token.setToken(tokenStr);
		token.setCreateTime(new Date().getTime());
		token.setRefreshTime(new Date().getTime());
		JedisUtils.hset(USERCENTER_TOKEN, tokenStr, token);
		return tokenStr;
	}
	/**
	 * 根据令牌获取内容
	 * @param request
	 * @return
	 */
	public static Token getTokenObject(String token){
		Token tokenObject=JedisUtils.hget(USERCENTER_TOKEN, token, Token.class);
		return tokenObject;
	}
	/**
	 * 根据令牌刷新token
	 * @param request
	 * @return
	 */
	public Token updeteTokenObject(String token){
		Token tokenObject=JedisUtils.hget(USERCENTER_TOKEN, token, Token.class);
		tokenObject.setRefreshTime(new Date().getTime());
		return tokenObject;
	}
	static class Token implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String token;
		private Map<String, String> headers;
	    private Object subObject; // session subobject 用于存储令牌内信息
	    private String remoteHost; // 请求方的host
	    private long createTime; // 令牌创建时间
	    private long refreshTime; // 令牌刷新时间
	    private long expires = 2100000000; // 令牌有效时间
	    				
	    private Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public Map<String, String> getHeaders() {
			return headers;
		}
		public void setHeaders(Map<String, String> headers) {
			this.headers = headers;
		}
		public Object getSubObject() {
			return subObject;
		}
		public void setSubObject(Object subObject) {
			this.subObject = subObject;
		}
		public String getRemoteHost() {
			return remoteHost;
		}
		public void setRemoteHost(String remoteHost) {
			this.remoteHost = remoteHost;
		}
		public long getCreateTime() {
			return createTime;
		}
		public void setCreateTime(long createTime) {
			this.createTime = createTime;
		}
		public long getRefreshTime() {
			return refreshTime;
		}
		public void setRefreshTime(long refreshTime) {
			this.refreshTime = refreshTime;
		}
		public long getExpires() {
			return expires;
		}
		public void setExpires(long expires) {
			this.expires = expires;
		}
		public Map<String, Object> getDataMap() {
			return dataMap;
		}
		public void setDataMap(Map<String, Object> dataMap) {
			this.dataMap = dataMap;
		}
	}
	 public static boolean isExpires(String  token) {
		 	Token tokenObject=getTokenObject(token);
		 	if(tokenObject==null){
		 		return false;
		 	}
	        return (tokenObject.getRefreshTime() + tokenObject.getExpires()) > System.currentTimeMillis();
	 }
}
