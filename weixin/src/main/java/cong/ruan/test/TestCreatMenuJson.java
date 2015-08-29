package cong.ruan.test;

import com.google.gson.Gson;

import cong.ruan.common.pojos.Button;
import cong.ruan.common.pojos.ClickButton;
import cong.ruan.common.pojos.ComplexButton;
import cong.ruan.common.pojos.Menu;

public class TestCreatMenuJson
{
	public static void main(String[] args)
	{
		ClickButton b11 = new ClickButton();
		b11.setName("菜单1");
		b11.setKey("11");
		b11.setType("clik");
		
		ClickButton b21 = new ClickButton();
		b21.setName("菜单2");
		b21.setKey("21");
		b21.setType("clik");
		
		ClickButton b31 = new ClickButton();
		b31.setName("菜单3");
		b31.setKey("31");
		b31.setType("clik");
		
		ComplexButton cButton = new ComplexButton();
		cButton.setName("一级菜单");
		Button[] subButtons = {b11,b21,b31};
		cButton.setSub_button(subButtons);
		
		Menu menu = new Menu();
		Button[] buttons = {b11,b21,cButton};
		menu.setButton(buttons);
		Gson gson = new Gson();
		System.out.println(gson.toJson(menu));
}
}
