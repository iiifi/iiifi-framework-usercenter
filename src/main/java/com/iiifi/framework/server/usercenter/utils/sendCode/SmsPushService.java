package com.iiifi.framework.server.usercenter.utils.sendCode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 短信服务
 * 
 * @author mfe
 *
 */
@Service
public class SmsPushService {
	/**
	 * 验证码有效时间 单位：秒
	 */
	@Value(value = "${sms.second}")
	private String second;
	/**
	 * 发送失败重试次数
	 */
	@Value(value = "${sms.retry.times}")
	private String retryTime;
	/**
	 * 短信账号
	 */
	@Value(value = "${sms.name}")
	private String account;
	/**
	 * 短信密码
	 */
	@Value(value = "${sms.pwd}")
	private String password;
	/**
	 * 短信模版
	 */
	@Value(value = "${sms.smscode.templat}")
	private String content;
	/**
	 * /是否需要状态报告，需要true，不需要false
	 */
	@Value(value = "${sms.status}")
	private String status;
	/**
	 * 产品ID
	 */
	@Value(value = "${sms.product}")
	private String product;
	/**
	 * 扩展码
	 */
	@Value(value = "${sms.extno}")
	private String extno;
	/**
	 * 短信请求地址
	 */
	@Value(value = "${sms.serviceURL}")
	private String serverURL;
	
	@Value(value = "${sms.apikey}")
	private String apikey;
	

	/**
	 * 短信发送
	 * 
	 * @param smscode
	 */
	public String send(String phone,String content) {
		try {
			sendSms(phone, content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}
	public static void main(String[] args){
		try {
			HttpSender.batchSend("http://222.73.117.156/msg/HttpBatchSendSM", "vip_liuyi", "Tch513090", "13683238601", "对哦，这样好的点子我怎么没想到呢……嗯，伊城君定会认真改善的！么么哒~~  感谢您的意见反馈 ",true, "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private String sendSms(String phone,String content) throws Exception{
		String str= HttpSender.batchSend(serverURL, account, password, phone, content, Boolean.parseBoolean(status), extno);
		return str.split("\n")[0].split(",")[1];
	}
}
