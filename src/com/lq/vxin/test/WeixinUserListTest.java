package com.lq.vxin.test;

import org.apache.log4j.Logger;

import com.lq.vxin.bean.AccessToken;
import com.lq.vxin.bean.WeixinUser;
import com.lq.vxin.bean.WeixinUserList;
import com.lq.vxin.util.AppUtil;

public class WeixinUserListTest {

	private static Logger log = Logger.getLogger(WeixinUserListTest.class);

	public static void main(String[] args) {

		// 第三方用户唯一凭证
		String appId = AppUtil.getAppID();
		// 第三方用户唯一凭证密钥
		String appSecret = AppUtil.getAppSecret();

		// 调用接口获取access_token
		AccessToken at = AppUtil.getAccessToken(appId, appSecret);

		if (null != at) {
			WeixinUserList wxuserlist = AppUtil.getWxUserList( at.getToken());
		}
	}
	

}
