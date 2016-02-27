package com.jlj.message.resp;
/**
 * 响应视频--高级接口
 * @author John
 *
 */
public class VideoMessage extends BaseMessage {
	private Video Video;

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}
	
}
