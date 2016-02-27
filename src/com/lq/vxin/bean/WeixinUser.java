package com.lq.vxin.bean;

/**
 * @author from lq 2015/3/26
 * 已关注当前微信公众平台的用户类
 *
 */
public class WeixinUser {
	
	private int subscribe;
	private String openid;
	private String nickname;
	private int sex;
	private  String city;
	private String country;
	private String province;
	private String language;
	private String headimgurl;
	private long subscribe_time;
	private String unionid;
	
	
	public int getSubscribe() {
		return subscribe;
	}
	public String getOpenid() {
		return openid;
	}
	public String getNickname() {
		return nickname;
	}
	public int getSex() {
		return sex;
	}
	public String getCity() {
		return city;
	}
	public String getCountry() {
		return country;
	}
	public String getProvince() {
		return province;
	}
	public String getLanguage() {
		return language;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public long getSubscribe_time() {
		return subscribe_time;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setSubscribe(int subscribe) {
		this.subscribe = subscribe;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public void setSubscribe_time(long subscribe_time) {
		this.subscribe_time = subscribe_time;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
	
	
	
}
