package com.jlj.message.req;

/**
 * 视频消息
 * 
 * @author jsjlj
 * @date 2014-06-24
 */
public class VideoMessage extends BaseMessage {
	// 媒体ID
	private String MediaId;
	// 视频消息缩略图的媒体id
	private String ThumbMediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

	
}
