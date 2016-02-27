package com.lq.vxin.bean;

import java.util.List;

/**
 * @author from lq 2015/3/26
 * 已关注当前微信公众平台的用户列表类
 * 正确时返回JSON数据包：
	{"total":2,"count":2,"data":{"openid":["","OPENID1","OPENID2"]},"next_openid":"NEXT_OPENID"}
 *
 */
public class WeixinUserList {
	
	private int total;
	private int count;
	private List data;
	private String next_openid;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	
	public String getNext_openid() {
		return next_openid;
	}
	public void setNext_openid(String next_openid) {
		this.next_openid = next_openid;
	}
	
	

}
