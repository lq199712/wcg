package com.lq.vxin.test;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.lq.vxin.bean.AccessToken;
import com.lq.vxin.bean.Actioninfo;
import com.lq.vxin.bean.Scene;
import com.lq.vxin.bean.WeixinQRcode;
import com.lq.vxin.util.AppUtil;


public class QRcodeTest {
	
	private static Logger log = Logger.getLogger(QRcodeTest.class);
	
	
	public static void main(String[] args) {
		log.info("二维码创建开始;");
			
		// 第三方用户唯一凭证
        String appId = AppUtil.getAppID();  
        // 第三方用户唯一凭证密钥
        String appSecret = AppUtil.getAppSecret();  
        
   
        // 调用接口获取access_token
        AccessToken at = AppUtil.getAccessToken(appId, appSecret);  
	
		if (null != at) {  

            // 调用接口创建二维码
			getQrcodeUrl( AppUtil.createQrcode(getQrcode(), at.getToken()));  
            
        
                
        }  
	}
	
	 /** 
     * 组装二维码数据 
     *  
     * @return 
     */  
    private static WeixinQRcode getQrcode()
    {
    	WeixinQRcode qrcode = new WeixinQRcode();
    	//永久二维码
    	Scene scene = new Scene();
    	scene.setScene_str("23520");
    	Actioninfo actioninfo = new Actioninfo();
    	actioninfo.setScene(scene);
    	qrcode.setAction_name("QR_SCENE");
    	qrcode.setAction_info(actioninfo);
    	return qrcode;
    }
    
    /** 
     * 获得二维码地址
     *  
     * @return 
     */ 
	public static void getQrcodeUrl(String url)
	{
		System.out.println(url);
	}

	

}
