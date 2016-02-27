package com.jlj.message.resp;
/**
 * 响应语音-高级接口
 * @author John
 *
 */
public class VoiceMessage extends BaseMessage {
	//语音
	private Voice Voice;

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
	}
	
	
}
