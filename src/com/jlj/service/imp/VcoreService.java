package com.jlj.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.jlj.dao.IAutoresDao;
import com.jlj.dao.ICustommenuDao;
import com.jlj.dao.IFodderDao;
import com.jlj.dao.IGuanzhuresDao;
import com.jlj.dao.IKeyresDao;
import com.jlj.dao.IMemberDao;
import com.jlj.dao.IReqmessageDao;
import com.jlj.dao.IResmessageDao;
import com.jlj.message.resp.Article;
import com.jlj.message.resp.Music;
import com.jlj.message.resp.MusicMessage;
import com.jlj.message.resp.NewsMessage;
import com.jlj.message.resp.TextMessage;
import com.jlj.model.Autores;
import com.jlj.model.Custommenu;
import com.jlj.model.Fodder;
import com.jlj.model.Fodderarticle;
import com.jlj.model.Guanzhures;
import com.jlj.model.Keyres;
import com.jlj.model.Member;
import com.jlj.model.Reqmessage;
import com.jlj.service.IVcoreService;
import com.jlj.util.EmojiFilter;
import com.jlj.util.MessageUtil;
import com.lq.vxin.bean.AccessToken;
import com.lq.vxin.bean.WeixinUser;
import com.lq.vxin.bean.WeixinUserList;
import com.lq.vxin.util.AppUtil;

/**
 * 核心服务类
 * 
 * @author jsjlj
 * @date 2014-06-24
 */
@Component("vcoreService")
public class VcoreService implements IVcoreService {
	private IReqmessageDao reqmessageDao;
	private IResmessageDao resmessageDao;
	private IMemberDao memberDao;
	private IGuanzhuresDao guanzhuresDao;
	private IFodderDao fodderDao;
	private IAutoresDao autoresDao;
	private ICustommenuDao custommenuDao;
	private IKeyresDao keyresDao;
	private String openid_now;
	private static  Logger logger = LoggerFactory.getLogger(VcoreService.class.getName());
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public String processRequest(HttpServletRequest request,String vxinpublic) {
		Logger log = LoggerFactory.getLogger(VcoreService.class);
		String respMessage = null;
		try {
			String respContent = "请求处理异常，请稍候尝试！";// 默认返回的文本消息内容
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			String fromUserName = requestMap.get("FromUserName");// 发送方帐号（open_id）
			String toUserName = requestMap.get("ToUserName");// 公众帐号
			String msgType = requestMap.get("MsgType");// 消息类型
			String msgId = requestMap.get("MsgId");// 消息ID
			String createTime = requestMap.get("CreateTime");//创建时间
			
			
			// (响应)回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);

			// 文本消息===============================================================
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				//1、所有对该公众账号的请求信息(文本信息)录入数据库reqmessage表格
				Reqmessage reqmessage = new Reqmessage();
				reqmessage.setFromusername(fromUserName);
				reqmessage.setTousername(toUserName);
				reqmessage.setCreatetime(createTime);
				reqmessage.setMsgtype(msgType);
				reqmessage.setMsgid(msgId);
				reqmessage.setSavetype(1);//1文本消息
				reqmessage.setReqtime(new Date());
				String msgContent = requestMap.get("Content");// 客户发来的消息内容
				reqmessage.setContent(msgContent);
				reqmessageDao.save(reqmessage);
				//2、判断消息类型之后给予从数据库中提取相应的回复信息（哪个公众原始ID，哪个关键字key，返回何种信息）
				String queryString  = "from Keyres mo where mo.publickey.publicaccount=:publicaccount ";
				String[] paramNames = new String[]{"publicaccount"};
				Object[] values = new Object[]{vxinpublic};
				List<Keyres> keyreses = keyresDao.queryList(queryString, paramNames, values);
				for (Keyres keyres : keyreses) {
					int fodderid = 0;
					if(msgContent!=null&&msgContent.equals(keyres.getKeytitle())){
						fodderid = keyres.getFodderid();
					}
					if(fodderid!=0){
						//根据resid查询fodder素材
						Fodder fodder = fodderDao.loadById(fodderid);
						if(fodder!=null){
							int savetype = fodder.getSavetype();// 保存类型
							if(savetype==1){//回复文本
								textMessage.setContent(fodder.getContent());
								respMessage = MessageUtil.textMessageToXml(textMessage);
							}else if(savetype==5){//回复音乐
								MusicMessage musicMessage = new MusicMessage();
								musicMessage.setToUserName(fromUserName);
								musicMessage.setFromUserName(toUserName);
								musicMessage.setFuncFlag(0);
								musicMessage.setCreateTime(new Date().getTime());
								musicMessage.setMsgType(fodder.getMsgtype());
								Music music = new Music();
								music.setTitle(fodder.getTitle());
								music.setMusicUrl(fodder.getMusicurl());
								music.setHQMusicUrl(fodder.getHqmusicurl());
								music.setDescription(fodder.getDescription());
//								music.setThumbMediaId(fodder.getThumbmediaid());
								musicMessage.setMusic(music);
								respMessage = MessageUtil.musicMessageToXml(musicMessage);
							}else if(savetype==6){//回复图文
								NewsMessage newsMessage = new NewsMessage();  
				                newsMessage.setToUserName(fromUserName);  
				                newsMessage.setFromUserName(toUserName);  
				                newsMessage.setCreateTime(new Date().getTime());  
				                newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
				                newsMessage.setFuncFlag(0);  
				                int articlecount = fodder.getArticlecount();
				                List<Article> articleList = new ArrayList<Article>(); 
				                if(articlecount>1){
					                List<Fodderarticle> fodderarticles = fodder.getFodderarticles();
					                for (Fodderarticle fodderarticle : fodderarticles) {
					                	Article article = new Article();  
					                    article.setTitle(fodderarticle.getTitle()); 
					                    article.setDescription(fodderarticle.getDescription());  
					                    article.setPicUrl("http://120.26.57.167:8080/jingongzi/"+fodderarticle.getPicurl());  
					                    article.setUrl(fodderarticle.getUrl()+"&openid="+fromUserName+"&frontpa="+vxinpublic); 
					                    articleList.add(article);  
									}
				                }else if(articlecount==1){
				                	Article article = new Article();  
				                    article.setTitle(fodder.getTitle()); 
				                    article.setDescription(fodder.getDescription());  
				                    article.setPicUrl("http://120.26.57.167:8080/jingongzi/"+fodder.getPicurl());  
				                    article.setUrl(fodder.getUrl()+"&openid="+fromUserName+"&frontpa="+vxinpublic); 
				                    articleList.add(article); 
				                }
				                newsMessage.setArticleCount(articlecount);  // 设置图文消息个数  
				                newsMessage.setArticles(articleList);  // 设置图文消息包含的图文集合
				                // 将图文消息对象转换成xml字符串  
				                respMessage = MessageUtil.newsMessageToXml(newsMessage);  
							}
						}
					}
				}
				respContent = "您发送的文本消息我们已收到！";
				
			}
			// 图片消息===============================================================
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				//1、所有请求信息(图片信息)录入数据库reqmessage表格
				Reqmessage reqmessage = new Reqmessage();
				reqmessage.setFromusername(fromUserName);
				reqmessage.setTousername(toUserName);
				reqmessage.setCreatetime(createTime);
				reqmessage.setMsgtype(msgType);
				reqmessage.setMsgid(msgId);
				reqmessage.setSavetype(2);//2图片消息
				reqmessage.setReqtime(new Date());
				String picurl = requestMap.get("PicUrl");//图片链接
				String mediaid = requestMap.get("MediaId");//图片消息媒体id，可以调用多媒体文件下载接口拉取数据
				reqmessage.setPicurl(picurl);
				reqmessage.setMediaid(mediaid);
				reqmessageDao.save(reqmessage);
				//2、判断消息类型之后给予从数据库中提取相应的回复信息
				
				respContent = "您发送的图片消息我们已收到！";
			}
			// 音频消息===============================================================
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				//1、所有请求信息(音频信息)录入数据库reqmessage表格
				Reqmessage reqmessage = new Reqmessage();
				reqmessage.setFromusername(fromUserName);
				reqmessage.setTousername(toUserName);
				reqmessage.setCreatetime(createTime);
				reqmessage.setMsgtype(msgType);
				reqmessage.setMsgid(msgId);
				reqmessage.setSavetype(3);//3音频消息
				reqmessage.setReqtime(new Date());
				String mediaId = requestMap.get("MediaId");// 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
				String format = requestMap.get("Format");// 语音格式，如amr，speex等
				reqmessage.setMediaid(mediaId);
				reqmessage.setFormat(format);
				reqmessageDao.save(reqmessage);
				//2、判断消息类型之后给予从数据库中提取相应的回复信息
				
				respContent = "您发送的音频消息我们已收到！";
			}
			// 视频消息===============================================================
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
				//1、所有请求信息(视频信息)录入数据库reqmessage表格
				Reqmessage reqmessage = new Reqmessage();
				reqmessage.setFromusername(fromUserName);
				reqmessage.setTousername(toUserName);
				reqmessage.setCreatetime(createTime);
				reqmessage.setMsgtype(msgType);
				reqmessage.setMsgid(msgId);
				reqmessage.setSavetype(4);//4视频消息
				reqmessage.setReqtime(new Date());
				String mediaId = requestMap.get("MediaId");//视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
				String thumbMediaId = requestMap.get("ThumbMediaId");//视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
				reqmessage.setMediaid(mediaId);
				reqmessage.setThumbmediaid(thumbMediaId);
				reqmessageDao.save(reqmessage);
				//2、判断消息类型之后给予从数据库中提取相应的回复信息
				
				respContent = "您发送的视频消息我们已收到！";
			}
			// 地理位置消息===============================================================
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				//1、所有请求信息(地理位置信息)录入数据库reqmessage表格
				Reqmessage reqmessage = new Reqmessage();
				reqmessage.setFromusername(fromUserName);
				reqmessage.setTousername(toUserName);
				reqmessage.setCreatetime(createTime);
				reqmessage.setMsgtype(msgType);
				reqmessage.setMsgid(msgId);
				reqmessage.setSavetype(5);//5地理位置
				reqmessage.setReqtime(new Date());
				String lat = requestMap.get("Location_X");
				String lng = requestMap.get("Location_Y");
				String label = requestMap.get("Label");
				String scale = requestMap.get("Scale");
				reqmessage.setLocationX(lat);
				reqmessage.setLocationY(lng);
				reqmessage.setLinklabel(label);
				reqmessage.setScale(scale);
				reqmessageDao.save(reqmessage);
				//2、判断消息类型之后给予从数据库中提取相应的回复信息
				
				respContent = "您发送的地理位置消息我们已收到！";
			}
			// 链接消息===============================================================
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				//1、所有请求信息(链接信息)录入数据库reqmessage表格
				Reqmessage reqmessage = new Reqmessage();
				reqmessage.setFromusername(fromUserName);
				reqmessage.setTousername(toUserName);
				reqmessage.setCreatetime(createTime);
				reqmessage.setMsgtype(msgType);
				reqmessage.setMsgid(msgId);
				reqmessage.setSavetype(6);//6链接
				reqmessage.setReqtime(new Date());
				String title = requestMap.get("Title");//消息标题
				String description = requestMap.get("Description");//消息描述
				String url = requestMap.get("Url");//消息链接
				reqmessage.setTitle(title);
				reqmessage.setUrl(url);
				reqmessage.setDescription(description);
				reqmessageDao.save(reqmessage);
				//2、判断消息类型之后给予从数据库中提取相应的回复信息
				
				respContent = "您发送的链接消息我们已收到！";
			}
			
			// 事件推送===============================================================
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				String eventType = requestMap.get("Event");// 事件类型
				//1、所有请求信息(事件类型)录入数据库reqmessage表格2、判断消息类型之后给予从数据库中提取相应的回复信息
				// 订阅、关注
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					
					addMember(fromUserName,vxinpublic);//from lq 2015//3/27
					
					//3、若是关注公众号，则根据toUserName（公众号原始ID）查询该公众号设置的回复信息，并返回
					String queryString2 = "from Guanzhures mo where mo.publicaccount=:publicaccount";
					String[] paramNames2 = new String[]{"publicaccount"};
					Object[] values2 = new Object[]{vxinpublic};
					//查询关注回复表
					Guanzhures guanzhures = guanzhuresDao.queryByNamedParam(queryString2, paramNames2, values2);
					if(guanzhures!=null){
						//查询关注回复表的素材信息
						Fodder fodder = fodderDao.loadById(guanzhures.getFodderid());
						if(fodder!=null){
							int savetype = fodder.getSavetype();// 保存类型
							if(savetype==1){//回复文本
								textMessage.setContent(fodder.getContent());
								respMessage = MessageUtil.textMessageToXml(textMessage);
							}else if(savetype==5){//回复音乐
								MusicMessage musicMessage = new MusicMessage();
								musicMessage.setToUserName(fromUserName);
								musicMessage.setFromUserName(toUserName);
								musicMessage.setFuncFlag(0);
								musicMessage.setCreateTime(new Date().getTime());
								musicMessage.setMsgType(fodder.getMsgtype());
								Music music = new Music();
								music.setTitle(fodder.getTitle());
								music.setMusicUrl(fodder.getMusicurl());
								music.setHQMusicUrl(fodder.getHqmusicurl());
								music.setDescription(fodder.getDescription());
//								music.setThumbMediaId(fodder.getThumbmediaid());
								musicMessage.setMusic(music);
								respMessage = MessageUtil.musicMessageToXml(musicMessage);
							}else if(savetype==6){//回复图文
								NewsMessage newsMessage = new NewsMessage();  
				                newsMessage.setToUserName(fromUserName);  
				                newsMessage.setFromUserName(toUserName);  
				                newsMessage.setCreateTime(new Date().getTime());  
				                newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
				                newsMessage.setFuncFlag(0);  
				                int articlecount = fodder.getArticlecount();
				                List<Article> articleList = new ArrayList<Article>(); 
				                if(articlecount>1){
					                List<Fodderarticle> fodderarticles = fodder.getFodderarticles();
					                for (Fodderarticle fodderarticle : fodderarticles) {
					                	Article article = new Article();  
					                    article.setTitle(fodderarticle.getTitle()); 
					                    article.setDescription(fodderarticle.getDescription());  
					                    article.setPicUrl("http://120.26.57.167:8080/jingongzi/"+fodderarticle.getPicurl());  
					                    article.setUrl(fodderarticle.getUrl()+"&openid="+fromUserName+"&frontpa="+vxinpublic); 
					                    articleList.add(article);  
									}
				                }else if(articlecount==1){
				                	Article article = new Article();  
				                    article.setTitle(fodder.getTitle()); 
				                    article.setDescription(fodder.getDescription());  
				                    article.setPicUrl("http://120.26.57.167:8080/jingongzi/"+fodder.getPicurl());  
				                    article.setUrl(fodder.getUrl()+"&openid="+fromUserName+"&frontpa="+vxinpublic); 
				                    articleList.add(article); 
				                }
				                newsMessage.setArticleCount(articlecount);  // 设置图文消息个数  
				                newsMessage.setArticles(articleList);  // 设置图文消息包含的图文集合
				                // 将图文消息对象转换成xml字符串  
				                respMessage = MessageUtil.newsMessageToXml(newsMessage);    
							}
						}
					}
					logger.info("---------------------已扫描带参数二维码1--------------");
					//from lq 2015/3/26 这里用来处理扫描二维码的处理
					String qrscene_openid = getQrscene_Openid(requestMap);
					if(qrscene_openid!=null&&!qrscene_openid.equals("")){
//						qrscene_openid = (qrscene_openid.split("_"))[1];
						qrscene_openid = qrscene_openid.substring(qrscene_openid.indexOf("_")+1);
						updateMembers(fromUserName,qrscene_openid);
					}
					
					
				}
				// 取消订阅===============================================================
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				//高级接口：扫描带参数二维码===============================================================
				else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
					// 处理扫描带参数二维码事件
					logger.info("---------------------已扫描带参数二维码2--------------");
					//from lq 2015/3/26 这里用来处理扫描二维码的处理
					String qrscene_openid = getQrscene_Openid(requestMap);
					updateMembers(fromUserName,qrscene_openid);
					textMessage.setContent("扫描成功！请重新进入会员中心！");
					respMessage = MessageUtil.textMessageToXml(textMessage);
				}
				//高级接口：上报地理位置事件===============================================================
				else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
					// 处理上报地理位置事件
				}
				
				// 自定义菜单点击事件===============================================================
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					String queryString = "from Custommenu mo where mo.publicaccount=:publicaccount";
					String[] paramNames = new String[]{"publicaccount"};
					Object[] values = new Object[]{vxinpublic};
					Custommenu custommenu = custommenuDao.queryByNamedParam(queryString, paramNames, values);
					
					String eventKey = requestMap.get("EventKey"); 
					if(custommenu!=null){
						String menu1key="";
						String menu2key="";
						String menu3key="";
						//主菜单
						if(custommenu.getIsend1()==1){
							menu1key = custommenu.getMenu1key();
						}
						if(custommenu.getIsend2()==1){
							menu2key = custommenu.getMenu2key();
						}
						if(custommenu.getIsend3()==1){
							menu3key = custommenu.getMenu3key();
						}
						
						String menu1son1key = custommenu.getMenu1son1key();
						String menu1son2key = custommenu.getMenu1son2key();
						String menu1son3key = custommenu.getMenu1son3key();
						String menu1son4key = custommenu.getMenu1son4key();
						String menu1son5key = custommenu.getMenu1son5key();
						
						String menu2son1key = custommenu.getMenu2son1key();
						String menu2son2key = custommenu.getMenu2son2key();
						String menu2son3key = custommenu.getMenu2son3key();
						String menu2son4key = custommenu.getMenu2son4key();
						String menu2son5key = custommenu.getMenu2son5key();
						
						String menu3son1key = custommenu.getMenu3son1key();
						String menu3son2key = custommenu.getMenu3son2key();
						String menu3son3key = custommenu.getMenu3son3key();
						String menu3son4key = custommenu.getMenu3son4key();
						String menu3son5key = custommenu.getMenu3son5key();
						int resid=0;
						
						if(eventKey!=null&&eventKey.equals(menu1key)){
							resid = custommenu.getMenu1resid();
						}else if(eventKey!=null&&eventKey.equals(menu2key)){
							resid = custommenu.getMenu2resid();
						}else if(eventKey!=null&&eventKey.equals(menu3key)){
							resid = custommenu.getMenu3resid();
						}else if(eventKey!=null&&eventKey.equals(menu1son1key)){
							resid = custommenu.getMenu1son1resid();
						}else if(eventKey!=null&&eventKey.equals(menu1son2key)){
							resid = custommenu.getMenu1son2resid();
						}else if(eventKey!=null&&eventKey.equals(menu1son3key)){
							resid = custommenu.getMenu1son3resid();
						}else if(eventKey!=null&&eventKey.equals(menu1son4key)){
							resid = custommenu.getMenu1son4resid();
						}else if(eventKey!=null&&eventKey.equals(menu1son5key)){
							resid = custommenu.getMenu1son5resid();
						}else if(eventKey!=null&&eventKey.equals(menu2son1key)){
							resid = custommenu.getMenu2son1resid();
						}else if(eventKey!=null&&eventKey.equals(menu2son2key)){
							resid = custommenu.getMenu2son2resid();
						}else if(eventKey!=null&&eventKey.equals(menu2son3key)){
							resid = custommenu.getMenu2son3resid();
						}else if(eventKey!=null&&eventKey.equals(menu2son4key)){
							resid = custommenu.getMenu2son4resid();
						}else if(eventKey!=null&&eventKey.equals(menu2son5key)){
							resid = custommenu.getMenu2son5resid();
						}else if(eventKey!=null&&eventKey.equals(menu3son1key)){
							resid = custommenu.getMenu3son1resid();
						}else if(eventKey!=null&&eventKey.equals(menu3son2key)){
							resid = custommenu.getMenu3son2resid();
						}else if(eventKey!=null&&eventKey.equals(menu3son3key)){
							resid = custommenu.getMenu3son3resid();
						}else if(eventKey!=null&&eventKey.equals(menu3son4key)){
							resid = custommenu.getMenu3son4resid();
						}else if(eventKey!=null&&eventKey.equals(menu3son5key)){
							resid = custommenu.getMenu3son5resid();
						}
						logger.info("自定义菜单-----------------------------------resid="+resid);
						if(resid!=0){
							//根据resid查询fodder素材
							Fodder fodder = fodderDao.loadById(resid);
							if(fodder!=null){
								int savetype = fodder.getSavetype();// 保存类型
								logger.info("-----------------------------------savetype="+savetype);
								if(savetype==1){//回复文本
									textMessage.setContent(fodder.getContent());
									respMessage = MessageUtil.textMessageToXml(textMessage);
								}else if(savetype==5){//回复音乐
									MusicMessage musicMessage = new MusicMessage();
									musicMessage.setToUserName(fromUserName);
									musicMessage.setFromUserName(toUserName);
									musicMessage.setFuncFlag(0);
									musicMessage.setCreateTime(new Date().getTime());
									musicMessage.setMsgType(fodder.getMsgtype());
									Music music = new Music();
									music.setTitle(fodder.getTitle());
									music.setMusicUrl(fodder.getMusicurl());
									music.setHQMusicUrl(fodder.getHqmusicurl());
									music.setDescription(fodder.getDescription());
//									music.setThumbMediaId(fodder.getThumbmediaid());
									musicMessage.setMusic(music);
									respMessage = MessageUtil.musicMessageToXml(musicMessage);
								}else if(savetype==6){//回复图文
									NewsMessage newsMessage = new NewsMessage();  
					                newsMessage.setToUserName(fromUserName);  
					                newsMessage.setFromUserName(toUserName);  
					                newsMessage.setCreateTime(new Date().getTime());  
					                newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
					                newsMessage.setFuncFlag(0);  
					                int articlecount = fodder.getArticlecount();
					                logger.info("-----------------------------------articlecount="+articlecount);
					                List<Article> articleList = new ArrayList<Article>(); 
					                if(articlecount>1){
						                List<Fodderarticle> fodderarticles = fodder.getFodderarticles();
						                for (Fodderarticle fodderarticle : fodderarticles) {
						                	Article article = new Article();  
						                    article.setTitle(fodderarticle.getTitle()); 
						                    article.setDescription(fodderarticle.getDescription());  
						                    article.setPicUrl("http://120.26.57.167:8080/jingongzi/"+fodderarticle.getPicurl());  
						                    article.setUrl(fodderarticle.getUrl()+"&openid="+fromUserName+"&frontpa="+vxinpublic); 
						                    articleList.add(article);  
										}
					                }else if(articlecount==1){
					                	Article article = new Article();  
					                    article.setTitle(fodder.getTitle()); 
					                    article.setDescription(fodder.getDescription());  
					                    article.setPicUrl("http://120.26.57.167:8080/jingongzi/"+fodder.getPicurl());  
					                    article.setUrl(fodder.getUrl()+"&openid="+fromUserName+"&frontpa="+vxinpublic); 
					                    logger.info("-----------------------------------article='"+fodder.getUrl()+"&openid="+fromUserName+"&frontpa="+vxinpublic+"'");
					                    articleList.add(article); 
					                }
					                newsMessage.setArticleCount(articlecount);  // 设置图文消息个数  
					                newsMessage.setArticles(articleList);  // 设置图文消息包含的图文集合
					                logger.info("-----------------------------------articleList.size="+articleList.size());
					                // 将图文消息对象转换成xml字符串  
					                respMessage = MessageUtil.newsMessageToXml(newsMessage);  
					                
								}
							}
						}
						
						
					}
				
				
				}
			}
			//未做处理===============================================================
			if(respMessage==null){
				//自动回复，根据（公众号原始ID）查询该公众号设置的自动回复信息
				String queryString = "from Autores mo where mo.publicaccount=:publicaccount";
				String[] paramNames = new String[]{"publicaccount"};
				Object[] values = new Object[]{vxinpublic};
				Autores autores = autoresDao.queryByNamedParam(queryString, paramNames, values);
				if(autores!=null){
					textMessage.setContent(autores.getContent());
				}else{
					textMessage.setContent(respContent);
				}
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return respMessage;
	}
	
	//存上家 存下家 -from lq 2015/3/27
	private void updateMembers(String fromUserName, String qrscene_openid) {
		//存上家 
		WeixinUser pwxuser = getWeixinUser(fromUserName);
		if(pwxuser!=null){
			String queryString = "from Member mo where mo.openid=:fromUserName";
			String[] paramNames = new String[]{"fromUserName"};
			Object[] values = new Object[]{fromUserName};
			Member member=memberDao.queryByNamedParam(queryString, paramNames, values);
			String nickname = pwxuser.getNickname();
			if(nickname==null||nickname.equals("")){
				member.setRealname("匿名");
			}else{
				nickname = EmojiFilter.filterEmoji(nickname);
				logger.info("---------------------nickname="+nickname);
				member.setRealname(nickname);
			}
			if(member.getPreopenid()==null)
			{
				member.setPreopenid(qrscene_openid);
			}
			memberDao.update(member);
		}
		
		
		//存下家
		WeixinUser nwxuser = getWeixinUser(qrscene_openid);
		if(nwxuser!=null){
			String queryString = "from Member mo where mo.openid=:qrscene_openid";
			String[] paramNames = new String[]{"qrscene_openid"};
			Object[] values = new Object[]{qrscene_openid};
			Member member=memberDao.queryByNamedParam(queryString, paramNames, values);
			if(member.getNextopenids()==null)
			{
				member.setCredit(member.getCredit()+1000);//扫一下加1000积分
				member.setNextopenids(fromUserName+",");
			}
			else 
			{
				if(member.getNextopenids().indexOf(fromUserName)==-1)
				{
					member.setCredit(member.getCredit()+1000);//扫一下加1000积分
					member.setNextopenids(member.getNextopenids()+fromUserName+",");
				}
			}
			memberDao.update(member);
		}
		
	}

	//关注二维码同时插入member-from lq 2015/3/27
	private void addMember(String fromUserName, String vxinpublic) {
		WeixinUser wxuser = getWeixinUser(fromUserName);
		//先检查是否存在该openid和publicaccount
		if(wxuser!=null){
			String queryString = "from Member mo where mo.openid=:openid and mo.publicaccount=:publicaccount";
			String[] paramNames = new String[]{"openid","publicaccount"};
			Object[] values = new Object[]{fromUserName,vxinpublic};
			Member member=memberDao.queryByNamedParam(queryString, paramNames, values);
			if(member==null){
				member = new Member();
				member.setOpenid(fromUserName);
				member.setCreatedate(new Date());
				String nickname = wxuser.getNickname();
				if(nickname==null||nickname.equals("")){
					member.setRealname("匿名");
				}else{
					nickname = EmojiFilter.filterEmoji(nickname);
					logger.info("---------------------nickname="+nickname);
					member.setRealname(nickname);
				}
				member.setPublicaccount(vxinpublic);
				member.setCredit(1000);
				memberDao.save(member);
				
			
			}
		}
		
	}
	
	//获得该关注用户的信息-from lq 2015/3/27
	private WeixinUser getWeixinUser(String fromUserName) {
		WeixinUser wxuser = null;
		String appId = AppUtil.getAppID();
		String appSecret = AppUtil.getAppSecret();
		AccessToken at = AppUtil.getAccessToken(appId, appSecret);
		if (null != at) {
			wxuser = AppUtil.getWxuser(fromUserName, at.getToken());
		}
		return wxuser;
	}

	//获得二维码场景中的Openid 既被扫描方的openid-from lq 2015/3/27
	private String getQrscene_Openid(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		String qrscene_openid = requestMap.get("EventKey");
		logger.info("-----------qrscene_openid="+qrscene_openid);
		
//		String openid = (qrscene_openid.split("_"))[1];
//		logger.info("-----------被被扫描方的openid"+openid);//获得被扫描方的openid
		return qrscene_openid;
	}

	public IReqmessageDao getReqmessageDao() {
		return reqmessageDao;
	}
	@Resource
	public void setReqmessageDao(IReqmessageDao reqmessageDao) {
		this.reqmessageDao = reqmessageDao;
	}

	public IResmessageDao getResmessageDao() {
		return resmessageDao;
	}
	@Resource
	public void setResmessageDao(IResmessageDao resmessageDao) {
		this.resmessageDao = resmessageDao;
	}

	public IMemberDao getMemberDao() {
		return memberDao;
	}
	@Resource
	public void setMemberDao(IMemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public IGuanzhuresDao getGuanzhuresDao() {
		return guanzhuresDao;
	}
	@Resource
	public void setGuanzhuresDao(IGuanzhuresDao guanzhuresDao) {
		this.guanzhuresDao = guanzhuresDao;
	}

	public IFodderDao getFodderDao() {
		return fodderDao;
	}
	@Resource
	public void setFodderDao(IFodderDao fodderDao) {
		this.fodderDao = fodderDao;
	}

	public IAutoresDao getAutoresDao() {
		return autoresDao;
	}

	@Resource
	public void setAutoresDao(IAutoresDao autoresDao) {
		this.autoresDao = autoresDao;
	}

	public ICustommenuDao getCustommenuDao() {
		return custommenuDao;
	}
	@Resource
	public void setCustommenuDao(ICustommenuDao custommenuDao) {
		this.custommenuDao = custommenuDao;
	}

	public IKeyresDao getKeyresDao() {
		return keyresDao;
	}
	@Resource
	public void setKeyresDao(IKeyresDao keyresDao) {
		this.keyresDao = keyresDao;
	}
	
	
	
}
