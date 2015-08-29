package cong.ruan.test;

import java.util.ArrayList;
import java.util.List;

import cong.ruan.common.pojos.Joke;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestJsonObject
{
	public static void main(String[] args)
	{
		List<St> list = new ArrayList<St>();
		
		list.add(new St("s1","m"));
		list.add(new St("s2","2"));
		
		
		JSONArray jsonObject = JSONArray.fromObject(list);
		System.out.println(jsonObject);
		
		Joke joke = new Joke();
		joke.setContent("fdfdf");
		joke.setImgUrl("fdaf");
		
		JSONObject ob = JSONObject.fromObject("{\"content\":\"fdfdf\",\"imgUrl\":\"fdaf\"}");
		System.out.println(ob.get("content"));
	}
}
