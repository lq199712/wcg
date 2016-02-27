package com.jlj.menu;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jlj.model.Custommenu;

public class MenuManager {
	private static Logger log = LoggerFactory.getLogger(MenuManager.class);
	
	public static Menu getMenu(){
		ClickButton btn11 = new ClickButton();
		btn11.setName("开源中国");
		btn11.setType("click");
		btn11.setKey("oschina");
		
		ClickButton btn12 = new ClickButton();
		btn12.setName("ITeye");
		btn12.setType("click");
		btn12.setKey("iteye");
		
		ViewButton btn13 = new ViewButton();
		btn13.setName("CocoaChina");
		btn13.setType("view");
		btn13.setUrl("http://www.iteye.com");
		
		ViewButton btn21 = new ViewButton();
		btn21.setName("淘宝");
		btn21.setType("view");
		btn21.setUrl("http://m.taobao.com");
		
		ViewButton btn22 = new ViewButton();
		btn22.setName("京东");
		btn22.setType("view");
		btn22.setUrl("http://m.jd.com");
		
		ViewButton btn23 = new ViewButton();
		btn23.setName("唯品会");
		btn23.setType("view");
		btn23.setUrl("http://m.vipshop.com");
		
		ViewButton btn24 = new ViewButton();
		btn24.setName("当当网");
		btn24.setType("view");
		btn24.setUrl("http://m.dangdang.com");
		
		ViewButton btn25 = new ViewButton();
		btn25.setName("苏宁易购");
		btn25.setType("view");
		btn25.setUrl("http://m.suning.com");
		
		ViewButton btn31 = new ViewButton();
		btn31.setName("多泡");
		btn31.setType("view");
		btn31.setUrl("http://www.duopao.com");
		
		ViewButton btn32 = new ViewButton();
		btn32.setName("一窝88");
		btn32.setType("view");
		btn32.setUrl("http://www.yi588.com");
		
		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("技术交流");
//		mainBtn1.setSub_button(new Button[]{btn11,btn12,btn13});
		
		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("购物");
//		mainBtn2.setSub_button(new Button[]{btn21,btn22,btn23,btn24,btn25});
		
		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("网页游戏");
//		mainBtn3.setSub_button(new Button[]{btn31,btn32});
		
		Menu menu = new Menu();
		menu.setButton(new Button[]{mainBtn1, mainBtn2, mainBtn3});
		
		return menu;
	}
	
//	public static Menu testShanyouhuMenu(){
//		ClickButton btn11 = new ClickButton();
//		btn11.setName("微信营销");
//		btn11.setType("click");
//		btn11.setKey("wxyx");
//		
//		ClickButton btn12 = new ClickButton();
//		btn12.setName("精准营销");
//		btn12.setType("click");
//		btn12.setKey("jzyx");
//		
//		
//		ViewButton btn21 = new ViewButton();
//		btn21.setName("微官网");
//		btn21.setType("view");
//		btn21.setUrl("http://jsjlj.sinaapp.com/shanghai/shanyohu.jsp");
//		
//		ClickButton btn22 = new ClickButton();
//		btn22.setName("自定义菜单");
//		btn22.setType("click");
//		btn22.setKey("zdycd");
//		
//		ClickButton btn23 = new ClickButton();
//		btn23.setName("微游戏");
//		btn23.setType("click");
//		btn23.setKey("wyx");
//		
//		ViewButton btn24 = new ViewButton();
//		btn24.setName("微会员卡");
//		btn24.setType("view");
//		btn24.setUrl("http://jsjlj.sinaapp.com/travelforweixin/index.html");
//		
//		ClickButton btn25 = new ClickButton();
//		btn25.setName("360度全景展示");
//		btn25.setType("click");
//		btn25.setKey("360qjzs");
//		
//		ClickButton btn31 = new ClickButton();
//		btn31.setName("关于我们");
//		btn31.setType("click");
//		btn31.setKey("gywm");
//		
//		ClickButton btn32 = new ClickButton();
//		btn32.setName("业务联系");
//		btn32.setType("click");
//		btn32.setKey("ywlx");
//		
//		ComplexButton mainBtn1 = new ComplexButton();
//		mainBtn1.setName("服务模块");
//		mainBtn1.setSub_button(new Button[]{btn11,btn12});
//		
//		ComplexButton mainBtn2 = new ComplexButton();
//		mainBtn2.setName("效果展示");
//		mainBtn2.setSub_button(new Button[]{btn21,btn22,btn23,btn24,btn25});
//		
//		ComplexButton mainBtn3 = new ComplexButton();
//		mainBtn3.setName("互盈互利");
//		mainBtn3.setSub_button(new Button[]{btn31,btn32});
//		
//		Menu menu = new Menu();
//		menu.setButton(new Button[]{mainBtn1, mainBtn2, mainBtn3});
//		
//		return menu;
//	}

	public static Menu createMenu(Custommenu custommenu) {
		//第一列子菜单名称
		String menu1son1=custommenu.getMenu1son1();
		String menu1son2=custommenu.getMenu1son2();
		String menu1son3=custommenu.getMenu1son3();
		String menu1son4=custommenu.getMenu1son4();
		String menu1son5=custommenu.getMenu1son5();
		//第二列子菜单名称
		String menu2son1=custommenu.getMenu2son1();
		String menu2son2=custommenu.getMenu2son2();
		String menu2son3=custommenu.getMenu2son3();
		String menu2son4=custommenu.getMenu2son4();
		String menu2son5=custommenu.getMenu2son5();
		//第三列子菜单名称
		String menu3son1=custommenu.getMenu3son1();
		String menu3son2=custommenu.getMenu3son2();
		String menu3son3=custommenu.getMenu3son3();
		String menu3son4=custommenu.getMenu3son4();
		String menu3son5=custommenu.getMenu3son5();
		//第一列按钮
		List<Button> buttons1=new ArrayList<Button>();
		
		
		if(menu1son5!=null&&!menu1son5.equals("")){
			String menu1son5type =custommenu.getMenu1son5type();
			String menu1son5key = custommenu.getMenu1son5key();
			String menu1son5url = custommenu.getMenu1son5url();
			if(menu1son5type!=null&&menu1son5type.equals("click")){
				ClickButton btn15 = new ClickButton();
				btn15.setName(menu1son5);
				btn15.setType(menu1son5type);
				btn15.setKey(menu1son5key);
				buttons1.add(btn15);
			}else if(menu1son5type!=null&&menu1son5type.equals("view")){
				ViewButton btn15 = new ViewButton();
				btn15.setName(menu1son5);
				btn15.setType(menu1son5type);
				btn15.setUrl(menu1son5url);
				buttons1.add(btn15);
			}
		}
		if(menu1son4!=null&&!menu1son4.equals("")){
			String menu1son4type =custommenu.getMenu1son4type();
			String menu1son4key = custommenu.getMenu1son4key();
			String menu1son4url = custommenu.getMenu1son4url();
			if(menu1son4type!=null&&menu1son4type.equals("click")){
				ClickButton btn14 = new ClickButton();
				btn14.setName(menu1son4);
				btn14.setType(menu1son4type);
				btn14.setKey(menu1son4key);
				buttons1.add(btn14);
			}else if(menu1son4type!=null&&menu1son4type.equals("view")){
				ViewButton btn14 = new ViewButton();
				btn14.setName(menu1son4);
				btn14.setType(menu1son4type);
				btn14.setUrl(menu1son4url);
				buttons1.add(btn14);
			}
		}
		if(menu1son3!=null&&!menu1son3.equals("")){
			String menu1son3type =custommenu.getMenu1son3type();
			String menu1son3key = custommenu.getMenu1son3key();
			String menu1son3url = custommenu.getMenu1son3url();
			if(menu1son3type!=null&&menu1son3type.equals("click")){
				ClickButton btn13 = new ClickButton();
				btn13.setName(menu1son3);
				btn13.setType(menu1son3type);
				btn13.setKey(menu1son3key);
				buttons1.add(btn13);
			}else if(menu1son3type!=null&&menu1son3type.equals("view")){
				ViewButton btn13 = new ViewButton();
				btn13.setName(menu1son3);
				btn13.setType(menu1son3type);
				btn13.setUrl(menu1son3url);
				buttons1.add(btn13);
			}
		}
		if(menu1son2!=null&&!menu1son2.equals("")){
			String menu1son2type =custommenu.getMenu1son2type();
			String menu1son2key = custommenu.getMenu1son2key();
			String menu1son2url = custommenu.getMenu1son2url();
			if(menu1son2type!=null&&menu1son2type.equals("click")){
				ClickButton btn12 = new ClickButton();
				btn12.setName(menu1son2);
				btn12.setType(menu1son2type);
				btn12.setKey(menu1son2key);
				buttons1.add(btn12);
			}else if(menu1son2type!=null&&menu1son2type.equals("view")){
				ViewButton btn12 = new ViewButton();
				btn12.setName(menu1son2);
				btn12.setType(menu1son2type);
				btn12.setUrl(menu1son2url);
				buttons1.add(btn12);
			}
		}
		if(menu1son1!=null&&!menu1son1.equals("")){
			String menu1son1type =custommenu.getMenu1son1type();
			String menu1son1key = custommenu.getMenu1son1key();
			String menu1son1url = custommenu.getMenu1son1url();
			if(menu1son1type!=null&&menu1son1type.equals("click")){
				ClickButton btn11 = new ClickButton();
				btn11.setName(menu1son1);
				btn11.setType(menu1son1type);
				btn11.setKey(menu1son1key);
				buttons1.add(btn11);
			}else if(menu1son1type!=null&&menu1son1type.equals("view")){
				ViewButton btn11 = new ViewButton();
				btn11.setName(menu1son1);
				btn11.setType(menu1son1type);
				btn11.setUrl(menu1son1url);
				buttons1.add(btn11);
			}
		}
		
		//第二列
		List<Button> buttons2=new ArrayList<Button>();
		
		
		
		
		if(menu2son5!=null&&!menu2son5.equals("")){
			String menu2son5type =custommenu.getMenu2son5type();
			String menu2son5key = custommenu.getMenu2son5key();
			String menu2son5url = custommenu.getMenu2son5url();
			if(menu2son5type!=null&&menu2son5type.equals("click")){
				ClickButton btn25 = new ClickButton();
				btn25.setName(menu2son5);
				btn25.setType(menu2son5type);
				btn25.setKey(menu2son5key);
				buttons2.add(btn25);
			}else if(menu2son5type!=null&&menu2son5type.equals("view")){
				ViewButton btn25 = new ViewButton();
				btn25.setName(menu2son5);
				btn25.setType(menu2son5type);
				btn25.setUrl(menu2son5url);
				buttons2.add(btn25);
			}
		}
		if(menu2son4!=null&&!menu2son4.equals("")){
			String menu2son4type =custommenu.getMenu2son4type();
			String menu2son4key = custommenu.getMenu2son4key();
			String menu2son4url = custommenu.getMenu2son4url();
			if(menu2son4type!=null&&menu2son4type.equals("click")){
				ClickButton btn24 = new ClickButton();
				btn24.setName(menu2son4);
				btn24.setType(menu2son4type);
				btn24.setKey(menu2son4key);
				buttons2.add(btn24);
			}else if(menu2son4type!=null&&menu2son4type.equals("view")){
				ViewButton btn24 = new ViewButton();
				btn24.setName(menu2son4);
				btn24.setType(menu2son4type);
				btn24.setUrl(menu2son4url);
				buttons2.add(btn24);
			}
		}
		if(menu2son3!=null&&!menu2son3.equals("")){
			String menu2son3type =custommenu.getMenu2son3type();
			String menu2son3key = custommenu.getMenu2son3key();
			String menu2son3url = custommenu.getMenu2son3url();
			if(menu2son3type!=null&&menu2son3type.equals("click")){
				ClickButton btn23 = new ClickButton();
				btn23.setName(menu2son3);
				btn23.setType(menu2son3type);
				btn23.setKey(menu2son3key);
				buttons2.add(btn23);
			}else if(menu2son3type!=null&&menu2son3type.equals("view")){
				ViewButton btn23 = new ViewButton();
				btn23.setName(menu2son3);
				btn23.setType(menu2son3type);
				btn23.setUrl(menu2son3url);
				buttons2.add(btn23);
			}
		}
		if(menu2son2!=null&&!menu2son2.equals("")){
			String menu2son2type =custommenu.getMenu2son2type();
			String menu2son2key = custommenu.getMenu2son2key();
			String menu2son2url = custommenu.getMenu2son2url();
			if(menu2son2type!=null&&menu2son2type.equals("click")){
				ClickButton btn22 = new ClickButton();
				btn22.setName(menu2son2);
				btn22.setType(menu2son2type);
				btn22.setKey(menu2son2key);
				buttons2.add(btn22);
			}else if(menu2son2type!=null&&menu2son2type.equals("view")){
				ViewButton btn22 = new ViewButton();
				btn22.setName(menu2son2);
				btn22.setType(menu2son2type);
				btn22.setUrl(menu2son2url);
				buttons2.add(btn22);
			}
		}
		if(menu2son1!=null&&!menu2son1.equals("")){
			String menu2son1type =custommenu.getMenu2son1type();
			String menu2son1key = custommenu.getMenu2son1key();
			String menu2son1url = custommenu.getMenu2son1url();
			if(menu2son1type!=null&&menu2son1type.equals("click")){
				ClickButton btn21 = new ClickButton();
				btn21.setName(menu2son1);
				btn21.setType(menu2son1type);
				btn21.setKey(menu2son1key);
				buttons2.add(btn21);
			}else if(menu2son1type!=null&&menu2son1type.equals("view")){
				ViewButton btn21 = new ViewButton();
				btn21.setName(menu2son1);
				btn21.setType(menu2son1type);
				btn21.setUrl(menu2son1url);
				buttons2.add(btn21);
			}
		}
		//第三列
		List<Button> buttons3=new ArrayList<Button>();
		
		
		
		
		if(menu3son5!=null&&!menu3son5.equals("")){
			String menu3son5type =custommenu.getMenu3son5type();
			String menu3son5key = custommenu.getMenu3son5key();
			String menu3son5url = custommenu.getMenu3son5url();
			if(menu3son5type!=null&&menu3son5type.equals("click")){
				ClickButton btn35 = new ClickButton();
				btn35.setName(menu3son5);
				btn35.setType(menu3son5type);
				btn35.setKey(menu3son5key);
				buttons3.add(btn35);
			}else if(menu3son5type!=null&&menu3son5type.equals("view")){
				ViewButton btn35 = new ViewButton();
				btn35.setName(menu3son5);
				btn35.setType(menu3son5type);
				btn35.setUrl(menu3son5url);
				buttons3.add(btn35);
			}
		}
		if(menu3son4!=null&&!menu3son4.equals("")){
			String menu3son4type =custommenu.getMenu3son4type();
			String menu3son4key = custommenu.getMenu3son4key();
			String menu3son4url = custommenu.getMenu3son4url();
			if(menu3son4type!=null&&menu3son4type.equals("click")){
				ClickButton btn34 = new ClickButton();
				btn34.setName(menu3son4);
				btn34.setType(menu3son4type);
				btn34.setKey(menu3son4key);
				buttons3.add(btn34);
			}else if(menu3son4type!=null&&menu3son4type.equals("view")){
				ViewButton btn34 = new ViewButton();
				btn34.setName(menu3son4);
				btn34.setType(menu3son4type);
				btn34.setUrl(menu3son4url);
				buttons3.add(btn34);
			}
		}
		if(menu3son3!=null&&!menu3son3.equals("")){
			String menu3son3type =custommenu.getMenu3son3type();
			String menu3son3key = custommenu.getMenu3son3key();
			String menu3son3url = custommenu.getMenu3son3url();
			if(menu3son3type!=null&&menu3son3type.equals("click")){
				ClickButton btn33 = new ClickButton();
				btn33.setName(menu3son3);
				btn33.setType(menu3son3type);
				btn33.setKey(menu3son3key);
				buttons3.add(btn33);
			}else if(menu3son3type!=null&&menu3son3type.equals("view")){
				ViewButton btn33 = new ViewButton();
				btn33.setName(menu3son3);
				btn33.setType(menu3son3type);
				btn33.setUrl(menu3son3url);
				buttons3.add(btn33);
			}
		}
		
		if(menu3son2!=null&&!menu3son2.equals("")){
			String menu3son2type =custommenu.getMenu3son2type();
			String menu3son2key = custommenu.getMenu3son2key();
			String menu3son2url = custommenu.getMenu3son2url();
			if(menu3son2type!=null&&menu3son2type.equals("click")){
				ClickButton btn32 = new ClickButton();
				btn32.setName(menu3son2);
				btn32.setType(menu3son2type);
				btn32.setKey(menu3son2key);
				buttons3.add(btn32);
			}else if(menu3son2type!=null&&menu3son2type.equals("view")){
				ViewButton btn32 = new ViewButton();
				btn32.setName(menu3son2);
				btn32.setType(menu3son2type);
				btn32.setUrl(menu3son2url);
				buttons3.add(btn32);
			}
		}
		
		if(menu3son1!=null&&!menu3son1.equals("")){
			String menu3son1type =custommenu.getMenu3son1type();
			String menu3son1key = custommenu.getMenu3son1key();
			String menu3son1url = custommenu.getMenu3son1url();
			if(menu3son1type!=null&&menu3son1type.equals("click")){
				ClickButton btn31 = new ClickButton();
				btn31.setName(menu3son1);
				btn31.setType(menu3son1type);
				btn31.setKey(menu3son1key);
				buttons3.add(btn31);
			}else if(menu3son1type!=null&&menu3son1type.equals("view")){
				ViewButton btn31 = new ViewButton();
				btn31.setName(menu3son1);
				btn31.setType(menu3son1type);
				btn31.setUrl(menu3son1url);
				buttons3.add(btn31);
			}
		}
		
		String menu1 = custommenu.getMenu1();
		String menu2 = custommenu.getMenu2();
		String menu3 = custommenu.getMenu3();
		
		if(menu1!=null&&!menu1.equals("")&&menu2!=null&&!menu2.equals("")&&menu3!=null&&!menu3.equals("")){
			Button[] btnBig = new Button[3];//一级菜单
			
			if(custommenu.getIsend1()==1){
				//第一列：是叶子节点，创建一个button对象
				String menu1type =custommenu.getMenu1type();
				String menu1key = custommenu.getMenu1key();
				String menu1url = custommenu.getMenu1url();
				if(menu1type!=null&&menu1type.equals("click")){
					ClickButton btn1 = new ClickButton();
					btn1.setName(menu1);
					btn1.setType(menu1type);
					btn1.setKey(menu1key);
					btnBig[0]=btn1;
				}else if(menu1type!=null&&menu1type.equals("view")){
					ViewButton btn1 = new ViewButton();
					btn1.setName(menu1);
					btn1.setType(menu1type);
					btn1.setUrl(menu1url);
					btnBig[0]=btn1;
				}
			}else{
				ComplexButton mainBtn1 = new ComplexButton();
				mainBtn1.setName(menu1);
				mainBtn1.setSub_button(buttons1);
				btnBig[0]=mainBtn1;
			}
			
			if(custommenu.getIsend2()==1){
				//第二列：是叶子节点，创建一个button对象
				String menu2type =custommenu.getMenu2type();
				String menu2key = custommenu.getMenu2key();
				String menu2url = custommenu.getMenu2url();
				if(menu2type!=null&&menu2type.equals("click")){
					ClickButton btn2 = new ClickButton();
					btn2.setName(menu2);
					btn2.setType(menu2type);
					btn2.setKey(menu2key);
					btnBig[1]=btn2;
				}else if(menu2type!=null&&menu2type.equals("view")){
					ViewButton btn2 = new ViewButton();
					btn2.setName(menu2);
					btn2.setType(menu2type);
					btn2.setUrl(menu2url);
					btnBig[1]=btn2;
				}
			}else{
				ComplexButton mainBtn2 = new ComplexButton();
				mainBtn2.setName(menu2);
				mainBtn2.setSub_button(buttons2);
				btnBig[1]=mainBtn2;
			}
			
			if(custommenu.getIsend3()==1){
				//第三列：是叶子节点，创建一个button对象
				String menu3type =custommenu.getMenu3type();
				String menu3key = custommenu.getMenu3key();
				String menu3url = custommenu.getMenu3url();
				if(menu3type!=null&&menu3type.equals("click")){
					ClickButton btn3 = new ClickButton();
					btn3.setName(menu3);
					btn3.setType(menu3type);
					btn3.setKey(menu3key);
					btnBig[2]=btn3;
				}else if(menu3type!=null&&menu3type.equals("view")){
					ViewButton btn3 = new ViewButton();
					btn3.setName(menu3);
					btn3.setType(menu3type);
					btn3.setUrl(menu3url);
					btnBig[2]=btn3;
				}
			}else{
				ComplexButton mainBtn3 = new ComplexButton();
				mainBtn3.setName(menu3);
				mainBtn3.setSub_button(buttons3);
				btnBig[2]=mainBtn3;
			}
			
			
			//总菜单
			Menu menu = new Menu();
			menu.setButton(btnBig);//放入menu
			return menu;
		}else{
			return null;
		}
		
		
	}
}
