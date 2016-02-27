package com.jlj.message.event;
/**
 * 事件基类--接收事件推送(SubscribeEvent都通用，MenuEvent是订阅号微信认证以上，其他是高级接口中的事件类型)
 * @author John
 *
 */
public class BaseEvent {
	//开发者微信号
	private String ToUserName;
	//发送方账号（一个OpenID）
	private String FromUserName;
	//消息创建时间（整型）
	private long CreateTime;
	//消息类型(event)
	private String MsgType;
	//事件类型(subscribe/unsubscribe/scan/LOCATION/CLICK)
	private String Event;
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getEvent() {
		return Event;
	}
	public void setEvent(String event) {
		Event = event;
	}
	
	
}
