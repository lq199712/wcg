package com.jlj.message.req;

/**
 * 文本消息
 * 
 * @author jsjlj
 * @date 2014-06-24
 */
public class TextMessage extends BaseMessage {
	// 消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}