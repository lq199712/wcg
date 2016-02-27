package com.jlj.message.resp;

/**
 * 音乐消息
 * 
 * @author jsjlj
 * @date 2014-06-24
 */
public class MusicMessage extends BaseMessage {
	// 音乐
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}