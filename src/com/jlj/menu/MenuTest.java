package com.jlj.menu;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jlj.util.CommonUtil;
import com.jlj.util.MenuUtil;
import com.jlj.util.Token;

public class MenuTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Logger log = LoggerFactory.getLogger(MenuTest.class);
		log.info("test");
//		//第三方用户唯一凭证
//		String appId = "wx0ea5802468b284a6";
//		//第三方用户唯一凭证秘钥
//		String appSecret = "edb152956778e3ab6b12d0a47b51ecfe";
//		//调用接口获取凭证
//		Token token = CommonUtil.getToken(appId, appSecret);
//		
//		if(null!= token){
//			//创建菜单
//			boolean result = MenuUtil.createMenu(MenuManager.getMenu(), token.getAccessToken());
//			
//			//判断菜单创建结果
//			if(result){
//				log.info("菜单创建成功！");
//			}else{
//				log.info("菜单创建失败！");
//			}
//		}
	}

}
