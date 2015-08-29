package cong.ruan.utils;

import cong.ruan.common.pojos.AccessToken;
import cong.ruan.common.pojos.Button;
import cong.ruan.common.pojos.ClickButton;
import cong.ruan.common.pojos.ComplexButton;
import cong.ruan.common.pojos.Menu;
import cong.ruan.common.pojos.ViewButton;

/**
 * 管理菜单
 * @author RuanCong
 * @time 2014-4-28 下午4:09:17
 */
public class MenuManager
{
	public static void main(String[] args)
	{
		AccessToken token = CommonUtil.getAccessToken();
		System.out.println("accessToken: " + token.getAccessToken());
		System.out.println(CommonUtil.createMenu(getMenu(),token.getAccessToken()));
		//accessToken: ubrQJU5qGk83NeJ2bd6v1cZhNEjIK1SZHMc0H-d8KrzL_RMJlFp3UY0n8CXVGxEO
	}
	
	private static Menu getMenu()
	{
		/*第一个一级菜单里的内容*/
		ClickButton b11 = new ClickButton();
		b11.setName("手机");
		b11.setKey(MenuKeys.MOBILE);
		b11.setType(MessageUtil.CLICK_MENU_TYPE);
		ClickButton b12 = new ClickButton();
		b12.setName("电脑");
		b12.setKey(MenuKeys.COMPUTER);
		b12.setType(MessageUtil.CLICK_MENU_TYPE);
		
		ComplexButton cButton1 = new ComplexButton();//第一个一级菜单
		cButton1.setName("科技世界");
		Button[] subButtons = {b11,b12};
		cButton1.setSub_button(subButtons);
		/* end 第一个一级菜单里的内容*/
		
		/*第二个一级菜单里的内容*/
		ClickButton b21 = new ClickButton();
		b21.setName("篮球");
		b21.setKey(MenuKeys.BASKEYBALL);
		b21.setType(MessageUtil.CLICK_MENU_TYPE);
		ClickButton b22 = new ClickButton();
		b22.setName("足球");
		b22.setKey(MenuKeys.FOOTBALL);
		b22.setType(MessageUtil.CLICK_MENU_TYPE);
		
		ComplexButton cButton2 = new ComplexButton();//第二个一级菜单
		cButton2.setName("体育世界");
		Button[] subButton2 = {b21,b22};
		cButton2.setSub_button(subButton2);
		/*第二个一级菜单里的内容*/
		
		/*第三个一级菜单里的内容*/
		ViewButton b31 = new ViewButton();
		b31.setName("获取帮助");
		b31.setType("view");
		b31.setUrl("http://www.baidu.com");
		
		ComplexButton cButton3 = new ComplexButton();//第三个一级菜单
		cButton3.setName("更多功能");
		Button[] subButton3 = {b31};
		cButton3.setSub_button(subButton3);
		/*第三个一级菜单里的内容*/
		
		Menu menu = new Menu();
		Button[] buttons = {cButton1,cButton2,cButton3};
		menu.setButton(buttons);
		
		return menu;
	}
	
}
