package com.iiifi.framework.server.usercenter.modules.api;

import com.iiifi.framework.server.common.common.result.CommonParameters;


public interface SendCodeService {
	public String sendCode(CommonParameters commonParameters,String phone, String serviceType);
}
