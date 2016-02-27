/*package com.jlj.util;



public class SmsWsKit {
	
//	public static void main1(String[] args) {
//		DemoApi1 demoApi1 = new DemoApi1();
//		demoApi1.main(args);
//		
//	}

//	public static void main(String[] args) {
//		StartNotification sn = new StartNotification();
//		EndNotification en = new EndNotification();
//		try {
////			sn.StartNotification("0001","http://127.0.0.1/TestOa/services/ServerTestAdapter","doa","doa","doa");
//			en.endNotification("0001","doa","doa","doa");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public static void main(String[] a){

		//*********通知的启停测试开始*****************
		StartNotification sn = new StartNotification();
		EndNotification en = new EndNotification();
		try {
//			sn.StartNotification("0001","http://127.0.0.1/TestOa/services/ServerTestAdapter","doa","doa","doa");
//			en.endNotification("0001","doa","doa","doa");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//****************结束***********************
		
		//**********短信发送测试开始*********************
//		smsSend("webservice", "0007", "15254124561", "a2email 11 203 04测试了！email 11 203 04测试了！email 11 203 04测试了！email 11 203 04测试了！email 11 203 04测试了！email 11 203 04测试了！", "013", true, "webservice", "webservice");
		smsSend("jlj", "0004", "15861521065", "jlj的测试3！", "015", true, "yxtvoa002", "jlj");
//		smsSend("doa", "0005", "15254124561", "doa 11 203 04测试了！", "106578162", true, "doa", "doa");
//		smsSend("email", "0005", "15254124561", "email 11 203 04测试了！", "013", true, "email", "email");
//		smsSend("myweb", "0005", "15254124561", "11 203 04测试了！", "013", true, "myweb", "myweb");
//		smsSend("doa", "0004", "15254124561", "11 203 04测试了！", "015", true, "doa", "doa");
//		smsSend("doa","0004","15254124561","203新版本webservice测试 04测试了！","doa","doa");
//		smsSend("oapwd","0004","15254124561","新版本webservice测试 04测试了！","oa2010","oa");
//		smsSend("123456","0007","15069102676","测试了！","07",true);
//		smsSend("123456","0007","15069157334","测试了！","07",false,"ASCII","Normal");
		//***********短信发送测试结束******************************
		
		//***********短信获取发送状态测试开始******************************
//		getSmsDelivery("doa","0007","121548","doa","doa");
		//***********短信获取发送状态测试结束******************************
		
		//***********上行短信获取测试开始******************************
//		getReceiveSms("123456","0007","doa","doa");
		//***********上行短信获取测试结束******************************
		
		//*************wap push短信发送测试开始****************************************
//		sendPush("doa", "0005", "15254124561", "demo doa push测试了！", "106579812", true, "http://127.0.0.1","doa", "doa");
//		getPushDelivery("doa","0007","624","doa","doa");
		//*************wap push短信发送测试结束***************************************
	}
	public static void userSend(String phones,String content){
		StartNotification sn = new StartNotification();
		EndNotification en = new EndNotification();
		try {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//****************结束***********************
		
		//**********短信发送开始*********************
		smsSend("jlj", "0004", phones, content, "015", true, "yxtvoa002", "jlj");
		
	}
	*//**
	 * 发送短信
	 * @param password 接口密码
	 * @param appId 应用ID
	 * @param destNum 目标手机号码
	 * @param message 发送内容
	 *//*
	public static void smsSend(String password ,String appId,String destNum,String message,String intfid,String intfname){
		SmsSend sms = new SmsSend(password,appId,destNum,message,intfid,intfname);
		  String value = sms.send();
		System.out.println("发送短信后返回的序列号为："+value);
	}
	
	*//**
	 * 发送短信
	 * @param password 接口密码
	 * @param appid  应用ID
	 * @param destNum 目标手机号码
	 * @param msg 发送内容
	 * @param extendcode 扩展码
	 * @param deliveryResult 回执标志 true返回回执；false不返回回执
	 * 
	 *//*
	public static void smsSend(String password,String appid,String destNum,String msg,String extendcode,
			boolean deliveryResult,String intfid,String intfname){
		
		//构造对象
		SmsSend sms = new SmsSend(password,appid,destNum,msg,extendcode,deliveryResult,intfid,intfname);
		//返回结果
		  String value = sms.send();
		  
		System.out.println("发送短信后返回的序列号为："+value);
	}
	
	*//**
	 * 发送短信（全参）
	 * @param password 接口密码
	 * @param appid  应用ID
	 * @param destNum   目标手机号码
	 * @param msg  发送内容
	 * @param extendcode 扩展码
	 * @param deliveryResult 回执标志 true返回回执；false不返回回执
	 * @param messageFormat  编码
	 * @param sendMethodType 发送类型
	 *//*
	public static void smsSend(String password,String appid,String destNum,String msg,String extendcode,
			boolean deliveryResult,String messageFormat,String sendMethodType,String intfid,String intfname){
		SmsSend sms = new SmsSend(password,appid,destNum,msg,extendcode,deliveryResult,messageFormat,sendMethodType,intfid,intfname);
		  String value = sms.send();
		System.out.println("发送短信后返回的序列号为："+value);
	}
	
	*//**
	 * 获取短信回执状态
	 * @param password 接口密码可以为空
	 * @param appId  应用ID不能为空
	 * @param requestIdentifier  待查询短信的序列号不能空
	 *//*
	public static void getSmsDelivery(String password,String appId,String requestIdentifier,String intfid,String intfname){
		GetSmsDelivery getSmsDelivery = new GetSmsDelivery(password,appId,requestIdentifier,intfid,intfname);
		org.csapi.www.schema.sms.DeliveryInformation[] information = getSmsDelivery.getDeliverySms().getDeliveryStatus();
		
		if(information!=null){
			for(int i=0;i<information.length;i++){
				System.out.println("短信回执的状态是："+information[i].getDeliveryStatus());
			}
			
		}else {
			System.out.println("没有相关信息");
		}
	}
	
	*//**
	 * 获取上行短信
	 * @param password 接口密码可以为空
	 * @param appId   应用ID不能为空
	 *//*
	public static void getReceiveSms(String password,String appId,String intfid,String intfname){
		GetReceiveSms getReceiveSms = new GetReceiveSms(password,appId,intfid,intfname);
		SMSMessage[] value=getReceiveSms.getReSms().getReceivedSms();
		if(value!=null){
			for(int i=0;i<value.length;i++){
				System.out.println("上行短信的内容是："+value[i].getMessage());
			}
		}else{
			System.out.println("没有相关信息");
		}
	}
	
	*//**
	 * 
	 * @param passw 接口密码
	 * @param appid 应用id
	 * @param destNum 下发手机号码
	 * @param subject 
	 * @param extendcode
	 * @param receiptRequest
	 * @param targetURL
	 * @param sendMethodType
	 * @param intfid
	 * @param intfname
	 *//*
	public static void sendPush(String passw,String appid,String destNum,String subject,String extendcode,
			boolean receiptRequest,String targetURL,String intfid,String intfname){
		
		PushSend pushSend = new PushSend(passw,appid,destNum,subject,extendcode,receiptRequest,targetURL,intfid,intfname);
		 String value = pushSend.send();
		 System.out.println("push发送短信 value = "+value);
	}

	*//**
	 * 获取短信回执状态
	 * @param password 接口密码可以为空
	 * @param appId  应用ID不能为空
	 * @param requestIdentifier  待查询短信的序列号不能空
	 *//*
	public static void getPushDelivery(String password,String appId,String requestIdentifier,String intfid,String intfname){
		GetPushDelivery getSmsDelivery = new GetPushDelivery(password,appId,requestIdentifier,intfid,intfname);
		org.csapi.www.schema.wap.DeliveryInformation[] information = getSmsDelivery.getDeliveryPush().getResult();
		
		if(information!=null){
			for(int i=0;i<information.length;i++){
				System.out.println("短信回执的状态是："+information[i].getStatus());
			}
			
		}else {
			System.out.println("没有相关信息");
		}
	}
}
*/