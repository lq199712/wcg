package com.lq.vxin.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.jlj.menu.Menu;
import com.jlj.util.MyX509TrustManager;
import com.lq.vxin.bean.AccessToken;

import com.lq.vxin.bean.WeixinQRcode;
import com.lq.vxin.bean.WeixinUser;
import com.lq.vxin.bean.WeixinUserList;

/**
 * app工具类
 * 
 * @author lq
 * @date 2014-12-31
 */
public class AppUtil {

	private static Logger log = Logger.getLogger(AppUtil.class);

	private static String token = "lq1997127";// lq1997127公众号token

	//private static String appID = "wx02757f2750a69d29";// 应用id
	//private static String appSecret = "9d512a6640dbceaa1d938776559f99ed";// 应用秘钥
	public static String appID = "wx6580fac6e343319f";// 金公子应用id
	public static String appSecret = "005f74f62f1df8b6c872640380b97fa2";// 金公子应用秘钥

	/**
	 * 获取access_token
	 * 
	 * @param appid
	 *            凭证
	 * @param appsecret
	 *            密钥
	 * @return
	 */
	// 获取access_token的接口地址（GET） 限200（次/天）
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	public static AccessToken getAccessToken(String appid, String appsecret) {
		AccessToken accessToken = null;

		String requestUrl = access_token_url.replace("APPID", appid).replace(
				"APPSECRET", appsecret);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				log.error("获取token失败 errcode:{" + jsonObject.getInt("errcode")
						+ "} errmsg:{" + jsonObject.getString("errmsg") + "}");
			}
		}
		return accessToken;
	}

	/**
	 * 创建菜单
	 * 
	 * @param menu
	 *            菜单实例
	 * @param accessToken
	 *            有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	// 菜单创建（POST） 限100（次/天）
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	public static int createMenu(Menu menu, String accessToken) {
		int result = 0;

		// 拼装创建菜单的url
		String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		// 调用接口创建菜单
		JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);
		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				log.error("创建菜单失败");
			}
		}

		return result;
	}

	/**
	 * 创建二维码、换取二维码
	 * 
	 * @param qrcode
	 *            二维码实例
	 * @param accessToken
	 *            有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	// 
	public static String qrcode_create_url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
	public static String qrcode_url ="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";
	public static String createQrcode(WeixinQRcode qrcode, String accessToken) {
		// 拼装创建菜单的url
		String url = qrcode_create_url.replace("ACCESS_TOKEN", accessToken);
		// 将二维码对象转换成json字符串
		String jsonQrcode = JSONObject.fromObject(qrcode).toString();
		// 调用接口创建二维码
		JSONObject jsonObject = httpRequest(url, "POST", jsonQrcode);
		
		String realurl = "";
		if (null != jsonObject) {
			if (null != jsonObject.getString("ticket")) {
				realurl = qrcode_url + jsonObject.getString("ticket");
			}
		}
		
		return realurl;
	}
	
	/**
	 * 获取用户基本信息（包括UnionID机制）
	 * 
	 * @param wxuser
	 *            微信用户实例
	 * @param accessToken
	 *            有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	// 
	public static String wxuser_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	public static WeixinUser getWxuser(String  openid, String accessToken) {
		
		WeixinUser wxuser = new WeixinUser();
		// 拼装获取用户信息的url
		String url = wxuser_url.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openid);
		
		// 调用接口获取用户信息借口
		JSONObject jsonObject = httpRequest(url, "GET", null);
		
		if (null != jsonObject) {
			wxuser.setSubscribe(jsonObject.getInt("subscribe"));
			if(jsonObject.getInt("subscribe")==1)
			{
				wxuser.setOpenid(jsonObject.getString("openid"));
				wxuser.setNickname(jsonObject.getString("nickname"));
				wxuser.setSex(jsonObject.getInt("sex"));
				wxuser.setLanguage(jsonObject.getString("language"));
				wxuser.setCity(jsonObject.getString("city"));
				wxuser.setProvince(jsonObject.getString("province"));
				wxuser.setCountry(jsonObject.getString("country"));
				wxuser.setHeadimgurl(jsonObject.getString("headimgurl"));
				wxuser.setSubscribe_time(jsonObject.getLong("subscribe_time"));
				//wxuser.setUnionid(jsonObject.getString("unionid"));//绑定公众平台才能获得
			}
		}
		
		return wxuser;
	}
	
	

	/**
	 * 获取用户列表
	 * 
	 * @param wxuser
	 *            微信用户列表实例
	 * @param accessToken
	 *            有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	// 
	public static String wxuserlist_url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
	
	public static WeixinUserList getWxUserList(String accessToken)
	{
		WeixinUserList wxuserlist = new WeixinUserList();
		// 拼装获取用户信息的url
		String url = wxuserlist_url.replace("ACCESS_TOKEN", accessToken).replace("NEXT_OPENID", "");
		
		// 调用接口获取用户信息借口
		JSONObject jsonObject = httpRequest(url, "GET", null);
		if (null != jsonObject) 
		{
			wxuserlist.setTotal(jsonObject.getInt("total"));
			wxuserlist.setCount(jsonObject.getInt("count"));
			JSONArray data = JSONObject.fromObject(jsonObject.get("data")).getJSONArray("openid");
			List list = new ArrayList<String>(); 
			 for(int i=0; i < data.size(); i++)
			 {
				 list.add(((String)data.get(i)));
			 }
			wxuserlist.setData(list);	
			wxuserlist.setNext_openid(jsonObject.getString("next_openid"));			
		}
		return wxuserlist;
	}
	
	

	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式（GET、POST）
	 * @param outputStr
	 *            提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String requestUrl,
			String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			log.error("Weixin server connection timed out.");
		} catch (Exception e) {
			log.error("https request error:{}", e);
		}
		return jsonObject;
	}

	public static String getAccess_token_url() {

		return access_token_url;
	}

	public static String getToken() {
		return token;
	}

	public static String getAppID() {
		return appID;
	}

	public static String getAppSecret() {
		return appSecret;
	}

}
