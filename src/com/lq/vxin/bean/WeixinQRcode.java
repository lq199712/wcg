package com.lq.vxin.bean;

import com.lq.vxin.bean.Actioninfo;


/**
 * 微信二维码类
 * POST数据例子：{"expire_seconds": 1800, "action_name": "QR_SCENE", "action_info": {"scene": {"scene_id": 123}}}
 * 	from lq 2015/3/26			
 */
public class WeixinQRcode {

	private String expire_seconds;
	private String action_name;
	private Actioninfo action_info;

	public String getExpire_seconds() {
		return expire_seconds;
	}

	public String getAction_name() {
		return action_name;
	}

	public Actioninfo getAction_info() {
		return action_info;
	}

	public void setExpire_seconds(String expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}

	public void setAction_info(Actioninfo action_info) {
		this.action_info = action_info;
	}

}
